package tests;

import interfaces.GuestReservationInterface;
import app.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class GuestReservationTest
{
	
	GuestReservationInterface grt;
	public GuestReservationTest()
	{
		 grt = new GuestReservation(1,1);
	}
	
	@Test
	public void testGetGuestId() 
	{
		assertEquals(1, grt.getGuestId());
	}

	@Test
	public void testGetReservationId() 
	{
		assertEquals(1, grt.getReservationId());
	}

	@Test
	public void testSetGuestId() 
	{
		grt.setGuestId(5);
		assertEquals(5, grt.getGuestId());
	}

	@Test
	public void testReservationId() 
	{
		grt.setReservationId(5);
		assertEquals(5, grt.getReservationId());
	}
	
	
}
