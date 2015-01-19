package big_data;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class max {
	

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		/*
		while(sc.hasNextLine()){
			
			System.out.println(sc.nextLine());			

		}
		*/
		
		String pattern = "^([0-9]{4})([-+][0-9]*)$";
		Pattern r = Pattern.compile(pattern);
		ArrayList<String> year = new ArrayList<String>();
		ArrayList<Integer> temperature = new ArrayList<Integer>();
		
		while(sc.hasNextLine()){
			String line = sc.nextLine();
			//System.out.println(line);			
			// Now create matcher object.
			Matcher m = r.matcher(line);
			if(m.find()){
		    
				String y = m.group(1);
				int t = Integer.parseInt(m.group(2));
				//System.out.println(y+" " + t);
				
				if(!year.contains(y)){
					year.add(y);
					int n = year.indexOf(y);
					temperature.add(n,t);
				}else{
					int n = year.indexOf(y);
					int old = temperature.get(n);
					if(old < t)
						temperature.set(n,t);
						
				}
			}
			
		}
		
		for(int j = 0; j < year.size(); j++){
			System.out.println(year.get(j) + temperature.get(j));
		}
		
	}

}
