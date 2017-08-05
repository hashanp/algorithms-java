import Matrix.Matrix;

public class Fibonacci {
	/*
	 * This function uses linear algebra to calculate
	 * the nth fibonacci number.
	 * 
	 * It runs in Θ(lg n) time.
	 * 
	 * Note it only works for fibonacci numbers, where 
	 * n > 0.
	 */
	public static int fibonacci(int n) {
		/*
		 * The `initial` vector is a 2-dimensional vector
		 * that stores the 0th and 1st fibonacci numbers.
		 */
		Matrix initial = new Matrix(2, 1);
		initial.set(0, 0, 0);
		initial.set(1, 0, 1);
		
		/* 
		 * The transformation matrix takes a 2-dimensional
		 * vector where the first item is the nth fibonacci
		 * number, and the second number is the (n+1)th fibonacci
		 * number, and maps to a vector where the first item
		 * is the (n+1)th fibonacci number, adn the second
		 * item is a (n+2)th fibonacci numebr.
		 */
		Matrix transformation = new Matrix(2, 2);
		/*
		 *  The first row vector of the `transformation`
		 *  matrix, is responsible for getting the (n+1)th 
		 *  fibonacci number.
		 */
		transformation.set(0, 0, 0);
		transformation.set(0, 1, 1);
		
		/*
		 * The second row vector of the `transformation`
		 * matrix is responsible for getting the (n+2)th 
		 * fibonacci number.
		 */
		
		transformation.set(1, 0, 1);
		transformation.set(1, 1, 1);
		
		Matrix output = transformation.pow(n - 1).multiply(initial);
		return (int) output.get(1, 0);
	}
	
	public static void main(String[] args) {
		System.out.println(fibonacci(37));
	}
}
