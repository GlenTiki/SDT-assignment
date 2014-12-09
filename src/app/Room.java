package app;
import interfaces.RoomInterface;

public class Room implements RoomInterface {


	private int roomCapacity;
	private double roomPricePerPerson;
	private int roomNumber;

	public Room(int roomNumber, double roomPricePerPerson, int roomCapacity) {
		this.roomCapacity = roomCapacity;
		this.roomPricePerPerson = roomPricePerPerson;
		this.roomNumber = roomNumber;
	}

	public int getRoomNumber() {
		return this.roomNumber;
	}
	

	public int getRoomCapacity() {
		return roomCapacity;
	}

	public void setRoomCapacity(int roomCapacity) {
		if (roomCapacity > 0)
			this.roomCapacity = roomCapacity;
	}

	public double getRoomPricePerPerson() {
		return roomPricePerPerson;
	}

	public void setRoomPricePerPerson(double roomPricePerPerson) {
		if (roomPricePerPerson > 0)
			this.roomPricePerPerson = roomPricePerPerson;
	}

	public String toString(){
		return "Room Number: " + roomNumber + "\nCan hold: " + roomCapacity + "\nPrice per person sharing: " + roomPricePerPerson;
	}
}
