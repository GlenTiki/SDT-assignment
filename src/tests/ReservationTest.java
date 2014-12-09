package tests;


import interfaces.ReservationInterface;

import java.util.Date;

import app.*;
import static org.junit.Assert.*;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class ReservationTest
{
	ReservationInterface r1;
	ReservationInterface r2;
	

	public ReservationTest()
	{
		r1 = new Reservation(1, new Date(114, 10, 23), new Date(114, 10, 25));
		r2 = new Reservation(2, new Date(114, 10, 20), new Date(114, 10, 22));
	}

	@Test
	public void testGetCheckInDate()
	{
		assertEquals(new Date(114, 10, 23), r1.getCheckInDate());
	}
	
	@Test
	public void testGetCheckOutDate()
	{
		assertEquals(new Date(114, 10, 22), r2.getCheckOutDate());
	}
	
	@Test
	public void testSetCheckInDate()
	{
		Date d = new Date(115, 0, 1);
		r1.setCheckInDate(new Date(115, 0, 1));
		assertTrue(r1.getCheckInDate().equals(d));
	}
	
	@Test
	public void testSetCheckOutDate()
	{
		Date d = new Date(114, 4, 7);
		System.out.println(d);
		r1.setCheckOutDate(new Date(114, 4, 7));
		assertTrue(r1.getCheckOutDate().equals(d));
	}
	
}
