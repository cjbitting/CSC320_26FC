package csc320.mod5;
import java.util.Scanner;
import java.util.ArrayList;

/*
PROGRAM: Weekly Temperature Tracker

START MAIN
    // Data structures and variables scoped to main
    Declare WeekDay as ArrayList of String
    Declare DayTemp as ArrayList of Double
    Declare validDays as Array of String = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"]
    Declare currDay as String
    Declare currTemp as double
    Declare userChoice as String
    Declare menuRunning as boolean = true
    Declare weeklySum as double = 0.0
    Declare weeklyAverage as double = 0.0
    Declare dayFound as boolean
    Declare i as integer
    Declare j as integer

    Initialize Scanner

    PRINT "=========================================================================================="
    PRINT "                           Welcome to Daily Temperature Tracker                           "
    PRINT "=========================================================================================="
    PRINT ""
    PRINT "Enter the day of the week + the days average temperature in fahrenheit.  Enter 'e' to exit"

    // Collect 7 days of validated input
    FOR i = 0 TO 6 STEP 1
        PROMPT "Day: "
        currDay = CALL getValidDay(scnr, validDays)
        
        PROMPT "Average Temp: "
        currTemp = CALL getValidTemp(scnr)
        
        ADD currDay to WeekDay
        ADD currTemp to DayTemp
    END FOR

    // Query Menu: Indefinite loop running until user enters 'e'
    WHILE menuRunning is true DO
        PRINT "----------------------------------------------------------------------------------------"
        PRINT "Enter a day of week, 'week' for summary, or 'e' for exit."
        READ userChoice as String
        
        IF userChoice equals "e" (ignoring case) THEN
            PRINT "Exiting program."
            menuRunning = false

        ELSE IF userChoice equals "week" (ignoring case) THEN
            weeklySum = 0.0
            PRINT "--- Weekly Temperature Report---"
            FOR j = 0 TO WeekDay.size()-1 ++j
                PRINT formatted WeekDay.get(j) and DayTemp.get(j) (1 decimal place)
                weeklySum = weeklySum + DayTemp.get(j)
            END FOR

            weeklyAverage = weeklySum / WeekDay.size()
            PRINT "---------------------------------"
            PRINT "Weekly Average Temperature: " + formatted weeklyAverage (1 decimal place)

        ELSE
            dayFound = false
            FOR j = 0 TO WeekDay.size()-1 ++j
                IF userChoice equals WeekDay.get(j) (ignoring case) THEN
                    PRINT formatted WeekDay.get(j) + "'s average temperature was " + DayTemp.get(j) (1 decimal place) + " degrees Fahrenheit."
                    dayFound = true
                    BREAK
                END IF
            END FOR
            
            IF dayFound is false THEN
                PRINT "Invalid input.  Please enter a valid day, 'week', or 'e'."
            END IF
        END IF
    END WHILE

    CLOSE Scanner
END MAIN



// METHOD: getValidDay

START METHOD getValidDay(scnr, validDays)
    // Variables scoped locally to getValidDay
    Declare found as boolean = false
    Declare i as integer = 0
    Declare currDay as String = null

    WHILE found is false DO
        READ currDay from scnr
        
        IF currDay equals "e" (ignoring case) THEN
            PRINT "Exiting program"
            TERMINATE PROGRAM
        END IF
        
        FOR i = 0 TO validDays.length-1 ++i
            IF currDay equals validDays[i] (ignoring case) THEN
                currDay = validDays[i] // Grabs clean capitalized title casing from array
                found = true
                BREAK
            END IF
        END FOR
        
        IF found is false THEN
            PRINT "Invalid input.  Spell the day completely ex: monday or Friday"
            PROMPT "Re-enter Day: "
        END IF
    END WHILE

    RETURN currDay
END METHOD



// METHOD: getValidTemp

START METHOD getValidTemp(scnr)
    // Variables scoped locally to getValidTemp
    Declare attempts as integer = 0
    Declare maxAttempts as integer = 3
    Declare currTemp as double

    // Initial Type Validation: Ensures entry is numeric
    WHILE input is not a valid double DO
        attempts = attempts + 1
        IF attempts >= maxAttempts THEN
            PRINT "Maximum attempts exceeded.  Exiting Program"
            TERMINATE PROGRAM
        END IF
        PRINT "Temperature must be entered as number ex: 65 or 65.5"
        PROMPT "Re-enter temperature: "
        READ and discard non-numeric token from scnr
    END WHILE

    READ currTemp as double from scnr

    // Range Validation: Ensures temp is between -150 and 115
    WHILE currTemp < -150 OR currTemp > 115 DO
        attempts = attempts + 1
        IF attempts >= maxAttempts THEN
            PRINT "Maximum attempts exceeded.  Exiting Program"
            TERMINATE PROGRAM
        END IF
        PRINT "Daily average temp must be in range -100 to 100"
        PROMPT "Re-enter temperature: "
        
        // Inner Type Validation  for re-entries
        WHILE input is not a valid double DO
            attempts = attempts + 1
            IF attempts >= maxAttempts THEN
                PRINT "Maximum attempts exceeded.  Exiting Program"
                TERMINATE PROGRAM
            END IF
            PRINT "Temperature must be entered as number in range -150 to 115 ex: 65 or 65.5"
            PROMPT "Re-enter temperature: "
            READ and discard non-numeric token from scnr
        END WHILE
        
        READ currTemp as double from scnr
    END WHILE

    RETURN currTemp
END METHOD
*/

public class WeeklyTemp {

