import java.util.ArrayList;


public class Guest {
	
	private String name;

	private ArrayList<Reservation> reservations;
	
	public Guest(String name){
		this.name = name;
		this.reservations = new ArrayList<Reservation>();
	}

	public void addReservation(Reservation reservation) {
		reservations.add(reservation);
	}

	public void deleteReservation(Reservation reservation) {
		reservations.remove(reservation);	
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setReservations(ArrayList<Reservation> reservations) {
		this.reservations = reservations;
	}

	public ArrayList<Reservation> getReservations(){
		return reservations;
	}
	
	public void delete(){
		for (int i = reservations.size(); i >= 0; i--) {
			Reservation res = reservations.get(i);
			res.deleteReservation();
		}
	}

}
