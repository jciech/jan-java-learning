package module2;

public class FallingParticle {

	public static void main(String[] args) {

	}
	
	//defining variables
	double m; 
	double d; 
	static double t;
	static double z;
	static double h;  
	static double v;
	static final double g = 9.8; //value of g will not change and is independent
	
	//constructors
	public FallingParticle() {}
	public FallingParticle(double m,double d) {
			this.m = m;
			this.d = d;
			FallingParticle.h = 0;
			FallingParticle.z = h;
			FallingParticle.t = 0;
			FallingParticle.v = 0;
	}
	//setting up methods to update and retrieve height, velocity, position, and time elapsed
	//as neeeded
	public static void setH(double height) {
		FallingParticle.h = height;
	}
	
	public static double getZ() {
		return FallingParticle.z;
	}
	
	public static void setV(double velocity) {
		FallingParticle.v = velocity;
	}
	
	public static double getV() {
		return FallingParticle.v;
	}
	
	public double getT() {
		return FallingParticle.t;
	}
	
	public void doTimeStep(double deltaT) {
		double a = ((this.d * FallingParticle.v * FallingParticle.v)/this.m) - g;
		FallingParticle.setV(a * deltaT);
		FallingParticle.setH(FallingParticle.getV() * deltaT);
		FallingParticle.z = FallingParticle.h;
	}
	
	public static void drop(double deltaT) {
		while (FallingParticle.getZ()>=0) {
			
		}
	}
}
