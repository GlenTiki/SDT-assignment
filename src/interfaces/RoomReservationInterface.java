package interfaces;

public interface RoomReservationInterface
{
	public abstract int getRoomNumber();
	public abstract int getReservationId();
	public abstract int getNumGuests();
	public abstract void setRoomNumber(int roomNumber);
	public abstract void setNumGuests(int numGuests);
}
