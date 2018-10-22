package module3;

public class TestExceptions {

	public static void main(String[] args) {
		// testing division by zero in complex class
		try {
			Complex c1 = new Complex(4,6);
			Complex.divide(c1, Complex.ZERO());
		} catch (Exception e) {
			System.out.println(e);
		}
		// testing normalisation of zero in complex class
		try {
			Complex c2 = new Complex(0,0);
			c2.normalised();
		} catch (Exception e) {
			System.out.println(e);
		}
		// finding unit vector of length a vector of length zero 
		try {
			ThreeVector v1 = new ThreeVector(0,0,0);
			v1.unitvector();
		} catch (Exception e) {
			System.out.println(e);
		}
		// finding angle between a vector and the zero vector
		try {
			ThreeVector v2 = new ThreeVector(2,3,5);
			ThreeVector v3 = new ThreeVector(0,0,0);
			ThreeVector.angle(v2, v3);
		} catch (Exception e) {
			System.out.println(e);
		}
		// defining a particle with negative mass
		try {
			FallingParticle f1 = new FallingParticle(-5,1);
		} catch (Exception e) {
			System.out.println(e);
		}
		// defining a particle for which the drag coefficient is negative
		try {
			FallingParticle f1 = new FallingParticle(1,-5);
		} catch (Exception e) {
			System.out.println(e);
		}
		// setting a velocity over the speed of light
		try {
			FallingParticle f2 = new FallingParticle(2,2);
			f2.setV(3000000000.4);
		} catch (Exception e) {
			System.out.println(e);
		}
		// setting a negative initial height 
		try {
			FallingParticle f3 = new FallingParticle(4,2);
			f3.setH(-2);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
