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
	public abstract void editReservation();
	public abstract void cancelReservation();
	public abstract void newGuest();
	public abstract void checkIfRoomFree(int roomId, Date checkInDate, Date checkOutDate);
	public abstract double getReservationPrice(Reservation reservation);
	
}
