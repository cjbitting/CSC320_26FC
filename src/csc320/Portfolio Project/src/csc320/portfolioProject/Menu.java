package csc320.portfolioProject;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int userChoice;
		boolean menuRunning = true;
		
		while (menuRunning) {
			try {
				System.out.println("=========================================");
				System.out.println(" Welcome to Automobile Inventory System");
				System.out.println("=========================================");
				System.out.println("Please select an option");
				System.out.println("1. Add Vehicle");
				System.out.println("2. Remove Vehicle");
				System.out.println("3. Update Vehicle");
				System.out.println("4. List Vehicle Information");
				System.out.println("5. Export to File");
				System.out.println("6. Exit");
				System.out.println("");
				System.out.println("Enter your choice 1-6: ");
				
				userChoice = scnr.nextInt();
				
				switch(userChoice) {
					case 1: 
						//vehicle.addVehicle();
						break;
					case 2:
						//vehicle.removeVehicle();
						break;
					case 3:
						//vehicle.updateVehicle();
						break;
					case 4:
						//vehicle.listVehicleInformatoin();
						break;
					case 5:
						System.out.println("Fix me!!");
						break;
					case 6:
						System.out.println("Exiting Program.");
						menuRunning = false;
						break;
					default:
						System.out.println("Invalid Choice.  Please try again.");
						break;
							
				}
		
				
			}
			catch (Exception e) {
				System.out.println("An error occurred: " + e.getMessage());
				scnr.nextLine();  //clear invalid input
			}
		}

	}

}
