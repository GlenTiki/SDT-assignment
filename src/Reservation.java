import interfaces.ReservationInterface;

import java.util.Date;

import app.RoomReservation;


public class Reservation implements ReservationInterface {
	
	private static int NEXT_RESERVATION_ID = 0;
	
	private int reservationId;
	
	private Date reservationDate;
	
	private Date checkInDate;
	private Date checkOutDate;
	
	public Reservation( Date checkIn, Date checkOut){
		this.reservationId = getNewGuestID();
		
		this.checkInDate = checkIn;
		this.checkOutDate = checkOut;
	}
	
	public int getNewGuestID(){
		return NEXT_RESERVATION_ID++;
	}

	@Override
	public int getId() {
		return this.reservationId;
	}

	@Override
	public Date getReservationDate() {
		return this.reservationDate;
	}

	@Override
	public Date getCheckInDate() {
		return this.checkInDate;
	}

	@Override
	public Date getCheckOutDate() {
		return this.checkOutDate;
	}

	@Override
	public void setReservationDate(Date newReservationDate) {
		this.reservationDate = newReservationDate;
		
	}

	@Override
	public void setCheckInDate(Date newCheckInDate) {
		this.checkInDate = newCheckInDate;
		
	}

	@Override
	public void setCheckOutDate(Date newCheckOutDate) {
		this.checkOutDate = newCheckOutDate;
		
	}
}
