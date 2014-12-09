package interfaces;
import java.util.ArrayList;
import java.util.Date;


public interface ManagerInterface
{
	public abstract ArrayList<? extends ReservationInterface> getReservations();
	public abstract ArrayList<? extends GuestInterface> getGuests();
	public abstract ArrayList<? extends RoomInterface> getRooms();
	public abstract ArrayList<? extends RoomReservationInterface> getRoomReservations();
	public abstract ArrayList<? extends GuestReservationInterface> getGuestReservations();
	public abstract void setReservations(ArrayList<? extends ReservationInterface> reservations);
	public abstract void setGuests(ArrayList<? extends GuestInterface> guests);
	public abstract void setRooms(ArrayList<? extends RoomInterface> rooms);
	public abstract void setRoomReservations(ArrayList<? extends RoomReservationInterface> roomReservations);
	public abstract void setGuestReservations(ArrayList<? extends GuestReservationInterface> guestReservations);
	public abstract void newReservation();
	public abstract void editReservation();
	public abstract void cancelReservation();
	public abstract void newGuest();
	public abstract void checkIfRoomFree(int roomId, Date checkInDate, Date checkOutDate);
	public abstract <T extends RoomReservationInterface> double getReservationPrice(T reservation);
	
}
