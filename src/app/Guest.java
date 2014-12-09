package app;
import interfaces.GuestInterface;

public class Guest implements GuestInterface {
	
	
	
	private int id;
	private String name;
	private String phoneNumber;
	private String address;
	private String email;

	public Guest(int id, String name, String phoneNumber, String address, String email){
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
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
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String newName) {
		if (!newName.isEmpty())
		this.name = newName;
	}
	
	@Override
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public void setPhoneNumber(String newPhoneNumber) {
		if (!newPhoneNumber.isEmpty())
		this.phoneNumber = newPhoneNumber;		
	}

	@Override
	public String getAddress() {
		return address;
	}

	@Override
	public void setAddress(String newAddress) {
		if (!newAddress.isEmpty())
		this.address = newAddress;
	}

	@Override
	public String getEmail() {
		return email;
	}
	
	@Override
	public void setEmail(String newEmail) {
		if (!newEmail.isEmpty())
		this.email = newEmail;
	}

}
