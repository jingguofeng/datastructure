package big_data;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class filter {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		//System.out.println("Printing the file after filtering:");
		//System.out.println("Measurement Year   " + "   Temperature");
		String pattern1 = "^[0-9]{10}9{5}([0-9]{4})";
	    String pattern2 = "1N[0-9]([-+])0{0,3}([0-9]{1,4})[0-9]{1}[-+]";
	    // Create a Pattern object
	    Pattern r1 = Pattern.compile(pattern1);
	    Pattern r2 = Pattern.compile(pattern2);		
	    
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			//System.out.println(line);			
			// Now create matcher object.
			Matcher m1 = r1.matcher(line);
		    Matcher m2 = r2.matcher(line);
		    /*
		    if(m1.find())
				System.out.print("      " + m1.group(1)+ "   ");		    
			if(m2.find())
				System.out.println("             " + m2.group(1) + m2.group(2));	
		*/
		    if(m1.find() && m2.find())
		    	System.out.println(m1.group(1)+m2.group(1)+m2.group(2));
		}

	}
}
