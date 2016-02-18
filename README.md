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

ReleaseTracker contains 10 classes, 5 of which are GUIs.

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
| public int remindID    | An integer representation of the date to inform the user that the event has been released.     | 


####Methods
| Returns | Method|
| ------------- |:-------------:|
| String     | getEventName() |
|      |  _A method that reads all of the players’ name data from the input file “MasterCurrent.csv” and stores these values into the “players” attribute._  | 
| void     | **readStats**(String yearValue) |
|      |  _A method that reads the players’ stats from the input file “BattingCurrent.csv” and saves these values to the “stats” attribute. yearValue represents the year value of the stats you want to return. (i.e. if yearValue = “1997”, “stats” will be all entries where the year is 1997.)_  |
| String[]    | **findPlayer**(String playerID) |
|      |  _A method that returns a player’s name(first and last) by passing his unique playerID._  |
| LinkedList\<String[]\>     | **findPlayers**(float[] paramValues) |
|      |  _A method that returns a Linked List of player stats that match the paramValues. (See Class BasePlayerFinder for more info on “paramValues”)._  |



