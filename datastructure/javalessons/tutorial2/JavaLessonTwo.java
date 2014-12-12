/**
 * Lesson about user input and output
 */

package tutorial2;

import java.util.Scanner;

public class JavaLessonTwo {
	
	static Scanner userInput =  new Scanner(System.in);
	
	public static void main(String[] args){
		System.out.println("Your favorite number: ");
		
		
		if(userInput.hasNextInt()){
			/**
			 * .hasNextDouble()
			 * .hasNextFloat()
			 * Boolean Byte Long Short
			 */
			int numberEntered = userInput.nextInt();
			
			System.out.println("You entered " + numberEntered);
			
			int numEnteredTimes2 = numberEntered*2;
			System.out.println(numberEntered + " + " + numberEntered + " = " + numEnteredTimes2);
			int numEnteredSquare = numberEntered*numberEntered;
			System.out.println(numberEntered + " * " + numberEntered + " = " + numEnteredSquare);
			
			numberEntered *=23;
			numberEntered -=1;
			numberEntered %=23;
			
			numberEntered++;
			numberEntered--;
			
			int numberABS = Math.abs(numberEntered);
			int whichIsBigger = Math.max(2, 6);
			int whichIsSmaller = Math.min(23, 345);
			
			//
			
			double numSqrt = Math.sqrt(5.34);
			
			int numCeiling = (int) Math.ceil(23.234);
			int numFloor = (int) Math.floor(34.34);
			int numRound = (int) Math.round(5.53);  //6
			
			int randomNumber = (int) (Math.random()*10); //10*(0~.99999999)
			System.out.println("Random number " + randomNumber);
			
		}else{
			System.out.println("Enter an integer next time");
		}
	}
}
