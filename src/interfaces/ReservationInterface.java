package interfaces;

import java.util.Date;
import app.RoomReservation;

public interface ReservationInterface
{
	public abstract int getId();
	public abstract Date getReservationDate();
	public abstract Date getCheckInDate();
	public abstract Date getCheckOutDate();
	public abstract void setReservationDate();
	public abstract void setCheckInDate();
	public abstract void setCheckOutDate();
	public abstract double calculateNetPrice(RoomReservation[] reservations);
}
