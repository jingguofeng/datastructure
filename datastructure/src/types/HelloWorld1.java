package types;

public class HelloWorld1 {

	public static void main(String[] args){
		
		byte bigByte = 127;
		short bigShort = 32767;
		int bigInt = 2100000000;
		long bigLong = 9220000000000000000L;
		float bigFloat = 3.14F;
		double bigDouble = 2.2342343152345345324534;
		
		System.out.println(Float.MAX_VALUE);
		System.out.println(Double.MAX_VALUE);
		
		boolean tureOrFalse = true;
		char randomChar = 65;
		char anotherChar = 'A';
		
		String randomString = "I'm a random string";
		String anotherString = "stuff";
		
		String andAnotherString = randomString + " " + anotherString;
		
		String byteString = Byte.toString(bigByte);
		String shortString = Short.toString(bigByte);
		String intString = Integer.toString(bigByte);
		String longString = Long.toString(bigByte);
		String floatString = Float.toString(bigByte);
		String doubleString = Double.toString(bigByte);
		
		System.out.println(randomChar + "..." + anotherChar);
		
		//Casting
		
		double aDoubleValue = 3;
		int doublToInt = (int) aDoubleValue;
		
		//convert string to primitive type
		
		int stringToInt = Integer.parseInt(intString);
		
		
		//parseShort, parseLong, parseByte, parseDouble, parseBoolean, parseFloat.
		
	}
}
