package module5;

// Represents a hypothetical power-law relationship between variables x and y.
public class Theory {

	// Exponent in power-law relationship y = x^n
	// Private to prevent direct access
	private double n;

	// Class constructor: sets value of n
	public Theory(double n) {
		this.n = n;
	}

	// Method for returning value of y = x^n
	public double y(double x) {
		return Math.pow(x, this.n);
	}

}