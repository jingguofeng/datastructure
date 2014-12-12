package tutorial4;

import java.util.*;
public class JavaLessonFour {

	static Scanner userinput = new Scanner(System.in);
	
		public static void main(String[] args){
			int i = 1;
			while(i<=20){
				System.out.println(i);
				i++;
			}
			
			String contYorN = "Y";
			int h = 1;
			while(contYorN.equalsIgnoreCase("y")){
				System.out.println(h);
				System.out.print("Continue y or n? ");
				contYorN = userinput.nextLine();
				h++;
			}
		}
}
