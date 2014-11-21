import java.util.ArrayList;
import java.util.Collections;

public class DataManager {
	ArrayList<Reservation> reservations;
	ArrayList<Guest> guests;
	ArrayList<Room> rooms;

	public DataManager() {
		this.reservations = new ArrayList<Reservation>();
		this.guests = new ArrayList<Guest>();
		this.rooms = new ArrayList<Room>();
	}

	public void addReservation(Reservation res) {
		this.reservations.add(res);
	}

	public void deleteReservation(Reservation res) {
		res.deleteReservation();
		this.reservations.remove(res);
	}

	public void addRoom(Room room) {
		this.rooms.add(room);
	}

	public void deleteRoom(Room room) {
		ArrayList<Reservation> roomReservations = room.getReservations();
		for (Reservation res : roomReservations) {
			deleteReservation(res);
		}
		this.rooms.remove(room);
	}

	public void addGuest(Guest guest) {
		this.guests.add(guest);
	}

	public void deleteGuest(Guest guest) {
		ArrayList<Reservation> guestReservations = guest.getReservations();
		for (Reservation res : guestReservations) {
			deleteReservation(res);
		}
		this.guests.remove(guest);
	}
	
	public void finaliseRooms(){
		Collections.shuffle(this.rooms);
		int i = 1;
		for(Room room: rooms){
			room.setRoomNumber(i++);
		}
	}
	
	private void showRooms() {
		for(Room room : rooms){
			System.out.println(room.toString());
		}
	}
}
