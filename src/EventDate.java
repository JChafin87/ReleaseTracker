import java.text.SimpleDateFormat;
import java.util.Calendar;


public class EventDate {
	public String eventMonth;
	public String eventDay;
	public String eventYear;
	public int eventID;
	
	
	public EventDate() {
		eventMonth = "01";
		eventDay = "02";
		eventYear ="2015";
		eventID = 20150102;
	}
	

	
	public EventDate(int y, int m, int d) {
		eventYear = String.valueOf(y);
		eventMonth = String.valueOf(m);
		eventDay = String.valueOf(d);
		eventID = y*10000+m*100+d;
		
	}
	public EventDate(int x) {
		eventDay = String.valueOf(x % 100);
		int iMonth = (x % 10000 - x%100) / 100;
		eventMonth = String.valueOf(iMonth);
		int iYear = (x % 100000000 - x%10000)/10000;
		eventYear = String.valueOf(iYear);
		eventID = x;
	}
	
	public String getEventMonth() {
		return eventMonth;
	}
	public void setEventMonth(String eventMonth) {
		this.eventMonth = eventMonth;
	}
	public String getEventDay() {
		return eventDay;
	}
	public void setEventDay(String eventDay) {
		this.eventDay = eventDay;
	}
	public String getEventYear() {
		return eventYear;
	}
	public void setEventYear(String eventYear) {
		this.eventYear = eventYear;
	}
	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("MMMMMMMM d - yyyy");
		Calendar c = Calendar.getInstance();
		c.set(Integer.valueOf(eventYear), Integer.valueOf(eventMonth)-1, Integer.valueOf(eventDay));
		
		return sdf.format(c.getTime());
	}
	public int getID() {
		return eventID;
	}

}
