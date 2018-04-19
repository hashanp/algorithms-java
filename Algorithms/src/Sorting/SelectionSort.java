package Sorting;

public class SelectionSort {
  public static void selectionSort(int[] input) {
    for (int i = 0; i < input.length; i++) {
      int min = i;
      for (int j = i + 1; j < input.length; j++) {
        if (input[j] < input[min]) {
          min = j;
        }
      }
      int c = input[min];
      input[min] = input[i];
      input[i] = c;
    }
  }

  public static void main(String[] args) {
    int[] b = {3, 9, 8, 3, 5, 2, 1};
    selectionSort(b);
    System.out.println(b);
  }
}
