import interfaces.RoomReservationInterface;



public class RoomReservation implements RoomReservationInterface
{
	
	private int roomNumber;
	private int reservationId;
	private int numGuests;

	public RoomReservation(int roomNumber, int reservationId, int numGuests){
		this.roomNumber = roomNumber;
		this.reservationId = reservationId;
		this.numGuests = numGuests;
	}

	@Override
	public int getRoomNumber() {
		return this.roomNumber;
	}

	@Override
	public int getReservationId() {
		return this.reservationId;
	}

	@Override
	public int getNumGuests() {
		return this.numGuests;
	}

	@Override
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	@Override
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	@Override
	public void setNumGuests(int numGuests) {
		this.numGuests = numGuests;
	}
}
