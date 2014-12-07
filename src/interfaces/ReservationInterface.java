package interfaces;

import java.util.Date;
import app.RoomReservation;

public interface ReservationInterface
{
	public abstract int getId();
	public abstract Date getReservationDate();
	public abstract Date getCheckInDate();
	public abstract Date getCheckOutDate();
	public abstract void setReservationDate(Date newReservationDate);
	public abstract void setCheckInDate(Date newCheckInDate);
	public abstract void setCheckOutDate(Date newcheckOutDate);
}
