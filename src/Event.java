import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Event implements Comparable<Event> {
	
	public String eventName;
	public EventDate eventDate;
	public String eventTypeName;
	public int remindID;
	
	
	public String getEventName() {
		return eventName;
	}
	public Event(String e, EventDate d, String t, int r) {
		this.eventName = e;
		this.eventDate = d;
		this.eventTypeName =t;
		this.remindID = r;
	}
	public Event() {
		
	}
	
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public String getEventTypeName() {
		return eventTypeName;
	}
	public void setEventTypeName(String eventTypeName) {
		this.eventTypeName = eventTypeName;
	}
	public EventDate getEventDate() {
		return eventDate;
	}
	public void setEventDate(EventDate eventDate) {
		this.eventDate = eventDate;
	}
	public int getRemindID() {
		return remindID;
	}
	public void setRemindID(int remindID) {
		this.remindID = remindID;
	}
	
	public int compareTo(Event e) {
		int comparedEvent = e.remindID;
		if (this.remindID > comparedEvent) {
			return 1;
		}
		else if (this.remindID == comparedEvent) {
			return 0;
		}
		else {
			return -1;
		}
	}
	private int isRemoved(String e) {
		if (e==this.eventTypeName) {
			return 1;
		}
		else {
			return 0;
		}
			
		
	}
	private void remind(int i) {
		remindID = this.remindID + i;
	}
	
	
	public String toString() {
		
		return eventDate.toString() + ": " + eventName + " - " + eventTypeName;
	}
	
	}
	
	

