import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController extends Stage {
	private final StackPane stackPane;
	Scene scene;
	EntriesController entriesController;
	
	public MainController() {
		stackPane = new StackPane();
		
		loadEntriesFXMLLoader();
		run();
	}
	
	private void run() {
		User user = new User("Daniel");
		
		loadUser(user);
	}
	
	private void loadUser(User user) {
		
	}
	
	private void loadEntriesFXMLLoader() {
		FXMLLoader entriesFXMLLoader = new FXMLLoader(getClass().getResource("EntriesView.fxml"));
		
		try {
			stackPane.getChildren().add(entriesFXMLLoader.load());
		} catch (IOException e) {
			Main.outputError(e);
		}
		
		entriesController = entriesFXMLLoader.getController();
		
	}
	
	private void loadScene() {
		this.setScene(scene);
		this.show();
		
		// ensure the window closes correctly
		this.setOnCloseRequest(v -> {
			Platform.exit();
			System.exit(0);
		});
		
		this.setTitle("Snake!");
		this.setResizable(false);
		
		// try to load application icon
		// this implementation makes the file handling platform-agnostic
		// so the icon should work on different platforms
		// (however, setting the icon Dock icon on Mac requires making additional calls)
		try {
			this.getIcons().add(new Image(this.getClass().getResourceAsStream("icon.png")));
			//Icon made by freepik.com and flaticon.com
			// Flaticon is licensed by Creative Commons 3.0 BY
			
		} catch (Exception e) {
			System.out.println("Error: application icon not found");
			Main.outputError(e);
		}
	}
	
}
