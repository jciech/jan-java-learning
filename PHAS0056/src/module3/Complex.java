package module3;

public class Complex {

	public static void main(String[] args) {
		
	}
	//defining member variables
	double re;
	double im;
	
	//constructors
	public Complex() {}
	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}
	
	//methods for finding real and imaginary parts of complex number
	double real() {
		double r = this.re;
		return r;
	}
	
	double imag() {
		double i = this.im;
		return i;
	}
	//defining other complex number operations
	public double modulus() {
		double mod = Math.sqrt(this.re*this.re+this.im*this.im);
		return mod;
	}
	public double angle() {
		double ang = Math.atan2(this.im,this.re);
		return ang;
	}
	public Complex conjugate() {
		double real = this.re;
		double cimag = -this.im;
		
		return new Complex(real,cimag);
	}
	public Complex normalised() throws Exception {
		if(this.modulus()==0) {
			throw new Exception("Zero cannot be normalised in C");
		}
		double mod = this.modulus();
		return new Complex(this.re/mod,this.im/mod);
	}
	public boolean equals(Complex c) {
		if (this.re == c.re && this.im == c.im) {
			return true;}
		return false;	
	}
	public String toString(){
		return this.re+" + "+this.im+" i";
	}
	
	//setting up method to create complex number from modulus and angle arguments
	public Complex setFromModulusAngle(double mag, double ang) {
		return new Complex(mag*Math.cos(ang),mag*Math.sin(ang));
	}
	
	//setting up operations on two complex numbers
	public static Complex add(Complex a, Complex b) {
		return new Complex(a.re+b.re,a.im+b.im);
	}
	
	public static Complex subtract(Complex a, Complex b) {
		return new Complex(a.re-b.re,a.im-b.im);
	}
	
	public static Complex multiply(Complex a, Complex b) {
		return new Complex(a.re*b.re-a.im*b.im,a.re*b.im+b.re*a.im); //this is just the expanded form of
																     //complex multiplication
	}
	public static Complex divide(Complex a, Complex b) throws Exception {
		if(b.im==0&&b.re==0) {
			throw new Exception("Division by zero is undefined");
		}
		return new Complex((a.re*b.re+a.im*b.im)/(b.re*b.re+b.im*b.im),(a.im*b.re-a.re*b.im)/(b.re*b.re+b.im*b.im));
		//The above is also just the expanded form of what happens when the numerator and denominator
		//are multilpied by the complex conjugate of the denomimator
	}
	
	//defining constants
	public static final Complex ONE() {
		return new Complex(1,0);
	}
	public static final Complex ZERO() {
		return new Complex(0,0);
	}
	public static final Complex I() {
		return new Complex(0,1);
	}
}
