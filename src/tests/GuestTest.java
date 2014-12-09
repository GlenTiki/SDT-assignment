package tests;

import interfaces.GuestInterface;
import app.*;
import static org.junit.Assert.*;
import org.junit.Test;


public class GuestTest
{
	
	private GuestInterface g1;
	private GuestInterface g2;
	
	public GuestTest()
	{
		g1 = new Guest(1, "John Doe", "087123456", "Waterford", "john@email.com");
		System.out.println("created new guest" + g1.getId());
		g2 = new Guest (2, "Jane Doe", "087123457", "Waterford", "jane@email.com");
		System.out.println("created new guest" + g2.getId());
	}

	@Test
	public void testGetName()
	{
		assertEquals("John Doe", g1.getName());
		assertFalse(g2.getName().equals("jane Doe"));
	}
	
	@Test
	public void testGetPhoneNumber()
	{
		assertEquals("087123456", g1.getPhoneNumber());
		assertTrue("087123457".equals(g2.getPhoneNumber()));
	}
	
	@Test
	public void testGetAddress()
	{
		assertEquals("Waterford", g1.getAddress());
		assertFalse(g2.getAddress().equals("waterford"));
	}
	
	@Test
	public void testGetEmail()
	{
		assertEquals("john@email.com", g1.getEmail());
		assertFalse("john@email.com" == g2.getEmail());
	}
	
	@Test
	public void testSetName()
	{
		g1.setName("");
		assertTrue(g1.getName().equals("John Doe")); //empty string should be rejected i guess...
		g1.setName("Jane Doe");
		assertTrue(g1.getName().equals(g2.getName()));
	}
	
	@Test
	public void testSetPhoneNumber()
	{
		g1.setPhoneNumber("");
		assertTrue(g1.getPhoneNumber().equals("087123456")); //empty string should be rejected i guess...
		g1.setPhoneNumber("087123457");
		assertTrue(g1.getPhoneNumber().equals(g2.getPhoneNumber()));
	}
	
	@Test
	public void testSetAddress()
	{
		g1.setAddress("");
		assertTrue(g1.getAddress().equals("Waterford")); //empty string should be rejected i guess...
		g1.setAddress("Carlow");
		assertTrue(g1.getAddress().equals("Carlow"));
	}
	
	@Test
	public void testSetEmail()
	{
		g1.setEmail("");
		assertTrue(g1.getEmail().equals("john@email.com")); //empty string should be rejected i guess...
		g1.setEmail("jane@email.com");
		assertTrue(g1.getEmail().equals(g2.getEmail()));
	}

	@Test
	public void testMatchDetails()
	{
		assertTrue(g1.matchDetails("John Doe", "087123456", "Waterford", "john@email.com"));
		assertFalse(g1.matchDetails(g2.getName(), g2.getPhoneNumber(), g2.getAddress(), g2.getEmail()));
	}
}
