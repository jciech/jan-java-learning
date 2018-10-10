package module2;

public class TestThreeVector {

	public static void main(String[] args) {
		
		//defining prescribed vectors
		ThreeVector v1 = new ThreeVector(4,5,3);
		ThreeVector v2 = new ThreeVector(1,4,2);
		ThreeVector v3 = new ThreeVector(0,0,0);
		
		//printing out vectors and their unit vectors
		System.out.println("v1 = "+v1+" and its unit vector is: "+v1.unitvector());
		System.out.println("v2 = "+v2+" and its unit vector is: "+v2.unitvector());
		System.out.println("v3 = "+v3+" and its unit vector is: "+v3.unitvector());

		//using static methods 
		System.out.println("The below results were calculated using static methods:");
		System.out.println("The scalar product of v1 and v2 is "+ThreeVector.scalarProduct(v1,v2));
		System.out.println("The scalar product of v1 and v3 is "+ThreeVector.scalarProduct(v1,v3));
		System.out.println("The vector product of v1 and v2 is "+ThreeVector.vectorProduct(v1,v2));
		System.out.println("The vector product of v1 and v3 is "+ThreeVector.vectorProduct(v1,v3));
		System.out.println("The angle between v1 and v2 is "+ThreeVector.angle(v1,v2));
		System.out.println("The angle between v1 and v3 is "+ThreeVector.angle(v1,v3));
		
		//using non-static methods
		System.out.println("The below results were calculated using non-static methods");
		System.out.println("The scalar product of v1 and v2 is "+v1.scalarProduct(v2));
		System.out.println("The scalar product of v1 and v3 is "+v1.scalarProduct(v3));
		System.out.println("The vector product of v1 and v2 is "+v1.vectorProduct(v2));
		System.out.println("The vector product of v1 and v3 is "+v1.vectorProduct(v3));
		System.out.println("The angle between v1 and v2 is "+v1.angle(v2));
		System.out.println("The angle between v1 and v3 is "+v1.angle(v3));
		
		System.out.println("The angles between vectors are given in radians and where NaN is output");
		System.out.println("it is a result of one of the vectors being the zero vector.");
		
		
		//after commenting out the toString method the following was observed
		System.out.println("When the toString method is commented out, the console displays");
		System.out.println("the adresses of the ThreeVector variables but does not recognise");
		System.out.println("how they should be treated.");
		
	}

}
