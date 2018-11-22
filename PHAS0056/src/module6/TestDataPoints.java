package module6;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;


public class TestDataPoints {

	public static void main(String[] args) {

	}

	public static ArrayList<DataPoint> dataFromURL(String url) throws Exception {

		// Initialise variables
		String line = "";
		ArrayList<DataPoint> urlData = new ArrayList<DataPoint>();

		// Open URL from which to read data
		URL u = new URL(url);
		InputStream is = u.openStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		// Loop through data in BufferedReader to extract numeric data for HashMap
		while ((line = br.readLine()) != null) {

			try {
				// Add data to ArrayList of DataPoints
				DataPoint dp = DataPoint.fromText(line);
				urlData.add(dp);
			}
			catch (RuntimeException e) {
				// Catch Exception if line or numbers aren't read properly
				System.out.println("Error: "+e.getMessage());
				System.out.println("Skipping line: "+line);
			}

		}

		// Close BufferedReader
		br.close();

		// Return ArrayList containing all the relevant data
		return urlData;

	}
}
