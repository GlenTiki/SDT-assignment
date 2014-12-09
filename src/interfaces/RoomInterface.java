package interfaces;

public interface RoomInterface
{
	public abstract int getRoomNumber();
	public abstract int getRoomCapacity();
	public abstract double getRoomPricePerPerson();
	public abstract void setRoomCapacity(int capacity);
	public abstract void setRoomPricePerPerson(double pricePerPerson);
	
}
