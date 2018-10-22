package module3;

import java.util.Random;
import java.lang.Character;


public class Alphabet {

	public static void main(String[] args) {
		
	String StringBuilder = "";
	int exceptions = 0;
	int runTot = 0;
	
	for (j = 0; j < 401; j++) {
		char rc = randomCharacter();
		if(Character.isLetterOrDigit(rc) = True) {
			
		}
	}
	
	}
	public static char randomCharacter() {
	Random rnd = new Random();
	char c = (char)(rnd.nextInt(128));
	return c;
	}
}
