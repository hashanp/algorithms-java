package DataStructures;

public class BooleanMatrix {
	private int rows;
	private int cols;
	private boolean[][] data;
	
	public BooleanMatrix(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		data = new boolean[rows][cols];
	}
	
	public boolean get(int x, int y) {
		return data[x][y];
	}
	
	public void set(int x, int y, boolean val) {
		data[x][y] = val;
	}
}
