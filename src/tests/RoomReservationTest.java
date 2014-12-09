package tests;

import interfaces.RoomReservationInterface;
import app.RoomReservation;
import static org.junit.Assert.*;
import org.junit.Test;

public class RoomReservationTest
{
	RoomReservationInterface rr1;
	RoomReservationInterface rr2;
	
	public RoomReservationTest()
	{
		rr1 = new RoomReservation(101, 1, 2);
		rr2 = new RoomReservation(201, 2, 4);
	}
	
	@Test
	public void testGetRoomNumber()
	{
		assertEquals(101, rr1.getRoomNumber());
	}
	
	@Test
	public void testGetReservationId()
	{
		assertEquals(2, rr2.getReservationId());
	}
	
	@Test
	public void testGetNumGuests()
	{
		assertEquals(2, rr1.getNumGuests());
	}
	
	@Test
	public void testSetRoomNumber()
	{
		
	}
	
	
	@Test
	public void testSetNumGuests()
	{
		rr1.setNumGuests(3);
		assertEquals(3, rr1.getNumGuests());
		rr1.setNumGuests(-1);
		assertEquals(3, rr1.getNumGuests());
	}
	
}
