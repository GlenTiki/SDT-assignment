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
	public void setGuestReservations(
			ArrayList<GuestReservation> guestReservations) {
		this.guestReservations = guestReservations;

	}
	
	@Override
	public void cancelReservation(Reservation reservation) {
		reservations.remove(reservation);
		for (int i = guestReservations.size() - 1; i >= 0; i--) {
			GuestReservation gr = guestReservations.get(i);
			if (gr.getReservationId() == reservation.getId()) {
				guestReservations.remove(i);
			}
		}
		for (int i = roomReservations.size() - 1; i >= 0; i--) {
			RoomReservation rr = roomReservations.get(i);
			if (rr.getReservationId() == reservation.getId()) {
				roomReservations.remove(i);
			}
		}
	}

	@Override
	public boolean checkIfRoomFree(int roomId, Date checkInDate,
			Date checkOutDate) {

		Reservation reservationCheck = new Reservation(reservations.size(),
				checkInDate, checkOutDate);

		ArrayList<Reservation> reses = getReservationsForRoom(roomId);

		for (Reservation res : reses) {
			if (checkIfReservationsOverlap(reservationCheck, res)) {
				return false;
			}
		}

		return true;
	}

	private ArrayList<Reservation> getReservationsForRoom(int roomId) {

		ArrayList<Reservation> rtn = new ArrayList<Reservation>();
		for (RoomReservation res : roomReservations) {
			if (res.getRoomNumber() == roomId) {
				rtn.add(getReservationById(res.getReservationId()));
			}
		}

		return rtn;
	}

	@Override
	public double getReservationPrice(Reservation reservation) {
		
		ArrayList<RoomReservation> roomres = getRoomReservationsForReservation(reservation.getId());
		
		double rtn = 0;
		int diffInDays = (int)( (reservation.getCheckOutDate().getTime() - reservation.getCheckInDate().getTime()) 
                / (1000 * 60 * 60 * 24) );
		
		System.out.println(diffInDays);
		
		for(RoomReservation res: roomres){
			Room room = getRoomByNumber(res.getRoomNumber());
			double ppp = room.getRoomPricePerPerson();
			int numGuests = res.getNumGuests();
			rtn += ( ppp* numGuests * diffInDays);
		}
		
		return rtn;
	}

	private ArrayList<RoomReservation> getRoomReservationsForReservation(int id) {
		ArrayList<RoomReservation> rtn = new ArrayList<RoomReservation>();
		for(RoomReservation res:roomReservations){
			if(res.getReservationId() == id){
				rtn.add(res);
			}
		}
		return rtn;
		
	}

	public void addRoom(Room room) {
		rooms.add(room);
	}

	public void addGuest(Guest guest) {
		guests.add(guest);
	}

	public void addReservation(Reservation reservation) {
		reservations.add(reservation);
	}

	public void addRoomReservation(RoomReservation roomReservation) {
		roomReservations.add(roomReservation);
	}

	public void addGuestReservation(GuestReservation guestReservation) {
		guestReservations.add(guestReservation);
	}

	public Room getRoom(int index) {
		return rooms.get(index);
	}
	
	public Room getRoomByNumber(int number) {
		for(Room room:this.rooms){
			if(room.getRoomNumber() == number){
				return room;
			}
		}
		return null;
	}

	public Guest getGuest(int index) {
		return guests.get(index);
	}

	public Reservation getReservation(int index) {
		return reservations.get(index);
	}

	public Reservation getReservationById(int id) {
		for (Reservation res : reservations) {
			if (res.getId() == id) {
				return res;
			}
		}
		return null;
	}

	public RoomReservation getRoomReservation(int index) {
		return roomReservations.get(index);
	}

	private RoomReservation getRoomReservation(int roomNumber, int reservationId) {
		for (RoomReservation rr : roomReservations) {
			if (rr.getRoomNumber() == roomNumber
					&& rr.getReservationId() == reservationId) {
				return rr;
			}
		}
		return null;
	}

	public GuestReservation getGuestReservation(int index) {
		return guestReservations.get(index);
	}

	public GuestReservation getGuestReservation(int guestId, int reservationId) {
		for (GuestReservation gr : guestReservations) {
			if (gr.getGuestId() == guestId
					&& gr.getReservationId() == reservationId) {
				return gr;
			}
		}
		return null;
	}

	// Return true if the reservation was created
	public boolean createFullReservation(Reservation reservation, int guestId,
			RoomReservation[] rooms) {
		for (RoomReservation res : rooms) {
			if (checkIfRoomFree(res.getRoomNumber(),
					reservation.getCheckInDate(), reservation.getCheckOutDate()) == false) {
				return false;
			}
		}
		this.addGuestReservation(new GuestReservation(guestId, reservation
				.getId()));
		for (RoomReservation res : rooms) {
			this.addRoomReservation(res);
		}
		this.addReservation(reservation);
		return true;
	}

	@Override
	/*
	 * @return true if dates overlap(non-Javadoc)
	 * 
	 * @see
	 * interfaces.ManagerInterface#checkIfReservationsOverlap(app.Reservation,
	 * app.Reservation)
	 */
	public boolean checkIfReservationsOverlap(Reservation res1, Reservation res2) {
		if (res1.getCheckInDate().before(res2.getCheckOutDate())) {
			if (res1.getCheckOutDate().before(res2.getCheckInDate())
					|| res1.getCheckOutDate().equals(res2.getCheckInDate())) {
				return false;
			}

		} else {
			return false;
		}
		return true;
	}

	@Override
	public boolean editReservation(Reservation reservation, int guestId,
			RoomReservation[] rooms) {
		Reservation oldRes = getReservationById(reservation.getId());
		GuestReservation oldGR = getGuestReservation(guestId,
				reservation.getId());
		ArrayList<RoomReservation> oldReserves = new ArrayList<RoomReservation>();
		for (RoomReservation res : rooms) {
			oldReserves.add(getRoomReservation(res.getRoomNumber(),
					reservation.getId()));
		}

		cancelReservation(oldRes);
		
		if (createFullReservation(reservation, guestId, rooms)) {
			return true;
		}
		
		reservations.add(oldRes);
		guestReservations.add(oldGR);
		for (RoomReservation res : oldReserves) {
			roomReservations.add(res);
		}
		return false;

	}

}
