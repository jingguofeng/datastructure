package tutorial6;

/**
 * 
 * Exception (Two main exceptions):
 * 1.	java.lang.RunTimeException
 * 2.	java.lang.Exception
 * 
 * common exceptions:
 * 1. ArithmeticException
 * 2. ClassNotFoundException
 * 3. IllegalArgumentException
 * 4. IndexOutOfBoundaryException
 * @author jingguo
 *
 */

import java.util.*;
import java.io.*;
public class JavaLessonSix {

	static Scanner userInput = new Scanner(System.in);
	public static void main(String[] args){
		//divideByZero(2);
		
		/*
		System.out.println("How old are you?");
		int age = checkValidAge();
		
		if(age != 0){
			System.out.println("You are " + age + " years old");
		}
		*/
		
		//getAFile("./somestuff.txt");
		
		try{
			handleInMain("./someotherstuff.txt");
		}catch(IOException e){
			System.out.println("An IO Error Occured");
		}
	}
	
	
	public static void handleInMain(String fileName) throws FileNotFoundException{
		FileInputStream file = new FileInputStream(fileName);
	}
	
	public static void getAFile(String fileName){
		try {
			FileInputStream file = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Sorry can't find that file");
		}//catch(ClassNotFoundException e){
			
		//}
		catch(@SuppressWarnings("hiding") IOException e){
			System.out.println("Unknown IO Error");
		}catch(Exception e){
			System.out.println("Some error occured");
		}finally{
			System.out.println("");
		}
		
	}
	
	public static int checkValidAge(){
		try{
			return userInput.nextInt(); //input needs to be integer
		}catch(InputMismatchException e){
			userInput.next();
			System.out.println("That isn't a whole number");
			return 0;
		}
	}
	
	public static void divideByZero(int a){
		
		try{
			System.out.println(a/0);
		}catch(ArithmeticException e){
			System.out.println("You can't do that!");
			System.out.println(e.getMessage());
			//System.out.println(e.toString());
			
			e.printStackTrace();
		}
	}
}
