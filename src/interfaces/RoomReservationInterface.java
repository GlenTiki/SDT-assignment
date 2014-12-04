package interfaces;

public interface RoomReservationInterface
{
	public abstract int getRoomNumber();
	public abstract int getReservationId();
	public abstract int getNumGuests();
	
	//get price for a particular RoomReservation.
	//get the price per person for the room and multiply by numGuests
	//Should we have the RoomReservation class directly access the list of rooms or?...
	public abstract double getPrice();
	public abstract void setRoomNumber();
	public abstract void setReservationId();
	public abstract void setNumGuests();
	public abstract void setPrice();
}
