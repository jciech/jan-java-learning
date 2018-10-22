package module3;

public class FallingParticle {

	public static void main(String[] args) {

	}
	
	//defining variables
	double m; 
	double d; 
	double t;
	double z;
	double h;  
	double v;
	static final double g = 9.8; //value of g will not change and is independent
	
	//constructors
	public FallingParticle() {}
	public FallingParticle(double m,double d) throws Exception {
			if(m<0) {
				throw new Exception("The mass of the falling particle cannot be negative");
			}
			if(d<0) {
				throw new Exception("Negative drag coefficients are non physical");
			}
		 	this.m = m;
			this.d = d;
			this.v = 0;
			this.t = 0;
	}
	//setting up methods to update and retrieve height, velocity, position, and time elapsed
	//as neeeded
	public void setH(double height) throws Exception {
		if(height<0) {
			throw new Exception("Height cannot be deined as a negative value");
		}
		this.h = height;
	}
	
	public double getZ() {
		return this.z;
	}
	
	public void setV(double velocity) throws Exception {
		if(Math.abs(velocity)>3000000000.0) {
			throw new Exception("The velocity of an object cannot surpass the speed of light");
		}
		this.v = velocity;
	}
	
	public double getV() {
		return this.v;
	}
	
	public double getT() {
		return this.t;
	}
	
	public void doTimeStep(double deltaT) {
		double drag = this.d;
		if (getV()>0) {
			drag = -this.d;
		}
		double accel = ((this.v*this.v*drag)/this.m) - FallingParticle.g;
		
		double deltaV = accel*deltaT;
		this.v += deltaV;
		
		double deltaZ = this.v*deltaT;
		this.z += deltaZ;
		
		this.t += deltaT;
	}
		
	
	public void drop(double deltaT) {
		this.z = this.h;
		this.t = 0;
		try {
			setV(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		while( this.z > 0) {
			doTimeStep(deltaT);
		}
		System.out.println("Time step: "+deltaT+" s; Final position: "+getZ()+" m");
		System.out.println("Final time = "+getT()+" s; Final velocity = "+getV()+" m/s");
		System.out.println();

	}
}
