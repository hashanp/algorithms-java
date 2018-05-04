package Matrix;

import java.util.Arrays;

public class Matrix {
  private final int rows;
  private final int cols;
  private final double[][] data;

  public Matrix(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    data = new double[rows][cols];
  }

  public double get(int m, int n) {
    return data[m][n];
  }

  public int getRows() {
    return this.rows;
  }

  public int getCols() {
    return this.cols;
  }

  public void set(int m, int n, double t) {
    data[m][n] = t;
  }

  public Matrix multiply(Matrix other) {
    if (this.getCols() != other.getRows()) {
      throw new IllegalArgumentException();
    }
    final Matrix ret = new Matrix(getRows(), other.getCols());
    for (int i = 0; i < other.getCols(); i++) {
      for (int j = 0; j < getRows(); j++) {
        int sum = 0;
        for (int k = 0; k < getCols(); k++) {
          sum += this.get(j, k) * other.get(k, i);
        }
        ret.set(j, i, sum);
      }
    }
    return ret;
  }

  public Matrix multiply(int scalar) {
    final Matrix ret = new Matrix(rows, cols);
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        ret.set(i, j, data[i][j] * scalar);
      }
    }
    return ret;
  }

  public Matrix pow(int exponent) {
    if (this.rows != this.cols) {
      throw new UnsupportedOperationException();
    }
    if (exponent == 0) {
      return Matrix.identity(this.rows);
    } else {
      final Matrix m = this.multiply(this).pow(exponent / 2);
      if (exponent % 2 == 0) {
        return m;
      } else {
        return this.multiply(m);
      }
    }

  }

  public String toString() {
    final StringBuilder s = new StringBuilder();
    for (double[] datum: data) {
      s.append(Arrays.toString(datum) + "\n");
    }
    return s.toString();
  }

  public static Matrix identity(int n) {
    final Matrix ret = new Matrix(n, n);
    for (int i = 0; i < n; i++) {
      ret.set(i, i, 1);
    }
    return ret;
  }

  public static void main(String[] args) {
    final Matrix first = new Matrix(2, 2);
    first.set(0, 0, 2);
    first.set(0, 1, 3);
    first.set(1, 0, 15);
    first.set(1, 1, 4);
    final Matrix second = new Matrix(2, 1);
    second.set(0, 0, 1);
    System.out.println(first);
    System.out.println(first.pow(7));
    System.out.println(second);
    System.out.println(first.multiply(second).multiply(5));
    System.out.println(Matrix.identity(3).multiply(Matrix.identity(3)));
    System.out.println(Matrix.identity(3).pow(3));
  }
}
