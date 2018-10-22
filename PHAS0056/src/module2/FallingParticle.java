package module2;

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
	public FallingParticle(double m,double d) {
			this.m = m;
			this.d = d;
			this.v = 0;
			this.t = 0;
	}
	//setting up methods to update and retrieve height, velocity, position, and time elapsed
	//as neeeded
	public static void setH(double height) {
		this.h = height;
	}
	
	public static double getZ() {
		return this.z;
	}
	
	public static void setV(double velocity) {
		this.v = velocity;
	}
	
	public static double getV() {
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
		setV(0);
		
		while( this.z > 0) {
			doTimeStep(deltaT);
		}
		System.out.println("Time step: "+deltaT+" s; Final position: "+getZ()+" m");
		System.out.println("Final time = "+getT()+" s; Final velocity = "+getV()+" m/s");
		System.out.println();

	}
}
