package tutorial3;

public class LessonThree {

	public static void main(String[] args){
		
		int randomNumber = (int) (Math.random()*50);
		
		/**
		 * Relational Operations:
		 * Java has 6 relational operator
		 * > : Greater Than
		 * < : Less Than
		 * == : Equal To
		 * != : Not Equal To
		 * >= :Greater Than Or Equal To
		 * <= : Less Than Or Equal To
		 */
		
		
		/**
		 * Logical Operators:
		 * Java has 6 logical operators
		 * ! : Converts the boolean value to its right to its opposite
		 * & : Returns true if boolean value on the right and left are
		 * && :
		 * | :
		 * || :
		 * ^ : Return true if there is 1 true and 1 false boolean value together
		 *
		 */
		
		
		int valueOne = 1;
		int valueTwo = 2;
		
		int biggestValue = (valueOne > valueTwo) ? valueOne : valueTwo;
		System.out.println(biggestValue);
		
		char theGrade = 'B';
		
		switch (theGrade){
		
		case 'A':
			System.out.println("Great job");
			break;
		case 'B':
			System.out.println("Great job");
			break;
		case 'C':
			System.out.println("Great job");
			break;
		case 'D':
			System.out.println("Great job");
			break;
		default:
			System.out.println("You Failed");
			break;
		}
		
	}
}
