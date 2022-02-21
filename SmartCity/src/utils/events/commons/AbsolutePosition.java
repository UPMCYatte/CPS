package utils.events.commons;


public class AbsolutePosition {
	
	private double x;
	private double y;
	
	public AbsolutePosition(double x, double y) {
		// TODO Auto-generated constructor stub
		this.x=x;
		this.y=y;
	}
	
	public boolean equals(Object p) {
		if(p == null) return false;
		if(p == this) return true;
		if(p.getClass() != getClass()) return false;
		AbsolutePosition ap = (AbsolutePosition) p;
		return ap.x == this.x && ap.y == this.y;	
	}
	
	public String toString() {
		return "("+x+";"+y+")";
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double distance(AbsolutePosition p) {
		return Math.sqrt( (Math.pow((x-p.getX()), 2)) + (Math.pow((y-p.getY()), 2)));
	}
}
