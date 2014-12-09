package tests;


import interfaces.RoomInterface;
import app.Room;
import static org.junit.Assert.*;
import org.junit.Test;

public class RoomTest
{
	RoomInterface r1;
	RoomInterface r2;
	
	public RoomTest()
	{
		r1 = new Room(2, 99.99, 101);
		r2 = new Room(4, 45.50, 104);
	}
	
	@Test
	public void testGetRoomCapacity()
	{
		assertEquals(2, r1.getRoomCapacity());
	}
	
	@Test
	public void testGetRoomPricePerPerson()
	{
		assertEquals(45.50, r2.getRoomPricePerPerson(), 0);
		//the zero means there cannot be any floating point errors whatsoever
		//we won't have any..
	}
	
	@Test
	public void testGetRoomNumber()
	{
		assertEquals(101, r1.getRoomNumber());
	}
	
	@Test
	public void testSetRoomCapacity()
	{
		r1.setRoomCapacity(4);
		assertTrue(r1.getRoomCapacity() == 4);
		r1.setRoomCapacity(-1);
		assertEquals(4, r1.getRoomCapacity());
	}
	
	@Test
	public void testSetRoomPricePerPerson()
	{
		r1.setRoomPricePerPerson(20.99);
		assertTrue(r1.getRoomPricePerPerson() == 20.99);
		r1.setRoomPricePerPerson(-200);
		assertEquals(20.99, r1.getRoomPricePerPerson(), 0);
	}
}
