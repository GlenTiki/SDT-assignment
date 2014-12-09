import interfaces.GuestInterface;

public class Guest implements GuestInterface {
	
	private static int NEXT_GUEST_ID = 0;
	
	private int id;
	private String name;
	private String phoneNumber;
	private String address;
	private String email;

	public Guest(String name, String phoneNumber, String address, String email){
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		this.id = getNewGuestID();
	}
	
	public int getNewGuestID(){
		return NEXT_GUEST_ID++;
	}

	@Override
	public boolean matchDetails(String name, String phoneNumber, String address, String email) {
		return this.name == name && this.phoneNumber == phoneNumber && this.address == address && this.email == email;
	}
	
	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int newID) {
		this.id = newID;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String newName) {
		this.name = newName;
	}
	
	@Override
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public void setPhoneNumber(String newPhoneNumber) {
		this.phoneNumber = newPhoneNumber;		
	}

	@Override
	public String getAddress() {
		return address;
	}

	@Override
	public void setAddress(String newAddress) {
		this.address = newAddress;
	}

	@Override
	public String getEmail() {
		return email;
	}
	
	@Override
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}

}
