package module1;

public class VectorMethods {

	public static void main(String[] args) {
		VectorMethods vm = new VectorMethods();
		System.out.println("The angle between the first set of vectos in radians is: "+vm.angle(4, 3, 2, 1, 5, 4)+". This is the correct result.");
		System.out.println(vm.angle(4, 3, 2, 0, 0, 0));
		System.out.println("The second evaluation turns up as NaN as it involves division by zero; mathematically, it also doesn't make sense to find the angle between a vector and the 0 vector.");
	}
	public double dotProduct(double Xpos1, double Ypos1, double Zpos1, double Xpos2, double Ypos2, double Zpos2) {
		double prod = Xpos1 * Xpos2 + Ypos1 * Ypos2 + Zpos1 * Zpos2;
		return prod;
	}
	
	public double magnitude(double Xpos, double Ypos, double Zpos) {
		double mag = Math.sqrt(Xpos * Xpos + Ypos * Ypos + Zpos * Zpos);
		return mag;
	}
	public double angle(double Xpos1, double Ypos1, double Zpos1, double Xpos2, double Ypos2, double Zpos2) {
		double ang = Math.acos((dotProduct(Xpos1,Ypos1,Zpos1,Xpos2,Ypos2,Zpos2))/(magnitude(Xpos1,Ypos1,Zpos1) * magnitude(Xpos2,Ypos2,Zpos2)));
		return ang;
	}
}
