
public class EventType {
	public String eventTypeName;
	public int typeID;
	public String getEventTypeName() {
		return eventTypeName;
	}
	public EventType(String s, int t){
		eventTypeName = s;
		typeID = t;
	}
	public void setEventTypeName(String eventTypeName) {
		this.eventTypeName = eventTypeName;
	}
	public int getTypeID() {
		return typeID;
	}
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	
	public String toString() {
		return eventTypeName;
	}
}

