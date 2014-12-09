package interfaces;

import java.util.Date;

public interface ReservationInterface
{
	public abstract int getId();
	public abstract Date getCheckInDate();
	public abstract Date getCheckOutDate();
	public abstract void setCheckInDate(Date newCheckInDate);
	public abstract void setCheckOutDate(Date newcheckOutDate);
}
