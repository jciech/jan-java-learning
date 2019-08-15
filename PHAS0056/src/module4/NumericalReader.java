package module4;

import java.io.*; // For BufferedReader, InputStreamReader, InputStream, FileReader 
import java.net.URL; // For URL
import java.util.Scanner; // For Scanner

public class NumericalReader {

	// Creating variables which are later used in methods
	private double minPositiveValue;
	private String file;
	private int nPositiveValues, nNegativeValues;

	// Method which prompts the user to enter a string via the keyboard
	public static String getStringFromKeyboard() {

		// Instantiate the string object to store the variable
		String string = null;
		try {
			// Open InputStreamReader, BufferedReader from a system input and save the first
			// line to a string
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			string = br.readLine();
		} catch (IOException e) {
			System.out.println("Error while reading the string");
			e.printStackTrace();
		}
		return string;
	}

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

	// Method instantiating the analsysis process
	private void analysisStart(String dataFile) throws IOException {

		// Storing the dataFile variable locally when the method is called
		this.file = dataFile;

		// Creating a file called dataFile
		try (FileWriter f = new FileWriter(dataFile);) {
		}

		// Initialising private variables
		this.nNegativeValues = 0;
		this.nPositiveValues = 0;

		// To ensure that when checking any value initially it is not wrongly classified
		// we assign infinity to the smallest positive value
		this.minPositiveValue = Double.POSITIVE_INFINITY;

	}

	// Method performing the number analysis
	private void analyseData(String line) throws Exception {

		// Checking if line is empty
		if (line.isEmpty()) {
			return;
		}
		// Checking if line is a comment
		else if (Character.isLetter(line.charAt(0))) {
			return;
		} else {
			// Instantiate Scanner with the line the method is called for
			try (Scanner s = new Scanner(line);) {

				// Checking all existing values
				while (s.hasNextDouble()) {

					// Assigning value to variable for checking
					double valueCheck = s.nextDouble();

					// Update nNegativeValues, nPositiveValues and minPositiveValue
					if (valueCheck > 0) {
						if (valueCheck < this.minPositiveValue) {
							this.minPositiveValue = valueCheck;
						}
						this.nPositiveValues += 1;
					} else if (valueCheck < 0) {
						this.nNegativeValues += 1;
					}

				}
			}
		}
	}

	// Method to print out the results of the analysis
	private void analysisEnd() {
		
		System.out.println("The number of negative values in the dataset is: "+this.nNegativeValues);
		System.out.println("The number of positive values in the dataset is: "+this.nPositiveValues);
		System.out.println("The smallest of the numbers in the dataset is: "+this.minPositiveValue);
	
	}
	
	
}