package module6;

public class LabelledDataPoint extends DataPoint{
	
	public String label;
	public LabelledDataPoint (double x, double y, double ey, String label) {
		super(x,y,ey);
		this.label = label;
	}
	
	@Override
	public String toString() {
		String datString = this.label+":x = "+this.x+"; y = "+this.y+"; ey = "+this.ey;
		return datString;
	}
}
