package app;
import interfaces.ReservationInterface;

import java.util.Date;

import app.RoomReservation;


public class Reservation implements ReservationInterface {
	
	
	private int reservationId;
	
	private Date checkInDate;
	private Date checkOutDate;
	
	public Reservation(int id, Date checkIn, Date checkOut){
		this.reservationId = id;
		
		this.checkInDate = checkIn;
		this.checkOutDate = checkOut;
	}

	@Override
	public int getId() {
		return this.reservationId;
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
	public void setCheckInDate(Date newCheckInDate) {
		this.checkInDate = newCheckInDate;
		
	}

	@Override
	public void setCheckOutDate(Date newCheckOutDate) {
		this.checkOutDate = newCheckOutDate;
		
	}
}
