package module2;

public class TestComplex {

	public static void main(String[] args) {
		//defining complex numbers
		Complex c1 = new Complex(1,-2);
		Complex c2 = new Complex(-2,1);
		
		
		//all operations are working as intended
		System.out.println("The product of c1 and c2 is "+Complex.multiply(c1,c2)+".");
		System.out.println("The ratio of c1 and c2 is "+Complex.divide(c1, c2)+".");
		System.out.println("The product of c1 and I is "+Complex.multiply(c1, Complex.I())+".");
		System.out.println("The ratio of c1 and ZERO is "+Complex.divide(c1, Complex.ZERO())+".");
		System.out.println("The product of c1 and its conjugate is "+Complex.multiply(c1,c1.conjugate())+".");
		System.out.println("The product of c2 and its conjugate is "+Complex.multiply(c2,c2.conjugate())+".");

	}

}
