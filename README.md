# ReleaseTracker

#Project Summary

This application allows the user to create a list of upcoming releases they are interested in. It works similar to a calendar, but somewhat different. Let's say I want to buy a DVD that's being released on March 2nd. If I add that event on a calendar, but don't have a chance to buy the DVD until a month later, there's a chance I might forget that it came out. If I add that DVD release to ReleaseTracker, it will stay in my "Newly Released" list until I've bought the DVD and/or removed it from my list. The application also shows a list of upcoming events that the user has saved in the "Upcoming Releases" list.

.

#Running the Program

The program requires a compiler compliance level of Java 1.7 to run.

To execute the program simply download the repository, compile the code, and run.

.

#Classes Documentation

ReleaseTracker contains 9 classes, 5 of which are GUIs.

----
###Class: Event
----

This is a user defined class that holds all of the information for a specific release event.

####Constructor

public Event()

_Creates an empty Event._

public Event(String eN, EventDate eD, String eT, int rID)

_Creates an event where Event name is eN, Event date is eD, Event type is eT and Remind ID is rID._

####Attributes
| Attribute | Description|
| ------------- |:-------------:|
| public String eventName    | The name or title of the event. |
| public EventDate eventDate    | The date of the event's release (see class EventDate).     | 
| public String eventTypeName    | The type, or category, of the event.  |
| public int remindID    | An integer representation of the date. The format is yyyyMMdd.     | 


####Methods
| Returns | Method|
| ------------- |:-------------:|
| int    | **compareTo**(Event e) |
|      |  _A method used by the class EventList to arrange the list in chronological order. Overrides Comparable Class._ | 
| EventDate    | **getEventDate**() |
|      |  _Returns the value of the Event's eventDate._ |
| String    |**getEventName**() |
|      |  _Returns the Event's eventName._  |
| String    | **getEventTypeName**() |
|      |  _Returns the Event's eventTypeName._  |
| int    | **getRemindID**() |
|      |  _Returns the Event's remindID._ | 
| void    | **remindChange**(int i) |
|      |  _Adds the value of i to the Event's remindID._ |
| void    |**setEventDate**(EventDate eventDate) |
|      |  _Sets the Event's eventDate to the passed parameter._  |
| void     | **setEventName**(String eventName) |
|      |  _Sets the Event's eventName to the passed parameter._  |
| void | **setEventTypeName**(String eventTypeName) |
|		| _Sets the Event's eventTypeName to the passed parameter._ |
| void | **setRemindID**(int remindID) |
|		| _Sets the Event's remindID to the passed parameter._ |
| String | **toString**() |
|		| _Displays the Event as a String._ |

---
###Class: EventDate
---

This is a user defined class that holds all of the information for a specific release event date.

####Constructor

public EventDate(int y, int m, int d)

Creates a new EventDate where year = y, month = m, day = d.

public EventDate(int x)

Creates an EventDate from a 8 digit integer. The value of the passed integer will be in the format: yyyyMMdd. (E.g. July 4, 2016 would be "20160704")  

####Attributes

| Attribute | Description|
| ------------- |:-------------:|
| public String eventYear | The year the event is released. |
| public String eventMonth | The month the event is released. |
| public String eventDay | The day the event is released. |
| public Integer eventID | A numerical representation of the Event's release date. The format is yyyyMMdd. (E.g. November 7, 2016 would be "20161107") |

####Methods

| Returns | Method|
| ------------- |:-------------:|
| String | **getEventDay**() |
| | _Returns the EventDate's eventDay value._ |
| String | **getEventMonth**() |
| | _Returns the EventDate's eventMonth value._ |
| String | **getEventYear**() |
| | _Returns the EventDate's eventYear value._ |
| Integer | **getID**() |
| | _Return's the EventDate's eventID._ |
| void | **setEventDay**(String eventDay) |
| | _Sets the EventDate's eventDay to the passed value._ |
| void | **setEventMonth**(String eventMonth) |
| | _Sets the EventDate's eventMonth to the passed value._ |
| void | **setEventYear**(String eventYear) |
| | _Sets the EventDate's eventYear to the passed value._ |
| String | **toString**() |
| | _Displays the EventDate as a String._ |

---
###Class: EventList
---

A class that contains a collection of Event objects.

####Constructors

public EventList()

Initializes an empty EventList.

public EventList(Event e)

Initializes a new EventList and adds Event e to the list.

####Attributes

| Attribute | Description|
| ------------- |:-------------:|
| public LinkedList\<Event\> eventList | A collection of Events used to populate the GUIs. |
| public boolean empty| A value that equals true if the EventList is empty. |

####Methods

| Returns | Method|
| ------------- |:-------------:|
| void | **add**(Event ev) |
| | _Adds a new Event ev to the EventList._ |
| LinkedList\<Event\> | **getList**() |
| | _Returns the EventList's eventList attribute._ |
| void | **readFile**() |
| | _Reads from input file "events.dat" and saves the data to the EventList._ |
| void | **remove**(Event ev) |
| | _Checks if Event ev is in the EventList and removes it._ |
| void | **writeFile**() |
| | _Writes and replaces the current data to "events.dat"._ |


---
###Class: TypeList
---

A list of the user's event types or categories. This class is used to populate JComboBoxes with the user's saved types.

####Constructor

public TypeList()

Initializes an empty TypeList.

####Attributes

| Attribute | Description|
| ------------- |:-------------:|
| LinkedList\<String\> types | A list of the user's saved types (categories). |

####Methods

