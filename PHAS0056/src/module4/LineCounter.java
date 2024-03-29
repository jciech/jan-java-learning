package module4;

import java.io.*; //Importing necessary packages
import java.net.URL;
import java.util.Scanner;

public class LineCounter {

	// The method below takes as an argument an URL in the form of a string and
	// returns a BufferedReader object
	public static BufferedReader brfromURL(String urlName) throws IOException {

		URL u = new URL(urlName);
		InputStream is = u.openStream();

		// Creating a BufferedReader from the created InputStream object
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		return br;

	}

	// The method below takes as an argument a filename in the form of a string and
	// returns a BufferedReader object
	// It is constructed analogously to the method above

	public static BufferedReader brFromFile(String fileName) throws IOException {

		FileReader fr = new FileReader(fileName);

		// Creating a BufferedReader from the created FileReader object
		BufferedReader br = new BufferedReader(fr);
		return br;
	}

	// The method below finds the number of lines in a file specified by a
	// BufferedReader object.
	public static int countLinesInResource(BufferedReader dataAsBR) {

		//Initialise word count variable
		//Instantiating a string variable which will be used to check whether a line is empty or not
		int countLines = 0;
		String line = new String();
		
		// Using a try block to ensure the Scanner is closed
		try (Scanner s = new Scanner(dataAsBR);) {

			// While loop to find number of lines
			while (s.hasNextLine()) {
				line = s.nextLine();
				//Checking if line is empty and skipping it if it is
				if (line.trim().isEmpty()){
				;
				}
				else {
					countLines++;
				}
				
			}
		}
		return countLines;
	}

	public static void main(String[] args) {
		
	boolean success = true;
	String name = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt";

		try {
			//Interpret String as filename first and if an exception is thrown interpret it as an URL
			BufferedReader brf = LineCounter.brFromFile(name);
			int linesf = LineCounter.countLinesInResource(brf);
			System.out.println("The number of lines in the file is "+linesf);
			success = false;
			
		}
		catch (IOException e) {
			System.out.println("Error in URL/file name or while reading file.");
			e.printStackTrace();
		}
		if (success) {
			try {
				BufferedReader bru = LineCounter.brfromURL(name);
				int linesu = LineCounter.countLinesInResource(bru);
				System.out.println("The number of lines in the file is "+linesu);
			}
			catch (IOException f) {
				System.out.println("Error in URL/file name or while reading file.");
				f.printStackTrace();
			}
		}
	
	}
}
