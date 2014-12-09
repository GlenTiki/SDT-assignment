package app;
import interfaces.GuestInterface;
import interfaces.GuestReservationInterface;
import interfaces.ManagerInterface;
import interfaces.ReservationInterface;
import interfaces.RoomInterface;
import interfaces.RoomReservationInterface;

import java.util.ArrayList;
import java.util.Date;

public class DataManager implements ManagerInterface {
	public ArrayList<Reservation> reservations;
	ArrayList<Guest> guests;
	ArrayList<Room> rooms;

	ArrayList<RoomReservation> roomReservations;
	ArrayList<GuestReservation> guestReservations;

	public DataManager() {
		this.reservations = new ArrayList<Reservation>();
		this.guests = new ArrayList<Guest>();
		this.rooms = new ArrayList<Room>();

		this.roomReservations = new ArrayList<RoomReservation>();
		this.guestReservations = new ArrayList<GuestReservation>();
	}

	@Override
	public ArrayList<Reservation> getReservations() {
		return this.reservations;
	}

	@Override
	public ArrayList<Guest> getGuests() {
		return this.guests;
	}

	@Override
	public ArrayList<Room> getRooms() {
		return this.rooms;
	}

	@Override
	public ArrayList<RoomReservation> getRoomReservations() {
		return this.roomReservations;
	}

	@Override
	public ArrayList<GuestReservation> getGuestReservations() {
		return this.guestReservations;
	}

	@Override
	public void setReservations(ArrayList<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public void setGuests(ArrayList<Guest> guests) {
		this.guests = guests;

	}

	@Override
	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;

	}

	@Override
	public void setRoomReservations(ArrayList<RoomReservation> roomReservations) {
		this.roomReservations = roomReservations;
	}

	@Override
	public void setGuestReservations(ArrayList<GuestReservation> guestReservations) {
		this.guestReservations = guestReservations;

	}

	@Override
	public void newReservation() {
		// TODO Auto-generated method stub

	}

	@Override
	public void editReservation() {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelReservation() {
		// TODO Auto-generated method stub

	}

	@Override
	public void newGuest() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean checkIfRoomFree(int roomId, Date checkInDate, Date checkOutDate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getReservationPrice(Reservation reservation) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void addRoom(Room room)
	{
		rooms.add(room);
	}
	public void addGuest(Guest guest)
	{
		guests.add(guest);
	}
	public void addReservation(Reservation reservation)
	{
		reservations.add(reservation);
	}
	public void addRoomReservation(RoomReservation roomReservation)
	{
		roomReservations.add(roomReservation);
	}
	public void addGuestReservation(GuestReservation guestReservation)
	{
		guestReservations.add(guestReservation);
	}
	
	public Room getRoom(int index)
	{
		return rooms.get(index);
	}
	public Guest getGuest(int index)
	{
		return guests.get(index);
	}
	public Reservation getReservation(int index)
	{
		return reservations.get(index);
	}
	public RoomReservation getRoomReservation(int index)
	{
		return roomReservations.get(index);
	}
	public GuestReservation getGuestReservation(int index)
	{
		return guestReservations.get(index);
	}
	
}
