package interfaces;

public interface RoomInterface
{
	public abstract int getRoomNumber();
	public abstract int getRoomCapacity();
	public abstract double getRoomPricePerPerson();
	public abstract String getType();
	public abstract void setRoomNumber(int number);
	public abstract void setRoomCapacity(int capacity);
	public abstract void setRoomPricePerPerson(int pricePerPerson);
	public abstract void setType(String type);
	
}
