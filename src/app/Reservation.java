package app;
import java.util.ArrayList;
import java.util.Date;


public class Reservation {
	
	private int reservationNumber;
	
	private ArrayList<Room> rooms;
	private Guest guest;
	
	private Date checkInDate;
	private Date checkOutDate;
	
	public Reservation(int number, Guest guest, Room[] rooms, Date checkIn, Date checkOut){
		this.reservationNumber = number;
		
		this.guest = guest;
		this.rooms = new ArrayList<Room>(java.util.Arrays.asList(rooms));
		
		this.checkInDate = checkIn;
		this.checkOutDate = checkOut;
		
		updateRefs();
	}
	
	private void updateRefs(){
		guest.addReservation(this);
		for(Room room: rooms){
			room.addReservation(this);
		}
	}
	
	public void deleteReservation(){
		guest.deleteReservation(this);
		for(Room room: rooms){
			room.deleteReservation(this);
		}
	}
	
	public Guest getGuest(){
		return guest;
	}
	
	public ArrayList<Room> getRooms(){
		return rooms;
	}
	
	public void setGuest(Guest guest){
		this.guest.deleteReservation(this);
		this.guest = guest;
		this.guest.addReservation(this);
	}
	
	public void setRooms(ArrayList<Room> rooms){
		this.rooms = rooms;
	}
	
	public void addRoom(Room room){
		this.rooms.add(room);
		room.addReservation(this);
	}
	
	public void removeRoom(Room room){
		this.rooms.remove(room);
		room.deleteReservation(this);
	}

	
	public int getReservationNumber() {
		return reservationNumber;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

}
