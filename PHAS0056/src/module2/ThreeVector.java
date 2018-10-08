package module2;

public class ThreeVector {

	public static void main(String[] args) {
		
	}
	
	// member variables
	private double x;
	private double y;
	private double z;
	
	//constructors (both for an empty ThreeVector and a defined one)
	public ThreeVector() {}
	public ThreeVector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	//method for calculating the magnitude of a ThreeVector
	double magnitude() { 												   //magnitude is a number
		double mag = Math.sqrt(this.x*this.x+this.y*this.y+this.z*this.z); //calculation
		return mag;
	}
	
	//method for finding the unit vector of a ThreeVector
	ThreeVector unitvector() {											   //a unit vector is a ThreeVector
		double magVector = this.magnitude();							   
		
		return new ThreeVector(this.x/magVector,this.y/magVector,this.z/magVector); //components are scaled by magnitude
	}
	String toString() {
		
	}
}