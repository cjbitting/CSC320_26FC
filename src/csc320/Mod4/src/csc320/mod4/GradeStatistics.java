package csc320.mod4;

import java.util.Scanner;

public class GradeStatistics {

	public static void main(String[] args) {
		
		/*
		 * Declare numIntputs as integer = 10;
		 * Declare inputCount as integer = 1;
		 * Declare totalScore as double;
		 * Declare maximumGrade as double;
		 * Declare minimumGrade as double;
		 * Declare averageGrade as double: 
		 * Declare currValue as double;
		 * Declare i as integer;
		 * 
		 * Initialize Scanner
		 * 
		 * for i=0; i < numInputs; ++i
		 *    PROMPT: "Please enter grade " + inputCount + ": "
		 *    
		 *    TYPE VALIDATION:  loops if input not numeric
		 *    While input not valid double:
		 *    	PRINT "Grade must be input as number ex: 85 or 85.5"
		 *    	PROMPT "Please re-enter grade " + inputCount + ": "
		 *    	Read new input from scanner, disregard invalid inputs
		 *    END WHILE
		 *    
		 *    Read currValue as double
		 *    
		 *    RANGE VALIDATION: loops while grade not within range 0 to 100
		 *    WHILE currValue < 0 or currValue > 100
		 *    	PRINT "Invalid input.  Grade must be in range 0 to 100."
		 *    	PROMPT "Please re-enter grade " + inputCount + ": "
		 *    	
		 *    	Inner type validation for re attempts
		 *    
		 *    	WHILE input is not valid double
		 *    		PRINT " Grade must be input as number."
		 *    		PROMPT "Re-enter grade " + inputCount + ": "
		 *    		Read new input from scanner, disregard invalid inputs
		 *    	END WHILE
		 *    
		 *		Read currValue as double
		 *	
		 *   END WHILE
		 *
		 *	ACCUMULATE totalScore
		 *  totalScore = totalScore + currValue
		 *  
		 *  TRACK MINIMUM AND MAXIMUM
		 *  
		 *  IF i==0 then
		 *  	maximumGrade = currValue
		 *  	minimumGrade = currValue
		 *  ELSE
		 *  	IF currValue > maximumGrade
		 *  		maximumGrade = currValue
		 *  	END IF
		 *  
		 *  	IF currValue < minimumGrade
		 *  		minimumGrade = currValue
		 *  	END IF
		 *  END IF
		 *  
		 *  inputCount = inputCount + 1
		 *  
		 *  END FOR
		 *  
		 *  averageGrade = totalScore / numInputs
		 *  
		 *  PRINT "Average Grade" + formatted averageGrade (two decimals)
		 *  PRINT "Maximum Grade" + formatted maximumGrade (two decimals)
		 *  PRINT "Minimum Grade" + formatted minimumGrade (two decimals)
		 *  
		 *  
		 */
		Scanner scnr = new Scanner(System.in);
		
		int numInputs = 10;
		double averageGrade = 0.0;
		double maximumGrade = 0.0;
		double minimumGrade = 0.0;
		double totalScore = 0.0;
		double currValue;
		int i;
		int inputCount = 1;
		
//For loop to receive 10 inputs and validate that inputs are doubles
		
        for (i = 0; i < numInputs; ++i) {
            System.out.print("Please enter grade " + inputCount + ": ");
            while (! scnr.hasNextDouble()) {
                System.out.println("Grade must be input as number ex: 85 or 85.5");
                System.out.print(" Please re-enter grade " + inputCount + ": ");
				scnr.next();

          }
			currValue = scnr.nextDouble();

//Validate input is between 0 and 100 for any re entries
			while ((currValue < 0) || (currValue > 100)) {
				System.out.println("Invalid input.  Grade must be in range 0 to 100. ");
				System.out.print(" Re-enter grade " + inputCount + ": ");
				
				
				while (! scnr.hasNextDouble()){
					System.out.println("Grade must be input as number.");
					System.out.print("Re-enter grade " + inputCount + ": ");
					scnr.next();
				}
				currValue = scnr.nextDouble();
			}
			
			totalScore = currValue + totalScore;
			
			if (i == 0) {
				maximumGrade = currValue;  //sets first input to maximumGrade
				minimumGrade = currValue;  //sets first input to minimumGrade
			
			}
			else {
				if (currValue > maximumGrade) { //compare currValue to maximumGrade
					maximumGrade = currValue;
				}
				if (currValue < minimumGrade) {  //compare curValue to minimumGrade
					minimumGrade = currValue;
				}
			
			}
			inputCount += 1;
		}
        
        averageGrade = totalScore / numInputs; //calculate average grade
        
        //formatted output for variables 
        
        System.out.printf("Average Grade: %.2f%n", averageGrade);
        System.out.printf("Maximum Grade: %.2f%n", maximumGrade);
        System.out.printf("Minimum Grade: %.2f%n", minimumGrade);

		
    }
}
	