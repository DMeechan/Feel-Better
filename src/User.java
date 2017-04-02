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
	LinkedList<Entry> entries;
	LinkedList<Activity> activities;
	LinkedList<Source> sources;
	
	public User(String name) {
		setName(name);
		setReminderOn(false);
		setReminderTime(LocalTime.of(20,00));
		
		moods = new ArrayList<>();
		entries = new LinkedList<>();
		activities = new LinkedList<>();
		sources = new LinkedList<>();
		
	}
	
	///////////////
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isReminderOn() {
		return reminderOn.get();
	}
	
	public BooleanProperty reminderOnProperty() {
		return reminderOn;
	}
	
	public void setReminderOn(boolean reminderOn) {
		this.reminderOn.set(reminderOn);
	}
	
	public LocalTime getReminderTime() {
		return reminderTime;
	}
	
	public void setReminderTime(LocalTime reminderTime) {
		this.reminderTime = reminderTime;
	}
	
	public ArrayList<Mood> getMoods() {
		return moods;
	}
	
	public void setMoods(ArrayList<Mood> moods) {
		this.moods = moods;
	}
	
	public LinkedList<Entry> getEntries() {
		return entries;
	}
	
	public void setEntries(LinkedList<Entry> entries) {
		this.entries = entries;
	}
	
	public LinkedList<Activity> getActivities() {
		return activities;
	}
	
	public void setActivities(LinkedList<Activity> activities) {
		this.activities = activities;
	}
	
	public LinkedList<Source> getSources() {
		return sources;
	}
	
	public void setSources(LinkedList<Source> sources) {
		this.sources = sources;
	}
}
