package app;
import interfaces.GuestReservationInterface;



public class GuestReservation implements GuestReservationInterface
{
	private int guestId;
	private int reservationId;
	
	public GuestReservation(int guestId, int reservationId){
		this.guestId = guestId;
		this.reservationId = reservationId;
	}
	
	@Override
	public int getGuestId() {
		return this.guestId;
	}

	@Override
	public int getReservationId() {
		return this.reservationId;
	}

	@Override
	public void setGuestId(int guestId) {
		this.guestId = guestId;		
	}

	@Override
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;		
	}

}
