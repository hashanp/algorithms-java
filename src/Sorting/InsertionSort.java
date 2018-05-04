package Sorting;

import java.util.Arrays;

public class InsertionSort {
  public static void insertionSort(int[] input) {
    for (int i = 1; i < input.length; i++) {
      int key = input[i];
      int j = i - 1;
      while (j >= 0 && input[j] > key) {
        input[j + 1] = input[j];
        j--;
      }
      input[j + 1] = key;
    }
  }

  public static void main(String[] args) {
    int b[] = {4, 6, 3, 5, 2, 9, 11, 9};
    insertionSort(b);
    System.out.println(Arrays.toString(b));
  }
}
