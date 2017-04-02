import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.io.IOException;

public class EntryCell extends HBox {
	private Entry entry;
	@FXML private JFXButton moodIconButton, deleteButton;
	@FXML private JFXDatePicker datePicker;
	@FXML private JFXTimePicker timePicker;
	@FXML private Label dayOfWeekLabel;
	// @FXML private JFXTextField activitiesTextfield;
	
	public EntryCell(Entry entry) {
		this.entry = entry;
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EntryCell.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		
		try {
			fxmlLoader.load();
		} catch (IOException e) {
			//System.out.println("Could not load EntryCell for entry at: " + entry.getDateTime().toString());
			Main.outputError(e);
		}
		
		updateValues();
		updateColors();
	}
	
	public void updateValues() {
		datePicker.setValue(entry.getDate());
		timePicker.setValue(entry.getTime());
		dayOfWeekLabel.setText(entry.getDate().getDayOfWeek().toString());
		
		// TODO: Add graphic depending on mood rating (1 - 5)
		moodIconButton.setGraphic(null);
		
	}
	
	public void updateColors() {
		datePicker.setDefaultColor(getMoodFxColor());
		timePicker.setDefaultColor(getMoodFxColor());
		
		String c = colorToHex(getMoodFxColor());
		String t = colorToHex(Color.TRANSPARENT);
		
		datePicker.setStyle("-fx-highlight-text-fill: " + c);
		datePicker.setStyle("-fx-text-fill: " + c);
		datePicker.setStyle("-jfx-focus-color: " + c);
		datePicker.setStyle("-jfx-unfocus-color: " + t);
		
		timePicker.setStyle("-fx-highlight-text-fill: " + c);
		timePicker.setStyle("-fx-text-fill: " + c);
		timePicker.setStyle("-jfx-focus-color: " + c);
		timePicker.setStyle("-jfx-unfocus-color: " + t);
		
		dayOfWeekLabel.setStyle("-fx-text-fill: " + c);
		
		setStyle("-jfx-default-color: " + c);
		
		// TODO: Remove this later when it uses icons only
		moodIconButton.setTextFill(getMoodFxColor());
	}
	
	@FXML public void editActivities() {
		
	}
	
	@FXML public void editDate() {
		entry.setDate(datePicker.getValue());
	}
	
	@FXML public void editTime() {entry.setTime(timePicker.getValue());}
	
	@FXML public void editMoodState() {
		// need to do more here
		updateColors();
	}
	
	@FXML public void deleteEntry() {}
	
	@FXML public void showActionButtons() {
		deleteButton.setVisible(true);
	}
	
	@FXML public void hideActionButtons() {
		deleteButton.setVisible(false);
	}
	
	public javafx.scene.paint.Color getMoodFxColor() {
		java.awt.Color awtColor = entry.getMood().getColor();
		return javafx.scene.paint.Color.rgb(awtColor.getRed(), awtColor.getGreen(), awtColor.getBlue(), awtColor.getAlpha() / 255.0);
		
	}
	
	private String colorToHex(Color colour) {
		return String.format("#%02X%02X%02X",
				(int) (colour.getRed() * 255),
				(int) (colour.getGreen() * 255),
				(int) (colour.getBlue() * 255));
	}
	
}
