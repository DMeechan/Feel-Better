import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainController extends Stage {
	private final StackPane stackPane;
	Scene scene;
	EntriesController entriesController;
	
	public MainController() {
		stackPane = new StackPane();
		// test
		loadEntriesFXML();
		start();
		
		loadScene();
	}
	
	private void start() {
		User user = new User("Daniel");
		
		loadUser(user);
	}
	
	private void loadUser(User user) {
		
	}
	
	private void loadEntriesFXML() {
		FXMLLoader entriesFXMLLoader = new FXMLLoader(getClass().getResource("EntriesView.fxml"));
		
		try {
			stackPane.getChildren().add(entriesFXMLLoader.load());
		} catch (IOException e) {
			Main.outputError(e);
		}
		
		entriesController = entriesFXMLLoader.getController();
		
	}
	
	private void loadScene() {
		this.setScene(new Scene(stackPane));
		this.show();
		
		// ensure the window closes correctly
		this.setOnCloseRequest(v -> {
			Platform.exit();
			System.exit(0);
		});
		
		this.setTitle("Feel Better");
		this.setResizable(false);
		
		// try to load application icon
		// this implementation makes the file handling platform-agnostic
		// so the icon should work on different platforms
		// (however, setting the icon Dock icon on Mac requires making additional calls)
		try {
			//this.getIcons().add(new Image(new FileInputStream("resources/icon.png")));
			this.getIcons().add(new Image(this.getClass().getResourceAsStream("icon.png")));
			
		} catch (Exception e) {
			System.out.println("Error: application icon not found");
			Main.outputError(e);
		}
	}
	
}
