
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Created by Daniel on 02.04.2017.
 */
public class Entry {
	Mood mood;
	// LocalDateTime dateTime;
	LocalDate date;
	LocalTime time;
	ArrayList<Activity> activities;
	
	public Entry(Mood mood) {
		this.mood = mood;
		setDate(LocalDate.now());
		setTime(LocalTime.now());
		//dateTime = LocalDateTime.now();
		activities = new ArrayList<>();
	}
	
	
	
	public Mood getMood() {
		return mood;
	}
	
	public void setMood(Mood mood) {
		this.mood = mood;
	}
	
	public ArrayList<Activity> getActivities() {
		return activities;
	}
	
	public void setActivities(ArrayList<Activity> activities) {
		this.activities = activities;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public LocalTime getTime() {
		return time;
	}
	
	public void setTime(LocalTime time) {
		this.time = time;
	}
}
