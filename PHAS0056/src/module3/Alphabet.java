package module3;

import java.util.Random;
import java.lang.Character;


public class Alphabet {

	public static void main(String[] args) {
		
	StringBuilder s = new StringBuilder();
	int exceptions = 0;
	int runTot = 0;
	
	for (int i = 0;i<401;i++) {
		char r = randomCharacter();
		if (Character.isLetterOrDigit(r)==true) {
			s.append(r);
			try {
				runTot += Integer.parseInt(Character.toString(r));
			} catch (Exception e) {
				exceptions += 1;
			}
		}
	}
	System.out.println("The contents of the StringBuilder object are:");
	System.out.println(s);
	System.out.println("The sum of all numbers added together is "+runTot+".");
	System.out.println("The number of exceptions thrown out of the Integer.parseInt() method is "+exceptions+".");
	
	
	}
	public static char randomCharacter() {
	Random rnd = new Random();
	char c = (char)(rnd.nextInt(128));
	return c;
	}
}
