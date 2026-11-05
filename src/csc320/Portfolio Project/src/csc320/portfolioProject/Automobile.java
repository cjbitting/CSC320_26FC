package csc320.portfolioProject;

public class Automobile {
	private String make;
	private String model;
	private String color;
	private int year;
	private int mileage;
	
	
	public Automobile() {
		try {
			this.make = "";
			this.model = "";
			this.color = "";
			this.year = 0;
			this.mileage = 0;
		}
		catch (Exception e) {
			System.out.println("Error: unable to initialize default automobile");
		}
	}
	
	public Automobile(String make, String model, String color, int year, int mileage) {
		try {
			this.make = make;
			this.model = model;
			this.color = color;
			this.year = year;
			this.mileage = mileage;	
		}
		catch (Exception e) {
			System.out.println("Error: unable to initialize automobile with provided values");
		}
	}
	
	public String addVehicle(String newMake, String newModel, String newColor, int newYear, int newMileage) {
		try {
			//validate string inputs
			if (newMake == null || newMake.trim().isEmpty() || newModel == null || newModel.trim().isEmpty()
				|| newColor== null || newColor.trim().isEmpty()) {
				return "Error: Make, model, and color must be provided";
			}
			
			//validate numeric input
			if (newYear <= 0 || newMileage < 0) {
				return "Error:  Invalid year or mileage.";
			}
			this.make = newMake;
			this.model = newModel;
			this.color = newColor;
			this.year = newYear;
			this.mileage = newMileage;
			return "Success: Vehicle added to inventory.";
		}
		catch (Exception e) {
			return "Error: Unable to add vehicle: " + e.getMessage();
		}
		
	}
	public String removeVehicle(String make, String model, String color, int year) {
		try {
			if (make.equalsIgnoreCase(this.make) && model.equalsIgnoreCase(this.model) && color.equalsIgnoreCase(this.color)
			&& year == this.year) {
				this.make = "";
				this.model = "";
				this.color = "";
				this.year = 0;
				this.mileage = 0;
				return "Success: Vehicle removed from inventory";	
			}
			else {
				return "Error: Vehicle not found in inventory";
			}
		}
		catch (Exception e) {
			return "Error: Unable to remove vehicle: " + e.getMessage();
		}
	}
	public String updateVehicle(String make, String model, String color, int year, int mileage) {
		try {
			if (this.make == null || this.make.isEmpty()) {
				return "Error: No vehicle currently in inventory to update.";
			}
			if (make == null || make.trim().isEmpty() || model == null || model.trim().isEmpty() || color == null || color.trim().isEmpty()) {
				return "Error: Make, mode, and color must be provided";
			}
			if (year <= 0 || mileage < 0) {
				return "Error: Invalid year or mileage";	
			}
			this.make = make;
			this.model = model;
			this.color = color;
			this.year = year;
			this.mileage = mileage;
			return "Success: Vehicle updated";
		}
		catch (Exception e) {
			return "Error: Unable to update vehicle: " + e.getMessage();
		}
				
	}
	public String[] listVehicleInformation() {
		try {
			String[] vehicleData = new String[5];
			vehicleData[0] = "Make: " + this.make;
			vehicleData[1] = "Model: " + this.model;
			vehicleData[2] = "Color: " + this.color;
			vehicleData[3] = "Year: " + this.year;
			vehicleData[4] = "Mileage: " + this.mileage;
			return vehicleData;
		}
		catch (Exception e) {
			String [] errorData = new String[1];
			errorData[0] = "Error: Unable to retrieve vehicle information: " + e.getMessage();
			return errorData;
		}
	}

}
