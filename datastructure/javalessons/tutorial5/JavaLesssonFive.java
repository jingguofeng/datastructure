package tutorial5;

public class JavaLesssonFive {

	//static is not constrict in any class
	static double myPI = 3.14159265358979323846264;  //class variable
	
	int kk = 123;
	
	/**
	 * method is constructed by
	 * AccessModifier static return Type methodName(){}
	 */
	public static void main(String[] args){
		
		addThem(1,2);
		System.out.println("Global " + myPI);
	}
	
	public static int addThem(int a, int b){
		double smallPI = 3.140; //Local Variable
		
		double myPI = 3.14;
		System.out.println("Local " + myPI);
		
		//System.out.println("Class " + kk);
		return 1;
	}
}
