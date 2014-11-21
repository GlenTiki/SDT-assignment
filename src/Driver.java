import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Driver {
	
	DataManager manager;
	Scanner in;
	
	public Driver(){
		manager = new DataManager();
		in = new Scanner(System.in);
		try (BufferedReader br = new BufferedReader(new FileReader("./roomData.csv"));) {
			String line = "";
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] roomDtls = line.split(",");
				String roomName = roomDtls[0];
				int roomCapacity = Integer.parseInt(roomDtls[1]);
				int roomPricePerPerson = Integer.parseInt(roomDtls[2]);
				int numberOfRooms = Integer.parseInt(roomDtls[3]);
				
				for(int i = 0; i< numberOfRooms; i++){
					manager.addRoom(new Room(roomName, roomCapacity, roomPricePerPerson));
				}
			}
			
			manager.finaliseRooms();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void mainMenu(){
		System.out.println("Welcome to Express Hotel Management! Enjoy your stay!");
		loop: while(true){
			System.out.println("													");
			System.out.println("													");
			System.out.println("													");
			System.out.println("----------------------------------------------------");
			System.out.println("					Main Menu						");
			System.out.println("													");
			System.out.println("	Please enter the option you wish to carry out.	");
			System.out.println("----------------------------------------------------");
			System.out.println("1: Make a reservation.								");
			System.out.println("2: Delete a reservation.							");
			System.out.println("3: Get all reservations for a guest.				");
			System.out.println("4: Get a guest's reservation on a specified date.	");
			System.out.println("5: Modify a reservation for a guest.				");
			System.out.println("6: Calculate a reservations price.					");
			System.out.println("7: Check availability for room.						");
			System.out.println("0: Exit.											");
			
			
			String input = in.nextLine();
			int choice = -1;
			try{
				choice = Integer.parseInt(input);
			}catch(Exception e){
				System.out.println("ERROR: Invalid input. Please enter a number.");
			}
			
			switch(choice){
			case 1:
				makeReservation();
				break;
			case 0:
				break loop;
			}
		}
		System.out.println("Thank you for using the Express hotel manager!\n"
				+ "We hope you enjoyed your stay!");
	}
	
	private void makeReservation() {
		loop: while(true){
			System.out.println("													");
			System.out.println("													");
			System.out.println("													");
			System.out.println("----------------------------------------------------");
			System.out.println("				Add a reservation					");
			System.out.println("													");
			System.out.println("	Please enter the option you wish to carry out.	");
			System.out.println("----------------------------------------------------");
			System.out.println("1: Add reservation for existing guest.				");
			System.out.println("2: Create new guest information for reservation.	");
			
			
			String input = in.nextLine();
			int choice = -1;
			try{
				choice = Integer.parseInt(input);
			}catch(Exception e){
				System.out.println("ERROR: Invalid input. Please enter a number.");
			}
			
			switch(choice){
			case 1:
				makeReservation();
				break;
			case 0:
				break loop;
			}
		}
		
	}

	public static void main(String[] args) {		
		Driver driver = new Driver();
		driver.mainMenu();
	}


}
