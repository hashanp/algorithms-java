package Geometry;

public class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point minus(Point other) {
		return new Point(x - other.x, y - other.y);
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	public int getCrossProduct(Point other) {
		return (this.x * other.y) - (other.x * this.y);
	}
}