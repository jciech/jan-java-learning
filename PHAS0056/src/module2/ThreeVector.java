package module2;

public class ThreeVector {

	public static void main(String[] args) {
		
	}
	private double X;
	private double Y;
	private double Z;
	public ThreeVector() {}
	
	void setX(double x) {
		X = x;
	}
	void setY(double y) {
		Y = y;
	}
	void setZ(double z) {
		Z = z;
	}
	
	double getX() {
		return X;
	}
	double getY() {
		return Y;
	}
	double getZ() {
		return Z;
	}
	double magnitude() {
		double mag = Math.sqrt(X*X+Y*Y+Z*Z);
		return mag;
	}
	ThreeVector unitvector(ThreeVector vector) {
		ThreeVector unit;
		unit.setX((vector.getX()/vector.magnitude()));
	}
}