| Returns | Method|
| ------------- |:-------------:|
| void | **add**(String s) |
| | _Adds a new type "s" to TypeList._ |
| LinkedList\<String\> | **getTypes**() |
| | _Returns the TypeList's typeList attribute._ |
| void | **readFile**() |
| | _Reads the user's saved types from the input file "types.dat"._ |
| void | **remove**(int i) |
| | _Removes the type from typeList at index i._ |
| void |**remove**(String s) |
| | _Removes the type that is equal to String s from the TypeList._ |
| void | **setTypes**(LinkedList\<String\> t)|
| | _Set the attribute "types" to LinkedList t._ |
| String [] | **toStringArray**() |
| | _Converts the TypeList's "types" attribute to a String Array._ | 
| void | **writeFile**() |
| | _Writes and replaces the data in file "types.dat" with the current TypeList data._ |

---
###Class: ReleaseTrackerGUI
---

This is the main GUI of ReleaseTracker. 

####Constructor

public ReleaseTrackerGUI() 

Initializes a new ReleaseTrackerGUI frame.

---
###AddEventGUI
---

This is the GUI where the user adds a new event to be tracked.

####Constructor

AddEventGUI()

Creates new AddEventGUI window.

####Attributes

| Attribute | Description |
| ------------- |:-------------:|
| private JFrame frame | The JFrame that holds the window's Swing objects. |
| private JTextField nameField | JTextField that holds the name of the event to be added. |
| public JComboBox monthBox | JComboBox that holds the event's month value. |
| public JComboBox dayBox | JComboBox that holds the event's day value. |
| public JComboBox yearBox | JComboBox that holds the event's year value. |
| public JComboBox typeBox | JCombBox that holds the event's type value. |
| public JButton btnAddEvent | JButton that captures the values of the JComboBoxes and adds event to an EventList. |
| public int[] comboValues | A size three array that holds the value of yearBox, monthBox, dayBox. |
| public String typeSelected | Holds the value of typeBox. Used to ensure the user has selected a valid type. |
| public int dateInt | An 8-digit value that represents the Event's date (yyyyMMdd). Used to create the EventDate object for the event to be added. |

####Methods

| Returns | Method|
| ------------- |:-------------:|
| void | **actionPerformed**(ActionEvent e) |
| | _Overrides method in ActionListener. Used to capture the user's interactions with the frame's Swing objects._ |
| void | **initialize**() |
| | _Initializes the AddEventGUI._ |
| void | **openAE**() |
| | _Method to initialize AddEventGUI from a separate JFrame._ |


---
###Class: EditTypeGUI
---

The GUI that displays the user's saved types. Allows them to add a new event type or remove an old one. It implements the class ActionListener.

###Constructor

public EditTypeGUI()

Creates a new instance of the EditTypeGUI.

###Attributes

| Attribute | Description |
| ------------- |:-------------:|
| private JPanel contentPane | A JPanel to display objects. |
| private JTextField newTypeField | A JTextField that holds the value of the user's new type to be added to TypeList |
| private JButton btnAdd | A JButton that adds the user's new event type from newTypeField. |
| private JComboBox typeBox | A JComboBox that holds the user's previous event types. |
| private JButton btnRemove | A JButton that removes the event type in typeBox from the user's saved event types. |
| private String type | The value of typeBox. Used to ensure the user has selected a valid type to remove. |
| private JFrame frame | The JFrame that holds the window's Swing objects. |

####Methods

| Returns | Method|
| ------------- |:-------------:|
| void | **actionPerformed**(ActionEvent e) |
| | _Overrides method in ActionListener. Used to capture the user's interactions with the frame's Swing objects._ |
| void | **openET**() |
| | _Method to initialize EditTypeGUI from a separate JFrame._ |

---
###Class: NewReleaseGUI
---

A window that shows the user's saved events, where the event's release date is on or  before the current calendar day. It implements the Class ActionListener.

####Constructor

public NewReleaseGUI()

Creates a new NewReleaseGUI window.

####Attributes

| Attribute | Description |
| ------------- |:-------------:|
| private JPanel contentPane | The container of the window's Swing objects. |
| private JTable userTable | A JTable that holds the TableModel information. |
| private DefaultTableModel nrTable | A DefaultTableModel that holds the user's newly released Events. |
| private JButton btnRemoveEvent | A JButton that allows the user to remove the event they've selected from userTable. |
|private LinkedList\<Event\> nrList | A LinkedList that holds the user's newly released events. This attribute is needed if the user selects to remove an event from the table. |

####Methods

| Returns | Method|
| ------------- |:-------------:|
| void | **actionPerformed**(ActionEvent e) |
| | _Overrides method in ActionListener. Used to capture the user's interactions with the frame's Swing objects._ |
| void | **openNR**() |
| | _Method to initialize a NewReleaseGUI instance from a separate JFrame._ |


---
###Class: UpcomingEventGUI
---

A window that shows the user's saved events, where the event's release date is after the current calendar day. It implements the Class ActionListener.

####Constructor

public UpcomingEventGUI()

Creates a new UpcomingEventGUI window.

####Attributes

| Attribute | Description |
| ------------- |:-------------:|
| private JPanel contentPane | The container of the window's Swing objects. |
| private JTable userTable | A JTable that holds the DefaultTableModel information. |
| private DefaultTableModel ueTable | A DefaultTableModel that holds the user's upcoming Events. |
| private JButton btnAddEvent | A JButton that opens a new AddEventGUI. |
| private JButton btnRemoveEvent | A JButton that allows the user to remove the event they've selected from userTable. |
|private LinkedList\<Event\> ueList | A LinkedList that holds the user's upcoming releases Events. This is needed if the user selects to remove an event from the table. |

####Methods

| Returns | Method|
| ------------- |:-------------:|
| void | **actionPerformed**(ActionEvent e) |
| | _Overrides method in ActionListener. Used to capture the user's interactions with the frame's Swing objects._ |
| void | **openUE**() |
| | _Method to initialize an UpcomingEventGUI instance from a separate JFrame._ |


-
