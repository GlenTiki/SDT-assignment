package interfaces;

public interface GuestInterface
{
	public abstract int getId();
	public abstract String getName();
	public abstract String getPhoneNumber();
	public abstract String getAddress();
	public abstract String getEmail();
	public abstract void setId(int newID);
	public abstract void setName(String newName);
	public abstract void setPhoneNumber(String newPhoneNumber);
	public abstract void setAddress(String newAddress);
	public abstract void setEmail(String newEmail);
	public abstract boolean matchDetails(String name, String phoneNumber, String address, String email);
	
}
