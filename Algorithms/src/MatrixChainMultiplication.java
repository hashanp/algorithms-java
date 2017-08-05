import java.util.Arrays;

import Matrix.Matrix;

public class MatrixChainMultiplication {
	public static void main(String[] args) {
		Matrix[] m = new Matrix[6];
		m[0] = new Matrix(30, 35);
		m[1] = new Matrix(35, 15);
		m[2] = new Matrix(15, 5);
		m[3] = new Matrix(5, 10);
		m[4] = new Matrix(10, 20);
		m[5] = new Matrix(20, 25);
		MatrixChainOrderResult v = matrixChainOrder(m);
		System.out.println(v.cost);
		System.out.println(Arrays.toString(v.order));
	}
	
	public static class MatrixChainOrderResult {
		public int cost;
		/*
		 * order stores the indices of matrices
		 * in reverse polish notation, in the order
		 * they should be multiplied. -1 indicates
		 * the multiplication operation should be carried
		 * out.
		 */
		public int[] order;
		
		public MatrixChainOrderResult(int cost, int[] order) {
			this.cost = cost;
			this.order = order;
		}
	}
	
	public static MatrixChainOrderResult matrixChainOrder(Matrix[] matrices) {
		int n = matrices.length;
		/*
		 * cost[a][b] refers to the cost of the quickest
		 * way of multiplying matrices[a..b].
		 */
		int[][] cost = new int[n][n];
		int[][] s = new int[n][n];
		for(int i = 0; i < n; i++) {
			cost[i][i] = 0;
		}
		for(int l = 2; l <= n; l++) {
			for(int i = 0; i < n - l + 1; i++) {
				int j = i + l - 1;
				int min = -1;
				for(int k = i; k < j; k++) {
					int q = cost[i][k] + cost[k + 1][j] + (matrices[i].getRows() * matrices[j].getCols() * matrices[k].getCols());
					if(min == -1 || q < min) {
						min = q;
						cost[i][j] = q;
						s[i][j] = k;
					}
				}
			}
		}
		/*for(int[] d: cost) {
			System.out.println(Arrays.toString(d));
		}*/
		int[] ret = new int[2 * s.length - 1];

		return new MatrixChainOrderResult(cost[0][n - 1], computeOrder(ret, s, 0, n - 1, 0));
	}
	
	public static int[] computeOrder(int[] output, int[][] input, int i, int j, int startIndex) {
		if(i == j) {
			output[startIndex] = i;
		} else {
			computeOrder(output, input, i, input[i][j], startIndex);
			int endIndex = startIndex + (2 * (input[i][j] - i + 1) - 1);
			computeOrder(output, input, input[i][j] + 1, j, endIndex);
			//System.out.println(i + " " + j + " " + (startIndex + 2 * (j - i) - 1));
			output[startIndex + 2 * (j - i)] = -1;
		}
		return output;
	}
}
