package tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import app.DataManager;
import app.Guest;
import app.GuestReservation;
import app.Reservation;
import app.Room;
import app.RoomReservation;


public class DataManagerTest
{
	DataManager m;
	
	@Before
	public void init()
	{
		m = new DataManager();
		
		//populate with test data.
		//4 reservations:
		
		//Guest 1 makes reservation 1.
		//reservation 1 reserves rooms 101 & 102 with 1 & 2 occupants.
		//reservation 1 is booked on the 1st of January the the 4th of January

		//Guest 2 makes reservation 2.
		//reservation 2 reserves room 105 with 2 occupants.
		//reservation 2 is booked on the 27th of April the the 30th of April

		//Guest 3 makes reservation 3.
		//reservation 3 reserves rooms 109 with 1 occupant.
		//reservation 3 is booked on the 13 of June the the 18th of June

		//Guest 4 makes reservation 4.
		//reservation 4 reserves rooms 110 with 3 occupants.
		//reservation 4 is booked on the 9th of July the the 13th of July
		
		//create tests
		m.addGuest(new Guest(1, "Jane Doe", "087123457", "Waterford", "jane@email.com"));
		m.addGuest(new Guest(2, "John Doe", "087123456", "Waterford", "john@email.com"));
		m.addGuest(new Guest(3, "Alice", "123456", "carlow", "alice@email.com"));
		m.addGuest(new Guest(4, "Bob", "123456", "Dublin", "bob@email.com"));
		
		//create rooms
		m.addRoom(new Room(101,50.50,2)); //(room_no, price, capacity)
		m.addRoom(new Room(102,25,3));
		m.addRoom(new Room(103,40,1));
		m.addRoom(new Room(104,60,4));
		m.addRoom(new Room(105,70,3));
		m.addRoom(new Room(106,90,2));
		m.addRoom(new Room(107,33.50,2));
		m.addRoom(new Room(108,12.50,4));
		m.addRoom(new Room(109,99.99,1));
		m.addRoom(new Room(110,66.60,4));
		
		//create the reservations
		m.addReservation(new Reservation(1, new Date(115, 1, 1), new Date(115, 1, 4)));
		m.addReservation(new Reservation(2, new Date(115, 4, 27), new Date(115, 4, 30)));
		m.addReservation(new Reservation(3, new Date(115, 6, 13), new Date(115, 6, 18)));
		m.addReservation(new Reservation(4, new Date(115, 7, 9), new Date(115, 6, 13)));
		
		//create the room reservations
		m.addRoomReservation(new RoomReservation(101,1,1)); //(room_no, res_no, num_occupants)
		m.addRoomReservation(new RoomReservation(102,1,2));
		m.addRoomReservation(new RoomReservation(105,2,2));
		m.addRoomReservation(new RoomReservation(109,3,1));
		m.addRoomReservation(new RoomReservation(110,4,3));
		
		//create the guest reservations
		m.addGuestReservation(new GuestReservation(1, 1)); //(res_id, guest_id)
		m.addGuestReservation(new GuestReservation(2, 2));
		m.addGuestReservation(new GuestReservation(3, 3));
		m.addGuestReservation(new GuestReservation(4, 4));
		
	}
	
	@Test
	public void testAddValidReservation()
	{
		Reservation newReservation = new Reservation(5, new Date(115, 2, 1), new Date(115, 2, 3));
		RoomReservation newRoomReservation = new RoomReservation(101, 5, 2);
		GuestReservation newGuestReservation = new GuestReservation(5, 1);
		
		assertTrue(m.createFullReservation(newReservation, newGuestReservation.getGuestId(), new RoomReservation[]{newRoomReservation}));
		
		assertEquals(newReservation, m.getReservationById(5));
	}
	
	@Test
	public void testAddInvalidReservationWithOverlappingDate()
	{
		Reservation newReservation = new Reservation(5, new Date(115, 1, 1), new Date(115, 1, 4));
		RoomReservation newRoomReservation = new RoomReservation(101, 5, 2);
		GuestReservation newGuestReservation = new GuestReservation(5, 1);
		
		assertFalse(m.createFullReservation(newReservation, newGuestReservation.getGuestId(), new RoomReservation[]{newRoomReservation}));
		assertEquals(null, m.getReservationById(5));
	}
	
	@Test
	public void testEditReservationValidly()
	{
		Reservation newReservation = new Reservation(5, new Date(115, 2, 1), new Date(115, 2, 4));
		RoomReservation newRoomReservation = new RoomReservation(101, 5, 2);
		GuestReservation newGuestReservation = new GuestReservation(5, 1);
		
		assertTrue(m.createFullReservation(newReservation, newGuestReservation.getGuestId(), new RoomReservation[]{newRoomReservation}));
		assertEquals(newReservation, m.getReservationById(5));
		
		Reservation editedReservation = new Reservation(5, new Date(115, 3, 1), new Date(115, 3, 4));
		
		assertTrue(m.editReservation(editedReservation, newGuestReservation.getGuestId(), new RoomReservation[]{newRoomReservation}));
		assertEquals(editedReservation, m.getReservationById(5));
	
	}
	
	@Test
	public void testEditReservationInvalidly()
	{
		Reservation newReservation = new Reservation(5, new Date(115, 2, 1), new Date(115, 2, 4));
		RoomReservation newRoomReservation = new RoomReservation(101, 5, 2);
		GuestReservation newGuestReservation = new GuestReservation(5, 1);
		
		assertTrue(m.createFullReservation(newReservation, newGuestReservation.getGuestId(), new RoomReservation[]{newRoomReservation}));
		assertEquals(newReservation, m.getReservationById(5));
		
		Reservation editedReservation = new Reservation(5, new Date(115, 1, 1), new Date(115, 1, 4));
		
		assertFalse(m.editReservation(editedReservation, newGuestReservation.getGuestId(), new RoomReservation[]{newRoomReservation}));
		assertTrue(editedReservation != m.getReservationById(5));
		assertEquals(newReservation, m.getReservationById(5));
	}
	
	@Test
	public void testCancelReservation()
	{
		Reservation canceledReservation = m.getReservationById(1);
		
		m.cancelReservation(canceledReservation);
		
		assertEquals(null, m.getReservationById(1));
	}
	
	@Test
	public void testCheckIfRoomFree()
	{
		//                            (y,m,d)
		// room 101 is booked between (115, 1, 1) and (115, 1, 4)
		int room_id = 101;
		Date check_in_date = new Date(115, 1, 3);
		Date check_out_date = new Date(115, 1, 5);
		assertFalse(m.checkIfRoomFree(room_id, check_in_date, check_out_date));
		
		room_id = 108;
		assertTrue(m.checkIfRoomFree(room_id, check_in_date, check_in_date));
		//room 108 has no reservations...
	}
	
	@Test
	public void testGetReservationPrice()
	{
		Reservation res = m.getReservationById(1);
		System.out.println(m.getReservationPrice(res));
		assertTrue(301.5 == m.getReservationPrice(res));
	}
	
}
