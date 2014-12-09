import interfaces.GuestInterface;
import interfaces.GuestReservationInterface;
import interfaces.ManagerInterface;
import interfaces.ReservationInterface;
import interfaces.RoomInterface;
import interfaces.RoomReservationInterface;

import java.util.ArrayList;
import java.util.Date;

public class DataManager implements ManagerInterface {
	ArrayList<? extends ReservationInterface> reservations;
	ArrayList<? extends GuestInterface> guests;
	ArrayList<? extends RoomInterface> rooms;

	ArrayList<? extends RoomReservationInterface> roomReservations;
	ArrayList<? extends GuestReservationInterface> guestReservations;

	public DataManager() {
		this.reservations = new ArrayList<Reservation>();
		this.guests = new ArrayList<Guest>();
		this.rooms = new ArrayList<Room>();

		this.roomReservations = new ArrayList<RoomReservation>();
		this.guestReservations = new ArrayList<GuestReservation>();
	}

	@Override
	public ArrayList<? extends ReservationInterface> getReservations() {
		return this.reservations;
	}

	@Override
	public ArrayList<? extends GuestInterface> getGuests() {
		return this.guests;
	}

	@Override
	public ArrayList<? extends RoomInterface> getRooms() {
		return this.rooms;
	}

	@Override
	public ArrayList<? extends RoomReservationInterface> getRoomReservations() {
		return this.roomReservations;
	}

	@Override
	public ArrayList<? extends GuestReservationInterface> getGuestReservations() {
		return this.guestReservations;
	}

	@Override
	public void setReservations(ArrayList<? extends ReservationInterface> reservations) {
		this.reservations = reservations;
	}

	@Override
	public void setGuests(ArrayList<? extends GuestInterface> guests) {
		this.guests = guests;

	}

	@Override
	public void setRooms(ArrayList<? extends RoomInterface> rooms) {
		this.rooms = rooms;

	}

	@Override
	public void setRoomReservations(ArrayList<? extends RoomReservationInterface> roomReservations) {
		this.roomReservations = roomReservations;
	}

	@Override
	public void setGuestReservations(ArrayList<? extends GuestReservationInterface> guestReservations) {
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
	public void checkIfRoomFree(int roomId, Date checkInDate, Date checkOutDate) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T extends RoomReservationInterface> double getReservationPrice(T reservation) {
		// TODO Auto-generated method stub
		return 0;
	}
}
