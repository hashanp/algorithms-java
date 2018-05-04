package Sorting;

import java.util.Arrays;

public class BubbleSort {
  /*
   * Best case time complexity: Θ(n^2)
   * Average case time complexity: Θ(n^2)
   * Worst case time complexity: Θ(n^2)
   */

  public static void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      /*
       * Each iteration of this outer loop,
       * guarantees that at the end the (i + 1)-th
       * largest element is in the (arr.length - (i + 1))th
       * index of the array.
       *
       * In other words, the loop invariant is that
       * the subsection bounded by the indices
       * [arr.length - i, arr.length] is sorted and
       * contains the i biggest elements in arr.
       */

      for (int j = 0; j < arr.length - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          /*
           * In the case, where arr[j] > arr[j + 1],
           * i.e. there is an inversion at indices j
           * and (j + 1), arr[j] and arr[j + 1] are
           * swapped.
           */
          int temp = arr[j + 1];
          arr[j + 1] = arr[j];
          arr[j] = temp;
        }
      }
    }
  }

  /*
   * Unlike the above algorithm, whose best case it the same as
   * its average case. This version of bubble sort, checks in
   * each iteration, whether the list is sorted yet. This ensures
   * the algorithm halts, once the list is sorted. The best case
   * time complexity of this algorithm is Θ(n).
   */
  public static void optimisedBubbleSort(int[] arr) {
    boolean sorted = false;
    int n = arr.length;
    while (!sorted) {
      sorted = true;
      for (int i = 0; i < n - 1; i++) {
        if (arr[i] > arr[i + 1]) {
          int temp = arr[i + 1];
          arr[i + 1] = arr[i];
          arr[i] = temp;
          sorted = false;
        }
      }
      n--;
    }
  }

  public static void main(String[] args) {
    int[] testData = {9, 8, 7, 6, 5, 4, 3, 2};
    bubbleSort(testData);
    System.out.println(Arrays.toString(testData));
  }
}
