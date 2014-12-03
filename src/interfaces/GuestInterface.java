package interfaces;

public interface GuestInterface
{
	public abstract int getId();
	public abstract String getName();
	public abstract int getPhoneNumber();
	public abstract String getAddress();
	public abstract String getEmail();
	public abstract void setId();
	public abstract void setName();
	public abstract void setPhoneNumber();
	public abstract void setAddress();
	public abstract void setEmail();
	public abstract boolean matchDetails(String name, int phoneNumber, String address, String email);
	
}
