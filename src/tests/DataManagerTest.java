package tests;
import app.*;
import interfaces.GuestInterface;
import interfaces.GuestReservationInterface;
import interfaces.ManagerInterface;
import interfaces.ReservationInterface;
import interfaces.RoomInterface;
import interfaces.RoomReservationInterface;

import java.util.ArrayList;
import java.util.Date;
import static org.junit.Assert.*;
import org.junit.Test;

import app.DataManager;


public class DataManagerTest
{
	DataManager m;
	
	public DataManagerTest()
	{
		m = new DataManager();
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

		m.addRoomReservation(new RoomReservation(101,1,1)); //(room_no, res_no, num_occupants)
		m.addRoomReservation(new RoomReservation(102,1,2));
		m.addRoomReservation(new RoomReservation(105,2,2));
		m.addRoomReservation(new RoomReservation(109,3,1));
		m.addRoomReservation(new RoomReservation(110,4,3));
		
		m.addReservation(new Reservation(1, new Date(115, 1, 1), new Date(115, 1, 4)));
		m.addReservation(new Reservation(2, new Date(115, 4, 27), new Date(115, 4, 30)));
		m.addReservation(new Reservation(3, new Date(115, 6, 13), new Date(115, 6, 18)));
		m.addReservation(new Reservation(4, new Date(115, 7, 9), new Date(115, 6, 13)));
		
		m.addGuestReservation(new GuestReservation(1, 1)); //(res_id, guest_id)
		m.addGuestReservation(new GuestReservation(2, 2));
		m.addGuestReservation(new GuestReservation(3, 3));
		m.addGuestReservation(new GuestReservation(4, 4));
		
		m.addGuest(new Guest(1, "Jane Doe", "087123457", "Waterford", "jane@email.com"));
		m.addGuest(new Guest(2, "John Doe", "087123456", "Waterford", "john@email.com"));
		m.addGuest(new Guest(3, "Alice", "123456", "carlow", "alice@email.com"));
		m.addGuest(new Guest(4, "Bob", "123456", "Dublin", "bob@email.com"));
		
	}
	
	public void testNewReservation()
	{
		
	}
	
	public void testEditReservation()
	{
		
	}
	
	public void testCancelReservation()
	{
		
	}
	
	public void testNewGuest()
	{
		
	}
	
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
		
		room_id = 105;
		check_in_date = new Date(115, 4, 30);
		check_out_date = new Date(115, 5, 1);
		assertTrue(m.checkIfRoomFree(room_id, check_in_date, check_out_date));
		//Room 105 is booked between (115, 4, 27) and (115, 4, 30)
		//So we're passing in a check in date that is equal to the checkout date
		//in this case we should return the room as free!
		
	}
	
	public void testGetReservationPrice()
	{
		Reservation r1 = m.getReservation(2);
		//reservation with id of 1 is for the dates (115, 1, 1) - (115, 1, 4)
		//so 3 nights. There are 2 reservations associated with r1
		//see lines 36,37. 1 occupant in room 101 and 2 occupants in room 102
		//ppp in room 101 is 50.50 and ppp in room 102 is 25.00
		//(50.50*1)+(25*2) = 100.50 euro per night
		//100.50*3 = 301.50
		assertEquals(301.50, m.getReservationPrice(r1), 0);
	}
	
}