	public static void main(String[] args) {
		
		ArrayList<String> WeekDay = new ArrayList<String>();
	    ArrayList<Double> DayTemp = new ArrayList<Double>();
	    String[] validDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	    Scanner scnr = new Scanner(System.in);
	    String currDay;
	    double currTemp;
	    int i = 0;

	    System.out.println("==========================================================================================");
	    System.out.println("                           Welcome to Daily Temperature Tracker                           ");
	    System.out.println("==========================================================================================");
	    System.out.println("");
	    System.out.println("Enter the day of the week + the days average temperature in fahrenheit.  Enter 'e' to exit");
	    //reads initial input for 7 days and their temperature
	    for (i=0; i<7; ++i){
	        System.out.print("Day: ");
	        currDay = getValidDay(scnr, validDays);
	        System.out.print("Average Temp: ");
	        currTemp = getValidTemp(scnr);
	        WeekDay.add(currDay);
	        DayTemp.add(currTemp);
	    }
	    
	    boolean menuRunning= true;
	    String userChoice;
	    //main menu that runs until 'e' is entered
	    while (menuRunning) {
	    	System.out.println("----------------------------------------------------------------------------------------");
	    	System.out.println("Enter a day of week, 'week' for summary, or 'e' for exit.");
	    	userChoice = scnr.next();
	    	int j = 0;
	    	if (userChoice.equalsIgnoreCase("e")) {
	    		System.out.println("Exiting program.");
	    		menuRunning= false;
	    	}
	    	//prints weekly summary and calculates average temp
	    	else if (userChoice.equalsIgnoreCase("week")) {
	    		double weeklySum = 0;
	    		
	    		System.out.println("--- Weekly Temperature Report---");
	    		
	    		for (j=0; j<WeekDay.size(); ++j) {  // prints formatted 'day: temp'
	    			System.out.printf("%-10s: %.1f degrees Fahrenheit%n", WeekDay.get(j), DayTemp.get(j));
	    			weeklySum += DayTemp.get(j);	
	    		}

	    		double weeklyAverage = weeklySum / WeekDay.size();
	    		System.out.println("----------------------------------------------------------------------------------------");
	    		System.out.printf("Weekly Average Temperature: %.1f degrees Fahrenheit%n", weeklyAverage);
	    			
	    	}
	    	//looks for user choice in WeekDay and pulls match with corresponding index in DayTemp
	    	else {
	    		boolean dayFound = false;
	    		for (j=0; j < WeekDay.size(); ++j) { //searches for specific day and prints formatted data if found
	    			if(userChoice.equalsIgnoreCase(WeekDay.get(j))) {
	    				System.out.printf("%s's average temperature was %.1f degrees Fahrenheit.%n", WeekDay.get(j), DayTemp.get(j));
	    				dayFound = true;
	    				break;
	    			}
	    		}
	    		
	    		if (!dayFound) {
		    		System.out.println("Invalid input.  Please enter a valid day, 'week', or 'e'.");
	    	}
	    	}	
	    }
	}
		//validates input is a double and within range -150 to 115
	 public static double getValidTemp(Scanner scnr){
	        int attempts = 0;
	        int maxAttempts = 3;
	       
	        while (! scnr.hasNextDouble()){  //Increases attempts variable for each bad input.  Exits after 3 invalids
	            attempts = attempts + 1;
	            if (attempts >= maxAttempts){
	                System.out.println("Maximum attempts exceeded.  Exiting Program");
	                System.exit(0);
	            }
	            System.out.println("Temperature must be entered as number in range -150 to 115 ex: 65 or 65.5");
	            System.out.print("Re-enter temperature: ");
	            scnr.next();
	        }
	        double currTemp = scnr.nextDouble();

	        while((currTemp < -150) || (currTemp > 115)){  //Ensure currTemp is in range -150 to 115
	            attempts = attempts +1;
	            if (attempts >= maxAttempts){
	                System.out.println("Maximum attempts exceeded.  Exiting Program");
	                System.exit(0);
	            }
	            System.out.println("Daily average temp must be in range -150 to 115");
	            System.out.print("Re-enter temperature: ");

	            while (! scnr.hasNextDouble()){  //Catches non numeric entries during range retry
	                attempts = attempts + 1;
	                if (attempts >= maxAttempts){
	                    System.out.println("Maximum attempts exceeded.  Exiting Program");
	                    System.exit(0);
	                }
	                System.out.println("Temperature must be entered as number between -150 ex: 65 or 65.5");
	                System.out.print("Re-enter temperature: ");
	                scnr.next();
	            }
	            currTemp = scnr.nextDouble();
	        }
	        return currTemp;
	    }
	    //Takes user input and compares to array of valid input day names
	    public static String getValidDay(Scanner scnr, String[] validDays){
	        boolean found = false;
	        int i = 0;
	        String currDay = null;

	        while(!found){  //loops until a valid day or 'e' is entered
	            currDay = scnr.next();
	            if(currDay.equalsIgnoreCase("e")){
	                System.out.println("Exiting program");
	                System.exit(0);
	            }
	            for (i=0; i<validDays.length; ++i){  
	                if (currDay.equalsIgnoreCase(validDays[i])){
	                	currDay = validDays[i]; //Grabs clean capitalized version from array ex: 'monday' to 'Monday'
	                    found = true;
	                    break;
	                }
	            }
	            if (!found){
	                System.out.println("Invalid input.  Spell the day completely ex: monday or Friday");
	                System.out.print("Re-enter Day: ");
	            
	            }
	         
	        }
	        return currDay;
	    }
}


