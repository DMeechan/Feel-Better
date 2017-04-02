import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Daniel on 02.04.2017.
 */
public class User {
	
	String name;
	BooleanProperty reminderOn = new SimpleBooleanProperty();
	LocalTime reminderTime;
	
	ArrayList<Mood> moods;
	LinkedList<Entry> entryLog;
	LinkedList<Activity> activities;
	LinkedList<Source> sources;
	
	public User(String name) {
		this.name = name;
		reminderOn.setValue(false);
		reminderTime = LocalTime.of(20,00);
		
		moods = new ArrayList<>();
		entryLog = new LinkedList<>();
		activities = new LinkedList<>();
		sources = new LinkedList<>();
		
	}
	
}
