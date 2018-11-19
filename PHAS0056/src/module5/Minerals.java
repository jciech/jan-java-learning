package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class Minerals {

	// Read data from URL - input as a string - and return the result as a HashMap
	public static HashMap<Integer, Double> readSampleDataFromURL(String urlName) throws IOException  {

		HashMap<Integer, Double> hashData = new HashMap<Integer, Double>();

		// Open URL from which to read data
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		// Loop through data in BufferedReader to extract numeric data for HashMap
		String line;
		while ((line = br.readLine()) != null) {
			try {
				// Create Scanner to read each line
				Scanner s = new Scanner(line);
				// Read out key value as integer
				int key = s.nextInt();
				// Read out mass as double
				double doubVal = s.nextDouble();
				// Add data to HashMap of sample data values
				hashData.put(key, doubVal);
				// Close Scanner
				s.close();
			}
			catch (RuntimeException e) {
				// Catch Exception if line or numbers aren't read properly
				System.out.println("Error: "+e.getMessage());
				System.out.println("Skipping line: "+line);
			}
		}

		// Close BufferedReader
		br.close();

		// Return HashMap containing all the relevant data
		return hashData;

	}

	// Read data from URL - input as a string - and return the result as a HashMap
	public static HashMap<Integer, String> readLocationDataFromURL(String urlName) throws Exception {

		HashMap<Integer, String> hashData = new HashMap<Integer, String>();

		// Open URL from which to read data
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		// Loop through data in BufferedReader to extract numeric data for HashMap
		String line;
		while ((line = br.readLine()) != null) {
			try {
				// Create Scanner to read each line
				Scanner s = new Scanner(line);
				// Read out location name as String
				String locName = s.next();
				// Read out key value as integer
				int key = s.nextInt();
				// Add data to HashMap of sample data values
				hashData.put(key, locName);
				// Close Scanner
				s.close();
			}
			catch (RuntimeException e) {
				// Catch Exception if line or numbers aren't read properly
				System.out.println("Error: "+e.getMessage());
				System.out.println("Skipping line: "+line);
			}

		}

		// Close BufferedReader
		br.close();

		// Return HashMap containing all the relevant data
		return hashData;
	}

	public static void main(String[] args) {

		// Initialise sample tracking variables
		double minMass = 0;
		double maxMass = 0;
		int minKey = 0;
		int maxKey = 0;
		int loopCount = 0;

		// Initialise url String variables
		String sampleURL = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-samples.txt";
		String locationURL = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-locations.txt";

		// Enclose in try/catch block in case reading from URL's throws Exceptions
		try {
			HashMap<Integer, Double> sampleMap   = readSampleDataFromURL(sampleURL);
			HashMap<Integer, String> locationMap = readLocationDataFromURL(locationURL);

			// Loop over all elements in HashMap to find min and max masses
			for (int key : sampleMap.keySet()) {
				double mass = sampleMap.get(key);
				loopCount++;
				// First time through loop, save current values as min and max values
				// Stops problems if min mass greater than zero
				if ( loopCount == 1 ) {
					maxMass = mass;
					maxKey = key;					
					minMass = mass;
					minKey = key;
				}
				// Update min and max masses
				if ( mass > maxMass) {
					maxMass = mass;
					maxKey = key;
				} else if ( mass < minMass) {
					minMass = mass;
					minKey = key;
				}
			}

			// Find locations of min and max masses based on key values
			String maxLoc = locationMap.get(maxKey);
			String minLoc = locationMap.get(minKey);

			System.out.println("Maximum mass:");
			System.out.println("  Sample: "+maxKey);
			System.out.println("  Mass: "+maxMass);
			System.out.println("  Location: "+maxLoc);
			System.out.println("Minimum mass:");
			System.out.println("  Sample: "+minKey);
			System.out.println("  Mass: "+minMass);
			System.out.println("  Location: "+minLoc);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}