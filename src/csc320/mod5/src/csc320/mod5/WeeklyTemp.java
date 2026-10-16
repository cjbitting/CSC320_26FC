package csc320.mod5;

public class WeeklyTemp {

	public static void main(String[] args) {
		
		
		
		
	
		

	}

}


/*
- Declare WeekDay as ArrayList of String
- Declare DayTemp as ArrayList of Double
- Declare validDays as Array of String = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"]
- Declare currDay as String
- Declare currTemp as double
- Declare userChoice as String
- Declare menuRunning as boolean = true
- Declare weeklySum as double = 0.0
- Declare weeklyAvg as double = 0.0
- Declare dayFound as boolean
- Declare i as integer

- Initialize Scanner

- PRINT "Enter the day of the week + the days average temperature in fahrenheit. Enter 'e' to exit"

- for i=0; i < 7; ++i
    PROMPT: "Day: "
    currDay = call getValidDay(scnr, validDays)
    
    PROMPT: "Average Temp: "
    currTemp = call getValidTemp(scnr)
    
    ADD currDay to WeekDay
    ADD currTemp to DayTemp
  END FOR

- QUERY MENU: loops until user enters 'e'
- WHILE menuRunning is true
    PROMPT: "Enter a day of the week, 'week' to view all data and average, or 'e' to exit: "
    Read userChoice as String
    
    IF userChoice equals "e" (ignoring case) then
        PRINT "Exiting program. Goodbye!"
        menuRunning = false
    ELSE IF userChoice equals "week" (ignoring case) then
        weeklySum = 0.0
        PRINT "--- Weekly Temperature Report ---"
        for i=0; i < WeekDay.size(); ++i
            PRINT WeekDay.get(i) + ": " + DayTemp.get(i) + "°F"
            weeklySum = weeklySum + DayTemp.get(i)
        END FOR
        weeklyAvg = weeklySum / DayTemp.size()
        PRINT "Weekly Average Temperature: " + formatted weeklyAvg (two decimals) + "°F"
    ELSE
        dayFound = false
        for i=0; i < WeekDay.size(); ++i
            IF userChoice equals WeekDay.get(i) (ignoring case) then
                PRINT WeekDay.get(i) + ": " + DayTemp.get(i) + "°F"
                dayFound = true
                BREAK
            END IF
        END FOR
        
        IF dayFound is false then
            PRINT "Invalid choice. Please enter a valid day of the week, 'week', or 'e' to exit."
        END IF
    END IF
  END WHILE

- CLOSE Scanner


METHOD getValidDay(scnr, validDays):
- Declare found as boolean = false
- Declare currDay as String
- Declare i as integer

- WHILE found is false
    Read currDay as String
    
    IF currDay equals "e" (ignoring case) then
        PRINT "Exiting program"
        TERMINATE PROGRAM
    END IF
    
    for i=0; i < validDays.length; ++i
        IF currDay equals validDays[i] (ignoring case) then
            found = true
            BREAK
        END IF
    END FOR
    
    IF found is false then
        PRINT "Invalid input.  Spell the day completely ex: monday or Friday"
        PROMPT "Re-enter Day: "
    END IF
  END WHILE

  RETURN currDay
END METHOD


METHOD getValidTemp(scnr):
- Declare attempts as integer = 0
- Declare maxAttempts as integer = 3
- Declare currTemp as double

- TYPE VALIDATION: loops if input not numeric
- WHILE input not valid double:
    attempts = attempts + 1
    IF attempts >= maxAttempts then
        PRINT "Maximum attempts exceeded.  Exiting Program"
        TERMINATE PROGRAM
    END IF
    PRINT "Temperature must be entered as number ex: 65 or 65.5"
    PROMPT "Re-enter temperature: "
    Read and discard non numeric input from scanner
  END WHILE

  Read currTemp as double

- RANGE VALIDATION: loops while temp not within range -100 to 100
- WHILE currTemp < -100 or currTemp > 100
    attempts = attempts + 1
    IF attempts >= maxAttempts then
        PRINT "Maximum attempts exceeded.  Exiting Program"
        TERMINATE PROGRAM
    END IF
    PRINT "Daily average temp must be in range -100 to 100"
    PROMPT "Re-enter temperature: "
    
    Inner type validation for re attempts
    WHILE input is not valid double
        attempts = attempts + 1
        IF attempts >= maxAttempts then
            PRINT "Maximum attempts exceeded.  Exiting Program"
            TERMINATE PROGRAM
        END IF
        PRINT "Temperature must be entered as number ex: 65 or 65.5"
        PROMPT "Re-enter temperature: "
        Read and discard non numeric input from scanner
    END WHILE
    
    Read currTemp as double
  END WHILE

  RETURN currTemp
END METHOD
*/