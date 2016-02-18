import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class EventList {
	public LinkedList<Event> eventList;
	public boolean empty = true;
	
	
	public EventList(){
		
	
	}
	
	public EventList(Event e) {
		LinkedList<Event> whyList = new LinkedList<Event>();
		Event whyEvent = new Event();
		EventDate whyDate= new EventDate();
		String whyName = e.getEventName();
		String whyType = e.getEventTypeName();
		int whyID = e.getRemindID();
		whyEvent.setEventDate(whyDate);
		whyEvent.setEventName(whyName);
		whyEvent.setEventTypeName(whyType);
		whyEvent.setRemindID(whyID);	
		whyList.add(whyEvent);
		this.empty = false;
		this.eventList =whyList;
	}
	
	public void readFile() {
		String fileName = "events.dat";
        String line = null;
        LinkedList<Event> testList = new LinkedList<Event>();
        try {
            // Reads from events.dat and stores to EventList
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Event e = new Event();
            EventDate d= new EventDate();
            while((line = bufferedReader.readLine()) != null) {
            	d = new EventDate(Integer.valueOf(line));
            	line = bufferedReader.readLine();
            	e = new Event();
            	e.setEventName(line);
            	e.setEventDate(d);
            	line = bufferedReader.readLine();
            	e.setEventTypeName(line);
            	line = bufferedReader.readLine();
            	e.setRemindID(Integer.valueOf(line));
            	testList.add(e);
            }
        bufferedReader.close();    
        }
       catch(FileNotFoundException ex) {
           System.out.println("Unable to open file '" + fileName + "'");                
       }
       catch(IOException ex) {
           System.out.println("Error reading file '"+ fileName + "'");
       }
        this.empty=false;
       eventList = testList; 
	}
	
	
	public void add(Event ev) {
		LinkedList<Event> whyWhyWhy = new LinkedList<Event>();
		whyWhyWhy = this.eventList;
		if(empty) {
			LinkedList<Event> whyList = new LinkedList<Event>();
			Event whyEvent = new Event();
			EventDate whyDate= new EventDate();
			String whyName = ev.getEventName();
			String whyType = ev.getEventTypeName();
			int whyID = ev.getRemindID();
			whyEvent.setEventDate(whyDate);
			whyEvent.setEventName(whyName);
			whyEvent.setEventTypeName(whyType);
			whyEvent.setRemindID(whyID);	
			whyList.add(whyEvent);
			this.eventList =whyList;
			
		}
		
		else {
			LinkedList<Event> testList = new LinkedList<Event>();
			for(int i=0;i<this.getList().size(); i++) {
					testList.add(this.getList().get(i));
			}
			empty=false;
			testList.add(ev);
			eventList = testList;
		}
	}

	public void remove(Event ev){
		LinkedList<Event> updatedList = new LinkedList<Event>();
		updatedList = this.getList();
		LinkedList<Event> returnedList = new LinkedList<Event>();
		for (int i = 0; i<updatedList.size(); i++)
			if(!(ev.getEventName().equals(updatedList.get(i).getEventName())) && ev.getRemindID() != updatedList.get(i).getRemindID()) {
				returnedList.add(updatedList.get(i));
				
			}
		this.eventList = returnedList;
		
	}
	
	
	


	public void writeFile() {
		LinkedList<Event> e = this.eventList;
		try{
		PrintWriter writer = new PrintWriter("events.dat", "UTF-8");
		for (int i = 0; i<e.size(); i++) {
			writer.println(e.get(i).getEventDate().getID());
			writer.println(e.get(i).getEventName());
			writer.println(e.get(i).getEventTypeName());
			writer.println(e.get(i).getRemindID());
		}
		writer.close();
		}
		catch (Exception exc) {
			
		}
	}
	
	public LinkedList<Event> getList() {
		return eventList;
	}
	

}
