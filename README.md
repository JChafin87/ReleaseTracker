# ReleaseTracker

#Project Summary

This application allows the user to create a list of upcoming releases they are interested in. It works similar to a calendar, but somewhat different. Let's say I want to buy a DVD that's being released on March 2nd. If I add that event on a calendar, but don't have a chance to buy the DVD until a month later, there's a chance I might forget that it came out. If I add that DVD release to ReleaseTracker, it will stay in my "Newly Released" list until I've bought the DVD and removed it from my list. The application also shows a list of upcoming events that have entered into the application through the "Upcoming Releases" list.

.

#Running the Program

There are multiple ways to access this program. It can be compiled and ran with any Java IDE, but since I created the project using Eclipse, I will explain how to run the program through Eclipse. Feel free to use any Java IDE you wish.

1. [Download Eclipse](http://www.eclipse.org/downloads/packages/release/Kepler/SR2) and install it.

2. Download the git repository as a .zip file and extract it to your system.

3. Open Eclipse and select File-\>Import-\>General-\>Existing Projects into WorkSpace. Click Next, then click Browse for root directory and locate your extracted BaseballStatFinder-master. Click Next and then Finish. 

4. Click 'Run' on the toolbar to launch the application.

.

#Classes Documentation

ReleaseTracker contains 9 classes, 5 of which are GUIs.

----
###Event
----

This is a user defined class that holds all of the information for a specific release event.

####Constructor

Event()

_Creates an empty Event._

Event(String eN, EventDate eD, String eT, int rID)

_Creates an event where Event name is eN, Event date is eD, Event type is eT and Remind ID is rID._

####Attributes
| Attribute | Description|
| ------------- |:-------------:|
| public String eventName    | The name or title of the event. |
| public EventDate eventDate    | The date of the event's release (see class EventDate).     | 
| public String eventTypeName    | The category of the event.  |
| public int remindID    | An integer representation of the date to inform the user that the event has been released. The form is equal to yyyyMMdd.     | 


####Methods
| Returns | Method|
| ------------- |:-------------:|
| int    | **compareTo**(Event e) |
|      |  _A method used by the class EventList to arrange the list in chronological order. Overrides Comparable._ | 
| EventDate    | **getEventDate**() |
|      |  _Returns the value of the Event's EventDate._ |
| String    |**getEventName**() |
|      |  _Returns the Event's name or title._  |
| String    | **getEventTypeName**() |
|      |  _Returns the Event's type (category)._  |
| int    | **getRemindID**() |
|      |  _Returns the Event's remindID._ | 
| void    | **remindChange**(int i) |
|      |  _Adds the value of i to the remindID._ |
| void    |**setEventDate**(EventDate eventDate) |
|      |  _Sets the Event's Date to the passed parameter._  |
| void     | **setEventName**(String eventName) |
|      |  _Sets the Event's name to the passed parameter._  |
| void | **setEventTypeName**(String eventTypeName) |
|		| _Sets the Event's type(category) to the passed parameter._ |
| void | **setRemindID**(int remindID) |
|		| _Sets the Event's remindID to the passed parameter._ |
| String | **toString**() |
|		| _Displays the Event as a String._ |

---
###EventDate
---
Stores the date of the event's release.

####Constructor

EventDate(int y, int m, int d)

Creates a new EventDate where year = y, month = m, day = d.

EventDate(int x)

Creates an EventDate from a 8 digit integer. The value of the passed integer will be in the form of yyyyMMdd. 

####Attributes

| Attribute | Description|
| ------------- |:-------------:|
| public String eventYear | The year the event is released. |
| public String eventMonth | The month the event is released. |
| public String eventDay | The day the event is released. |
| public Integer eventID | A numerical representation of the Event's release date. The format is yyyyMMdd. (E.g. 20161107 would be November 7, 2016) |

####Methods

| Returns | Method|
| ------------- |:-------------:|
| String | **getEventDay**() |
| | _Returns the Event's day value._ |
| String | **getEventMonth**() |
| | _Returns the Event's month value._ |
| String | **getEventYear**() |
| | _Returns the Event's year value._ |
| Integer | **getID**() |
| | _Return's the Event's eventID._ |
| void | **setEventDay**(String eventDay) |
| | _Sets the Event's day to the passed value._ |
| void | **setEventMonth**(String eventMonth) |
| | _Sets the Event's month to the passed value._ |
| void | **setEventYear**(String eventYear) |
| | _Sets the Event's year to the passed value._ |
| String | **toString**() |
| | _Displays the EventDate as a String._ |

---
###EventList
---

A class that contains a collection of Event objects.

####Constructors

EventList()

Initializes an empty EventList

EventList(Event e)

Initializes a new EventList and adds Event e to the list.

####Attributes

| Attribute | Description|
| ------------- |:-------------:|
| public LinkedList\<Event\> eventList | A collection of Events to populate the GUIs. |
| public boolean empty| A value that equals true if our EventList is empty. |

####Methods

| Returns | Method|
| ------------- |:-------------:|
| void | **add**(Event ev) |
| | _Adds a new Event to the EventList._ |
| LinkedList\<Event\> | **getList**() |
| | _Returns the EventList eventList attribute._ |
| void | **readFile**() |
| | _Reads from inputfile "events.dat" and saves the data to the EventList._ |
| void | **remove**(Event ev) |
| | _Checks if Event ev is in the EventList and removes it._ |
| void | **writeFile**() |
| | _Writes and replaces the current data to "events.dat" |


---
###TypeList
---

A list of the user's event types or categories. This class is used to populate JComboBoxes with the user's saved types.

####Constructor

public TypeList()

Initializes an empty TypeList.

####Attributes

| Attribute | Description|
| ------------- |:-------------:|
| LinkedList\<String\> types | A list of the user's saved types (categories) |


















