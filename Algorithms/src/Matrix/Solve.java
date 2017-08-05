package Matrix;

public class Solve {
	/*
	 * Assumes the matrix of coefficients is square
	 */
	public static Matrix backSubstitution(Matrix coefficients, Matrix solutions) {
		Matrix ret = new Matrix(solutions.getRows(), solutions.getCols());
		for(int i = 0; i < solutions.getCols(); i++) {
			for(int j = solutions.getRows() - 1; j >= 0; j--) {
				double sum = solutions.get(j, i);
				for(int k = j + 1; k < solutions.getRows(); k++) {
					sum -= (coefficients.get(j, k) * ret.get(k, i));
				}
				ret.set(j, i, sum  / coefficients.get(j, j));
			}
		}
		return ret;
	}
	
	public static Matrix forwardSubstitution(Matrix coefficients, Matrix solutions) {
		Matrix ret = new Matrix(solutions.getRows(), solutions.getCols());
		for(int i = 0; i < solutions.getCols(); i++) {
			for(int j = 0; j < solutions.getRows(); j++) {
				double sum = solutions.get(solutions.getRows() - 1 - j, i);
				for(int k = 0; k < j; k++) {
					sum -= (coefficients.get(solutions.getRows() - 1 - j, k) * ret.get(solutions.getRows() - 1 - k, i));
					System.out.println("h " + sum);
				}
				System.out.println(coefficients.get(solutions.getRows() - 1 - j, j));
				System.out.println(sum);
				ret.set(solutions.getRows() - 1 - j, i, sum  / coefficients.get(solutions.getRows() - 1 - j, j));
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		Matrix a = new Matrix(3, 3);
		Matrix b = new Matrix(3, 1);
		a.set(0, 0, 1);
		a.set(0, 1, 2);
		a.set(0, 2, 3);
		b.set(0, 0, 2);
		// x + 2y + 3z = 6
		a.set(1, 0, 3);
		a.set(1, 1, 4);
		b.set(1, 0, 7);
		//     3y + 4z = 7
		a.set(2, 0, 5);
		b.set(2, 0, 5);
		//          5z = 5
		
		System.out.println(forwardSubstitution(a, b));
	}
}
