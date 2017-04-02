import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by Daniel on 02.04.2017.
 */
public class Entry {
	Mood mood;
	LocalDateTime dateTime;
	ArrayList<Activity> activities;
	ArrayList<Source> sources;
	
	public Entry(Mood mood) {
		this.mood = mood;
		dateTime = LocalDateTime.now();
		activities = new ArrayList<>();
		sources = new ArrayList<>();
	}
	
	
	
	public Mood getMood() {
		return mood;
	}
	
	public void setMood(Mood mood) {
		this.mood = mood;
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	public ArrayList<Activity> getActivities() {
		return activities;
	}
	
	public void setActivities(ArrayList<Activity> activities) {
		this.activities = activities;
	}
	
	public ArrayList<Source> getSources() {
		return sources;
	}
	
	public void setSources(ArrayList<Source> sources) {
		this.sources = sources;
	}
}
