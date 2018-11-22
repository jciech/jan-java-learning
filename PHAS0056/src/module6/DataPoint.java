package module6;

import java.util.Scanner;

//Represents a data point with x and y values and an error on y.
public class DataPoint {

	// Private member variables:
	// private to prevent direct access/modification
	protected double x;
	protected double y;
	protected double ey;

	// Class constructor: sets the 3 member variables
	public DataPoint(double x, double y, double ey) {
		this.x = x;
		this.y = y;
		this.ey = ey;
	}

	// Method for retrieving x variable
	public double getX() {
		return this.x;
	}

	// Method for retrieving y variable
	public double getY() {
		return this.y;
	}

	// Method for retrieving ey variable
	public double getEy() {
		return this.ey;
	}

	// toString method for generating properly formatted output
	public String toString() {
		String datString = "x = "+this.x+"; y = "+this.y+"; ey = "+this.ey;
		return datString;
	}

	// Parse DataPoint data from data String
	// Throws Exception if data not parsed correctly
	public static DataPoint fromText(String line) throws Exception {

		// Instantiate Scanner from input String
		Scanner s = new Scanner(line);

		// Read DataPoint data from line
		// Read out 3 double data values
		double x = s.nextDouble();
		double y = s.nextDouble();
		double ey = s.nextDouble();

		// Close Scanner
		s.close();
		return new DataPoint(x, y, ey);

	}

}