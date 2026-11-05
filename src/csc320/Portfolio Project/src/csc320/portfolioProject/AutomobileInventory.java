package csc320.portfolioProject;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;

public class AutomobileInventory {
	private ArrayList<Automobile> fleet = new ArrayList<Automobile>();

//Initializes sample vehicle
	public void InitializeSampleVehicle() {
		try {
			//Instantiates vehicle using 5 parameters
			Automobile sampleCar = new Automobile("Chevrolet", "Silverado", "Gray", 2025, 10);
			//adds new instance to ArrayList fleet
			fleet.add(sampleCar);
			System.out.println("Success:  Vehicle initialized with parameterized constructor and added to inventory");
			
			displayAllVehicles();
			
		}
		catch (Exception e) {
			System.out.println("Error initializing vehicle" + e.getMessage());
			
		}
	}
	
	public void displayAllVehicles() {
		try {
			if (fleet.isEmpty()) {
				System.out.println("Inventory is currently Empty, No vehicle to display");
				return;
			}
			System.out.println("------Vehicle Inventory-----");
			for (int i=0; i < fleet.size(); ++i) {
				System.out.println("Vehicle # " + (i + 1));
				String[] details = fleet.get(i).listVehicleInformation();
				
				for (String line : details) {
					System.out.println(" " + line);
				}
			}
			System.out.println("--------------------------------");
			
		}
		catch (Exception e) {
			System.out.println("Error displaying inventory" + e.getMessage());
		}
	}
	
	public void addNewVehicle(Scanner scnr) {
		try {
			System.out.println("-----Add New Vehicle-----");
			//Gather vehicle data
			System.out.println("Enter vehicle make: ");
			String make = scnr.next();
			
			System.out.println("Enter vehicle model: ");
			String model = scnr.next();
			
			System.out.println("Enter vehicle color: ");
			String color = scnr.next();
			
			System.out.println("Enter vehicle year: ");
			int year = scnr.nextInt();
			
			System.out.println("Enter vehicle mileage: ");
			int mileage = scnr.nextInt();
			
			//Instantiate a fresh Automobile using default constructor
			Automobile newCar = new Automobile();
			
			String result = newCar.addVehicle(make, model, color, year, mileage);
			System.out.println(result);
			
			if(result.startsWith("Success")) {
				fleet.add(newCar);
				displayAllVehicles();
				
			}
		}
		
		catch (Exception e) {
			System.out.println("Error adding vehicle: " + e.getMessage());
			scnr.nextLine(); //clears mismatched input
		}
	}
	
	public void removeVehicle(Scanner scnr) {
		try {
			if (fleet.isEmpty()) {
				System.out.println("Inventory is currently empty");
				return;
			}
			System.out.println("-----Remove Vehicle-----");
			
			//Get verification detail
			System.out.println("Please Verify vehicle deatils");
			
			System.out.println("Enter vehicle make: ");
			String make = scnr.next();
			
			System.out.println("Enter vehicle model: ");
			String model = scnr.next();
			
			System.out.println("Enter vehicle color: ");
			String color = scnr.next();
			
			System.out.println("Enter vehicle year: ");
			int year = scnr.nextInt();
			
			boolean vehicleRemoved = false;
			//Searches ArrayList for matching vehicle
			for (int i = 0; i < fleet.size(); i ++) {
				Automobile car = fleet.get(i);
			
				String result = car.removeVehicle(make, model, color, year);
				
				if (result.startsWith("Success")) {
					System.out.println(result);
					fleet.remove(i);
					vehicleRemoved = true;
					break; //stops loop once match is found and removed
					
				}
			}
			if (!vehicleRemoved) {
				System.out.println("Error: Vehicle matching those deatils was not found in inventory");
			}
		}
		catch (Exception e) {
			System.out.println("Error removing vehicle: " + e.getMessage());
			scnr.nextLine(); //clear input	
		}
		
	}
	//prompts for vehicle index and updates attributes delegates to Automobiles updateVehicle
	public void updateVehicle(Scanner scnr) {
		try {
			//checks if inventory is empty
			if (fleet.isEmpty()) {
				System.out.println("Inventory is currently empty");
				return;
			}
			//displays current inventory
			System.out.println("-----Update Vehicle Attributes-----");
			
			displayAllVehicles();
			
			//prompt user for vehicle number based off list
			System.out.println("Enter vehicle number to update (1 to " + fleet.size() + "): " );
			int choice = scnr.nextInt();
			int index = choice -1;
			
			//validate selection range
			
			if (index < 0 || index >= fleet.size()) {
				System.out.println("Error: Invalid selection.  Vehicle number does not exitst");
				return;
			}
			//prompt for updated attributes
			
			System.out.println("Enter updated make: ");
			String make = scnr.next();
			
			System.out.println("Enter updated model: ");
			String model = scnr.next();
			
			System.out.println("Enter updated color: ");
			String color = scnr.next();
			
			System.out.println("Enter updated year: ");
			int year = scnr.nextInt();
			
			System.out.println("Enter updated mileage: ");
			int mileage = scnr.nextInt();
			
			//delegate changes to identified Automobile object
			String result = fleet.get(index).updateVehicle(make, model, color, year, mileage);
			System.out.println(result);
			
			//print updated information to screen
			if (result.startsWith("Success")) {
				displayAllVehicles();
				
			}
		}
		catch (Exception e) {
			System.out.println("Error updateing vehicle: " + e.getMessage());
			scnr.nextLine(); //clears input
		}
	}
	
	public void promptToPrintFile(Scanner scnr) {
		try {
			if (fleet.isEmpty()) {
				System.out.println("Inventory is empty.  No data to export");
				return;
			}
			System.out.println("Do you want to print the inventory to a file? (Y/N): ");
			String userChoice = scnr.next();
			
			if (userChoice.equalsIgnoreCase("Y")){
				exportToFile("Autos.txt");
			}
			else if (userChoice.equalsIgnoreCase("N")) {
				System.out.println("File will not be printed");
			}
			else {
				System.out.println("Invalid response.  Please enter 'Y' or 'N'.");
			}
		}
		catch (Exception e) {
			System.out.println("Error processing file print request: " + e.getMessage());
			scnr.next();
		}
	}
	
	private void exportToFile(String fileName) {
		FileOutputStream fileStream = null;
		PrintWriter outFS = null;
		
		try {
			fileStream = new FileOutputStream(fileName);
			outFS = new PrintWriter(fileStream);
			
			outFS.println("===================================");
			outFS.println("    Automobile Inventory Report    ");
			outFS.println("===================================");
			
			for (int i = 0; i < fleet.size(); i++) {
				outFS.println("Vehicle # " + (i + 1));
				String[] details = fleet.get(i).listVehicleInformation();
				for (String line : details) {
					outFS.println(line);
				}
				outFS.println(); //blank line between vehicles
			}
			outFS.flush();
			System.out.println("Success: Inventory successfully exported to " + fileName);
		}

		catch (IOException e) {
			System.out.println("Error writing file: " + e.getMessage());
		}
		finally {
			if (outFS !=null) {
				outFS.close();
			}
		}
		
	}
}
