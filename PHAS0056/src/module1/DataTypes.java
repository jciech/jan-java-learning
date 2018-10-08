package module1;

public class DataTypes {

	public static void main(String[] args) {
		
		double doubVar = 5.0;
		System.out.println("doubVar "+doubVar);
		float floatVar = 5;
		System.out.println("floatVar "+floatVar);
		int intVar = 5;
		System.out.println("intVar "+intVar);
		long longVar = 5;
		System.out.println("longVar "+longVar);
		byte byteVar = 5;
		System.out.println("byteVar "+byteVar);
		
		System.out.println(doubVar*doubVar);
		System.out.println(floatVar*floatVar);
		System.out.println(intVar*intVar);
		System.out.println(longVar*longVar);
		System.out.println(byteVar*byteVar);
		
		char charVar = 'c'+10;
		System.out.println(charVar);
		System.out.println("As characters take up 16 bit values, we understand that in the computer's memory, the 16 bit value of m corresponds to the 16 bit value of c + 10. This is the result of mixing a character value and an integer value.");

		int intVar2 = 12;
		System.out.println(intVar2+10.2);
		System.out.println("An integer added to a float gives a float.");
		
		int intVar3 = 1234567890;
		long longVar2 = 10*intVar3;
		System.out.println(longVar2);
		System.out.println("Mixing a 32 and 64 bit variable results an overflow.");
		//int j=1;
		//int i;
		//j=i+1;
		System.out.println("Using a variable whose value had not been initialised results in an error message; variables hold values and cannot be manipulated symbolically.");
		
		double doubVar2 = 4.99;
		int intdoubVar = (int) doubVar2;
		System.out.println(intdoubVar);
		System.out.println("When cast onto an integer, 4.99 becomes 4 as a cast simply discards information about the decimals on a float/double variable.");
		
	}

}
