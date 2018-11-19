package module5;

import java.io.*;
import java.util.*;
import java.net.*;

public class DataAnalysis {
	
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
	
    // Calculate goodness of fit for data in an ArrayList of DataPoints by calculating a chi^2
    // The chi-squared is defined as the sum over all data points of the quantity:
    // (yi[data]-yi[theory])2/eyi[data]2

	public static double goodnessOfFit(Theory theoryObj, ArrayList<DataPoint> arrayData) throws Exception {

		// Initialise variables
		double chi2Sum = 0;		// Sum of all values for chi^2

		// Loop over all data in ArrayList and calculate chi2
		for ( DataPoint expDat : arrayData ) {

			// Retrieve individual data values from DataPoint point
			double dataX = expDat.getX();
			double dataY = expDat.getY();
			double dataEy = expDat.getEy();

			// Retrieve theory value
			double theoryY = theoryObj.y(dataX);

			// Calculate chi for DataPoint
			double chiDat = (dataY - theoryY)/(dataEy);

			// Square chi value and add to chi2
			chi2Sum += (chiDat * chiDat);

		}

		// Return calculated chi2 value
		return chi2Sum;

	}

	public static void main(String[] args) {

		// Initialise url String variable
		String url = "http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt";
		// Construct ArrayList of DataPoints from url
		ArrayList<DataPoint> mod5Array = new ArrayList<DataPoint>();
		// Create Theory objects for each prediction
		Theory theox2 = new Theory(2);
		Theory theox4 = new Theory(4);

		try {
			// Read data from URL
			mod5Array = dataFromURL(url);
			System.out.println("Successfully read "+mod5Array.size()+" values from URL into ArrayList of DataPoint objects.");

			// Compare values in the ArrayList to theory
			// Calculate chi^2 for x^2 prediction
			double chi2_2 = DataAnalysis.goodnessOfFit(theox2, mod5Array);

			// Calculate chi^2 for x^4 prediction
			double chi2_4 = DataAnalysis.goodnessOfFit(theox4, mod5Array);

			// Compare results
			System.out.println("chi2 for x^2 prediction: "+chi2_2);
			System.out.println("chi2 for x^4 prediction: "+chi2_4);
			if ( chi2_2 > chi2_4 ) {
				System.out.println("x^4 provides the better prediction.");
			}
			else if ( chi2_2 < chi2_4 ) {
				System.out.println("x^2 provides the better prediction.");				
			}
			else {
				System.out.println("Theories provide equally good predictions.");
			}
			
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}

}
