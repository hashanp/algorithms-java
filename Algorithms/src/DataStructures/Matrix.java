package DataStructures;

import java.util.Arrays;

public class Matrix {
	public int rows;
	public int cols;
	private int[][] data;
	
	public Matrix(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		data = new int[rows][cols];
	}
	
	public int get(int m, int n) {
		return data[m][n];
	}
	
	public void set(int m, int n, int t) {
		data[m][n] = t;
	}
	
	public Matrix multiply(Matrix other) {
		if(this.cols != other.rows) {
			throw new IllegalArgumentException();
		}
		Matrix ret = new Matrix(rows, other.cols);
		for(int i = 0; i < other.cols; i++) {
			for(int j = 0; j < rows; j++) {
				int sum = 0;
				for(int k = 0; k < cols; k++) {
					sum += this.get(j, k) * other.get(k, i);
				}
				ret.set(j, i, sum);
			}
		}
		return ret;
	}
	
	public Matrix multiply(int scalar) {	
		Matrix ret = new Matrix(rows, cols);
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				ret.set(i, j, data[i][j] * scalar);
			}
		}
		return ret;
	}
	
	public Matrix pow(int exponent) {
		if(this.rows != this.cols) {
			throw new UnsupportedOperationException();
		}
		if(exponent == 0) {
			return Matrix.identity(this.rows);
		} else {
			Matrix m = this.multiply(this).pow(exponent / 2);
			if(exponent % 2 == 0) {
				return m;
			} else {
				return this.multiply(m);
			}
		}
		
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		for(int[] datum: data) {
			s.append(Arrays.toString(datum) + "\n");
		}
		return s.toString();
	}
	
	public static Matrix identity(int n) {
		Matrix ret = new Matrix(n, n);
		for(int i = 0; i < n; i++) {
			ret.set(i, i, 1);
		}
		return ret;
	}
	
	public static void main(String[] args) {
		Matrix first = new Matrix(2, 2);
		first.set(0, 0, 2);
		first.set(0, 1, 3);
		first.set(1, 0, 15);
		first.set(1, 1, 4);
		Matrix second = new Matrix(2, 1);
		second.set(0, 0, 1);
		System.out.println(first);
		System.out.println(first.pow(7));
		System.out.println(second);
		System.out.println(first.multiply(second).multiply(5));
		System.out.println(Matrix.identity(3).multiply(Matrix.identity(3)));
		System.out.println(Matrix.identity(3).pow(3));
	}
}
