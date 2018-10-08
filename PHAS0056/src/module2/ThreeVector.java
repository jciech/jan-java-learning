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
	
	//method for listing elements of ThreeVector as string
	public String toString() {
		return "x = " + this.x + ", y = " + this.y + ", z = " + this.z;
		
	}
	
	//all methods below are static cases for the functions required for this exercise:
	
	//method for finding scalar product between vectors vec1 and vec2
	public static double scalarProduct(ThreeVector vec1, ThreeVector vec2) {
		double dot = vec1.x*vec2.x+vec1.y*vec2.y+vec1.z+vec2.z;
		return dot;
	}
	
	//method for finding vector products between vectors vec1 and vec2
	public static ThreeVector vectorProduct(ThreeVector vec1, ThreeVector vec2) {
		return new ThreeVector(vec1.y*vec2.z-vec1.z*vec2.y,vec1.z*vec2.x-vec1.x*vec2.z,vec1.x*vec2.y-vec1.y*vec2.z);
		//the above code constructs a new vector as per the standard prescription in 3 dimensions
	}
	
	//method for adding vectors together
	public static ThreeVector add(ThreeVector vec1, ThreeVector vec2) {
		return new ThreeVector(vec1.x+vec2.x,vec1.y+vec2.y,vec1.z+vec2.z);
	}
	
	//method for finding the angle between two vectors using methods defined above
	public static double angle(ThreeVector vec1, ThreeVector vec2) {
		double ang = Math.acos(scalarProduct(vec1, vec2)/(vec1.magnitude()*vec2.magnitude()));
		return ang;
	}
	
	//for non-static versions:
	
	//scalar product
	public double scalarProduct(ThreeVector vec) {
		return scalarProduct(this,vec);
	}
	
	//vector product
	public ThreeVector vectorProduct(ThreeVector vec) {
		return vectorProduct(this, vec);
	}
	//addition
	public ThreeVector add(ThreeVector vec) {
		return add(this,vec);
	}
	//angle
	public double angle(ThreeVector vec) {
		return angle(this, vec);
	}
}