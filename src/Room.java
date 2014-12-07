import interfaces.RoomInterface;

public class Room implements RoomInterface {


	private String type;
	private int roomCapacity;
	private double roomPricePerPerson;
	private int roomNumber;

	public Room(String roomType, int roomCapacity, double roomPricePerPerson) {
		this.type = roomType;
		this.roomCapacity = roomCapacity;
		this.roomPricePerPerson = roomPricePerPerson;
		this.roomNumber = 0;
	}

	public void setRoomNumber(int number) {
		this.roomNumber = number;
	}

	public int getRoomNumber() {
		return this.roomNumber;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String name) {
		this.type = name;
	}

	public int getRoomCapacity() {
		return roomCapacity;
	}

	public void setRoomCapacity(int roomCapacity) {
		this.roomCapacity = roomCapacity;
	}

	public double getRoomPricePerPerson() {
		return roomPricePerPerson;
	}

	public void setRoomPricePerPerson(int roomPricePerPerson) {
		this.roomPricePerPerson = roomPricePerPerson;
	}

	public String toString(){
		return super.toString() + " " + roomNumber + ": " + type + ". Can hold: " + roomCapacity + ". Price per person sharing: " + roomPricePerPerson;
	}
}
