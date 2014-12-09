package interfaces;
import java.util.ArrayList;
import java.util.Date;
import app.*;

public interface ManagerInterface
{
	public abstract ArrayList<Reservation> getReservations();
	public abstract ArrayList<Guest> getGuests();
	public abstract ArrayList<Room> getRooms();
	public abstract ArrayList<RoomReservation> getRoomReservations();
	public abstract ArrayList<GuestReservation> getGuestReservations();
	public abstract void setReservations(ArrayList<Reservation> reservations);
	public abstract void setGuests(ArrayList<Guest> guests);
	public abstract void setRooms(ArrayList<Room> rooms);
	public abstract void setRoomReservations(ArrayList<RoomReservation> roomReservations);
	public abstract void setGuestReservations(ArrayList<GuestReservation> guestReservations);
	public abstract void newReservation();
	public abstract void cancelReservation(Reservation reservation);
	public abstract void newGuest();
	
	//return true if room free for date
	public abstract boolean checkIfRoomFree(int roomId, Date checkInDate, Date checkOutDate);
	
	//return true if updated all params
	//pass the same params as createFullReservation, where all the params here are the fields to be updated
	public abstract boolean editReservation(Reservation reservation, int guestId, RoomReservation[] rooms);
	
	public abstract double getReservationPrice(Reservation reservation);
	
	//return true if reservation could be created
	public abstract boolean createFullReservation(Reservation reservation, int guestId, RoomReservation[] rooms );
	
	//return true if reservations overlap
	public abstract boolean checkIfReservationsOverlap(Reservation res1, Reservation res2);
	
}
