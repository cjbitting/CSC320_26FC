package csc320.mod3;

import java.util.Scanner;


public class TaxWithholdings {

	public static void main(String[] args) {
	
		
		
		// int income;
		// double taxRate;
		// double withholding;
		// income = next input
		
		//if income <  500 : taxRate = .10
		
		//if income >= 500 and less than 1500 : taxRate = .15
			
		//if income >= 1500 and < 2500 : taxRate = .2
		
		//if income >= 2500 : taxRate = .3
		
		//withholding = income * taxRate
		
		
		//print "Your tax rate is: " + (taxRate * 100)
		//print "and your withholdings are" + withholdings (print 2 decimals)
		
		int income;
		double taxRate;
		double withholdings;
		
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Enter your weekly average income: ");
		income = scnr.nextInt();
		
		if (income < 500) {
			taxRate = .1;
		}
		else if ((income >= 500) && (income < 1500)) {
			taxRate = .15;
		}
		else if ((income >= 1500) && (income < 2500)) {
			taxRate = .2;
		}
		else {
			taxRate = .3;
		}
		
		withholdings = (income * taxRate);
		
		System.out.println("Your weekly average tax rate is " + (taxRate * 100) + "%");
		System.out.printf("Your weekly average tax withholdings are $%.2f%n", withholdings);
		
		
		
			
		
		
		
	}

}
