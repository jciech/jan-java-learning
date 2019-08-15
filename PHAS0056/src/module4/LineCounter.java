package module4;

import java.io.*; //Importing necessary packages
import java.net.URL;
import java.util.Scanner;

public class LineCounter {
	
	//The method below takes as an argument an URL in the form of a string and returns a BufferedReader object
	public static BufferedReader brfromURL(String urlName) throws IOException {
		
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		
		// Creating a BufferedReader from the created InputStream object
		InputStreamReader isr  = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;
		
	}
	
	//The method below takes as an argument a filename in the form of a string and returns a BufferedReader object
	//It is constructed analogously to the method above
	
	public static BufferedReader brFromFile(String fileName) throws IOException {

		FileReader fr = new FileReader(fileName);

		// Creating a BufferedReader from the created FileReader object
		BufferedReader br = new BufferedReader(fr);
		return br;
	}
	
	//The method below finds the number of lines in a file specified by a BufferedReader object.
	public static int countLinesInResource(BufferedReader dataAsBR) {

		// Initialise word count variable
		int countLines = 0;
		
		// Using a try block to ensure the Scanner is closed
		try (Scanner s = new Scanner(dataAsBR);){

			//While loop to find number of lines
			while (s.hasNextLine()) {
				s.nextLine();
				countLines++;
			}
		}
		return countLines;
		}

	
	
	
}