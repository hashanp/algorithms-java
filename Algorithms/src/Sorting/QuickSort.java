package Sorting;

import java.util.Arrays;

public class QuickSort {
  public static int partition(int[] arr, int p, int r) {
    int pivot = arr[r];
    // lastSmall refers to the last index that points to a value less
    // than the pivot where lastSmall <= i
    int lastSmall = p - 1;
    for (int i = p; i <= r; i++) {
      if (arr[i] <= pivot) {
        lastSmall++;
        // Swap arr[lastSmall] and arr[i]
        int copy = arr[lastSmall];
        arr[lastSmall] = arr[i];
        arr[i] = copy;
      }
    }
    // Swap arr[lastSmall+1] and arr[r]
    /*int copy = arr[lastSmall+1];
    arr[lastSmall+1] = arr[r];
    arr[r] = copy;*/
    // Return the place of pivot
    return lastSmall;
  }

  public static int hoarePartition(int[] arr, int p , int r) {
    /*
     * Set pivot to the first element of `arr`.
     */
    int x = arr[p];
    int i = p - 1;
    int j = r + 1;
    while (true) {
      do {
        j = j - 1;
      } while(arr[j] > x);
      do {
        i = i + 1;
      } while(arr[i] < x);
      /*
       * Assuming at the start of the while-loop,
       * arr[p..i] were all less than or equal to
       * the pivot and arr[j..r] were all greater
       * than or equal to the pivot, it is now the
       * case that those conditions hold  for arr[p..i-1]
       * and arr[j+1..q].
       *
       * But, arr[i] is greater than the pivot and
       * arr[j] is smaller than the pivot.
       */
      if (i < j) {
        /*
         * Here arr[i] and arr[j] are swapped to
         * preserve the original invariants.
         */
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      } else {
        return j;
      }
    }
  }

  /*
   * This version of quickSort is only good in the average case,
   * whenever the input size is either close to being sorted, or
   * close to being sorted in reverse order, and the input size
   * is large, a stack overflow error will occur. This is because
   * the pivot will be consistently either the biggest or smallest
   * item. This means there is Θ(n) worst case space complexity, due to
   * Θ(n) stack frames. For large input sizes, this leads to stack
   * overflow errors.
   *
   * In the average case there will be only Θ(lg n) stack frames,
   * hence no need to worry.
   */
  public static void quickSort(int[] arr, int p, int r) {
    if (p < r) {
      int pivot = partition(arr, p, r);
      quickSort(arr, p, pivot-1);
      quickSort(arr, pivot+1, r);
    }
  }

  public static void quickSort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
  }

  /*
   * This is a better implementation of quickSort, which I use
   * in my benchmarking class. I have to use iteration, since
   * Java does not (alas!) perform tail-call optimisation. This
   * algorithm, finds which subarray, that has resulted from the
   * partition, is smaller. It recursively computes quickSort
   * on this subarray. It then performs quickSort on the larger
   * subarray, but it uses iteration so no new stack frames are
   * created.
   *
   * In a programming language that supports tail-call optimisation,
   * it would be possible to avoid the use of iteration, as the final
   * recursive invocation of betterQuickSort by itself, would be
   * automatically converted to use iteration.
   */
  public static void betterQuickSort(int[] arr, int p, int r) {
    while (p < r) {
      int pivot = partition(arr, p, r);
      if (pivot - p < r - pivot) {
        quickSort(arr, p, pivot - 1);
        p = pivot + 1;
      } else {
        quickSort(arr, pivot + 1, r);
        r = pivot - 1;
      }
    }
  }

  public static void betterQuickSort(int[] arr) {
    betterQuickSort(arr, 0, arr.length - 1);
  }


  /*
   * Here is a version of `betterQuickSort` that uses Hoare partitioning,
   * as implemented in the `hoarePartition` method.
   */

  public static void hoareQuickSort(int[] arr, int p, int r) {
    while (p < r) {
      /*
       * The hoarePartition method partitions the array
       * such that every element in arr[q+1..r] is smaller
       * than or equal to every element in arr[p..q].
       */
      int q = hoarePartition(arr, p, r);
      if (q - p < r - q) {
        quickSort(arr, p, q);
        p = q + 1;
      } else {
        quickSort(arr, q + 1, r);
        r = q;
      }
    }
  }

  public static void hoareQuickSort(int[] arr) {
    hoareQuickSort(arr, 0, arr.length - 1);
  }

  public static void randomisedQuickSort(int[] arr) {
    quickSort(Randomise.randomise(arr));
  }

  public static void main(String[] args) {
    int[] a = {2, 8, 7, 35, 34, 1, 3, 5, 6, 4};
    quickSort(a);
    System.out.println(Arrays.toString(a));
  }
}
