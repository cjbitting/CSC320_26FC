package csc320.mod3;

import java.util.Scanner;


public class TaxWithholdings {

	public static void main(String[] args) {
	
		
		/*
		 Declare income as double
		 Declare taxRate as double
		 Declare withholding as double
		 prompt user input: "Enter weekly average income: "
		 if income is valid double
			if income  < 0 then
				print "income cannot be negative"
			else
				if income < 500 then
					taxRate = 0.10
				else if income >= 500 and income < 1500 then
					taxRate = 0.15
				else if income >= 1500 and income < 2500 then
					taxRate = 0.20
				else 
					taxRate = 0.30
				end if 
			
				withholdings = income * taxRate
				
				print "Your weekly average tax rate is " + (taxRate * 100) + "%"
				print "Your weekly average tax withholdings are: " + formatted withholding with 2 decimal places
				
			end if
		end if
		
		*/
		
		double income;
		double taxRate;
		double withholdings;
		
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Enter your weekly average income: ");
		
		if (scnr.hasNextDouble()) {  //ensures input is a valid number
		income = scnr.nextDouble(); 
		
			if (income < 0) {      //Validates input is positive
				System.out.println("Error:  Income must be positive.");
				
			}
			else {
		
				if (income < 500) {
					taxRate = 0.10;
				}
				else if ((income >= 500) && (income < 1500)) {
					taxRate = 0.15;
				}
				else if ((income >= 1500) && (income < 2500)) {
					taxRate = 0.20;
				}
				else {
					taxRate = 0.30;
				}
		
				withholdings = (income * taxRate);
		
				System.out.println("Your weekly average tax rate is " + (taxRate * 100) + "%");  //prints tax rate and converts to percentage
				System.out.printf("Your weekly average tax withholdings are $%.2f%n", withholdings); //print formatted weekly withholding with 2 decimals
			}
			
		}
		
		else {
			System.out.println("Error: Invalid numeric input.");  // Error message for string input ex "one thousand"
				
		}
	}
}
