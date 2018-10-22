package module3;

public class ThreeVector {

	public static void main(String[] args) {
		
	}
	
	// member variables
	double x;
	double y;
	double z;
	
	//constructors 
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
	ThreeVector unitvector() throws Exception {											   //a unit vector is a ThreeVector
		if(this==new ThreeVector(0,0,0)) {
			throw new Exception("The unit vector of the zero vector cannot be found");
		}
		double magVector = this.magnitude();							   
		
		return new ThreeVector(this.x/magVector,this.y/magVector,this.z/magVector); //components are scaled by magnitude
	}
	
	//method for listing elements of ThreeVector as string
	public String toString() {
		return "(" + this.x + "," + this.y + "," + this.z + ")";
		
	}
	
	//all methods below are static cases for the functions required for this exercise:
	
	//method for finding scalar product between vectors vec1 and vec2
	public static double scalarProduct(ThreeVector vec1, ThreeVector vec2) {
		double dot = vec1.x*vec2.x+vec1.y*vec2.y+vec1.z*vec2.z;
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
	public static double angle(ThreeVector vec1, ThreeVector vec2) throws Exception {
		if(vec1==new ThreeVector(0,0,0)||vec2==new ThreeVector(0,0,0)) {
			throw new Exception("The angle between a vector and the zero vector is undefined");
		}
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
		try {
			return angle(this, vec);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}