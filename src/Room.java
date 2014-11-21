import java.util.ArrayList;

public class Room {

	private ArrayList<Reservation> reservations;

	private String name;
	private int roomCapacity;
	private int roomPricePerPerson;
	private int roomNumber;

	public Room(String roomName, int roomCapacity, int roomPricePerPerson) {
		this.name = roomName;
		this.roomCapacity = roomCapacity;
		this.roomPricePerPerson = roomPricePerPerson;
		this.reservations = new ArrayList<Reservation>();
		this.roomNumber = 0;
	}

	public void addReservation(Reservation reservation) {
		reservations.add(reservation);
	}

	public void deleteReservation(Reservation reservation) {
		reservations.remove(reservation);
	}

	public ArrayList<Reservation> getReservations() {
		return reservations;
	}

	public void setRoomNumber(int number) {
		this.roomNumber = number;
	}

	public int getRoomNumber() {
		return this.roomNumber;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRoomCapacity() {
		return roomCapacity;
	}

	public void setRoomCapacity(int roomCapacity) {
		this.roomCapacity = roomCapacity;
	}

	public int getRoomPricePerPerson() {
		return roomPricePerPerson;
	}

	public void setRoomPricePerPerson(int roomPricePerPerson) {
		this.roomPricePerPerson = roomPricePerPerson;
	}

	public void setReservations(ArrayList<Reservation> reservations) {
		this.reservations = reservations;
	}

	public void delete() {
		for (int i = reservations.size(); i >= 0; i--) {
			Reservation res = reservations.get(i);
			res.deleteReservation();
		}
	}

	public String toString(){
		return super.toString() + " " + roomNumber + ": " + name + ". Can hold: " + roomCapacity + ". Price per person sharing: " + roomPricePerPerson;
	}
}
