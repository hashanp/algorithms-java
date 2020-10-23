package Sorting;

import java.util.Random;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.Consumer;

public class Benchmark {
  private static Random rand = new Random();

  public static long time(Consumer<int[]> sortingFunction, int[] arr) {
    arr = copy(arr);
    final long start = System.nanoTime();
    sortingFunction.accept(arr);
    return System.nanoTime() - start;
  }

  public static int[] copy(int[] arr) {
    int[] copy = new int[arr.length];
    System.arraycopy(arr, 0, copy, 0, arr.length);
    return copy;
  }

  @FunctionalInterface
  public interface ITestDataGenerator {
    int[] generate(int n);
  }

  /*
   * `averageCase` is a test data generator that generates an integer
   * array with random elements. In the average case, this means that
   * there are (n choose 2)/2 inversions.
   */
  public static ITestDataGenerator averageCase = (n) -> {
    int[] ret = new int[n];
    for(int i = 0; i < n; i++) {
      ret[i] = rand.nextInt();
    }
    return ret;
  };


  /*
   * `sorted` is a test data generator that generates an integer array
   * of length n, that is sorted i.e. with 0 inversions.
   */
  public static ITestDataGenerator sorted = n -> {
    int[] ret = new int[n];
    for(int i = 0; i < n; i++) {
      ret[i] = i;
    }
    return ret;
  };

  /*
   * `reverseSorted` is a test data generator that generates an integer
   * array of length n, in the reverse of what would be sorted i.e. with
   * (n choose 2) inversions.
   */
  public static ITestDataGenerator reverseSorted = (n) -> {
    int[] ret = new int[n];
    for(int i = 0; i < n; i++) {
      ret[i] = -i;
    }
    return ret;
  };

  /*
   * `benchmark` benchmarks all of my main sorting algorithms. It additionally benchmarks,
   * Java's native sorting algorithm, Arrays.sort().
   */
  public static void benchmark(ITestDataGenerator testDataGenerator,
    String output, int start, int end, int increment) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)))) {
      writer.write("Length,Optimised Bubble Sort,Bubble Sort,Heap Sort,Insertion Sort,"
              + "Merge Sort,Quick Sort,Selection Sort,Java's Native Sort\n");
      for (int i = start; i <= end; i += increment) {
        System.out.println(i);
        int[] arr = testDataGenerator.generate(i);

        long heapSort = time(HeapSort::heapSort, arr);
        long insertionSort = time(InsertionSort::insertionSort, arr);
        long mergeSort = time(MergeSort::mergeSort, arr);
        long quickSort = time(QuickSort::betterQuickSort, arr);
        long selectionSort = time(SelectionSort::selectionSort, arr);
        long bubbleSort = time(BubbleSort::bubbleSort, arr);
        long optimisedBubbleSort = time(BubbleSort::optimisedBubbleSort, arr);
        long nativeSort = time(Arrays::sort, arr);

        writer.write(i + "," + optimisedBubbleSort + "," + bubbleSort + ","
                + heapSort + "," + insertionSort + "," + mergeSort + "," + quickSort + "," + selectionSort +
                "," + nativeSort + "\n");
      }
    }
  }

  /*
   * `benchmark2` benchmarks all of my main sorting algorithms that perform in,
   * Θ(n lg n) time in the average case. It additionally benchmarks, Java's native
   * sorting algorithm, Arrays.sort().
   */
  public static void benchmark2(ITestDataGenerator testDataGenerator,
      String output, int start, int end, int increment) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)))) {
      writer.write("Length,Heap Sort,Merge Sort,Quick Sort,Java's Native Sort\n");
      for (int i = start; i <= end; i += increment) {
        System.out.println(i);
        int[] arr = testDataGenerator.generate(i);

        long heapSort = time(HeapSort::heapSort, arr);
        long mergeSort = time(MergeSort::mergeSort, arr);
        long quickSort = time(QuickSort::betterQuickSort, arr);
        long nativeSort = time(Arrays::sort, arr);

        writer.write(i + "," + heapSort + "," + mergeSort + "," + quickSort + "," + nativeSort + "\n");
      }
    }
  }

  /*
   * `benchmark2` benchmarks all of my main sorting algorithms that perform in,
   * Θ(n lg n) time in the worst case. It additionally benchmarks, Java's native
   * sorting algorithm, Arrays.sort().
   */
  public static void benchmark3(ITestDataGenerator testDataGenerator,
    String output, int start, int end, int increment) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)))) {
      writer.write("Length,Heap Sort,Merge Sort,Java's Native Sort\n");
      for (int i = start; i <= end; i += increment) {
        System.out.println(i);
        int[] arr = testDataGenerator.generate(i);

        long heapSort = time(HeapSort::heapSort, arr);
        long mergeSort = time(MergeSort::mergeSort, arr);
        long nativeSort = time(Arrays::sort, arr);

        writer.write(i + "," + heapSort + "," + mergeSort + "," + nativeSort + "\n");
      }
    }
  }

  public static void main(String[] args) throws IOException {
    System.out.println("Attempting Benchmark 1 (Output File: benchmark_output_1.csv):");
    benchmark(averageCase, "./benchmark_output_1.csv", 0, 100000, 10000);

    System.out.println("Attempting Benchmark 2 (Output File: benchmark_output_2.csv):");
    benchmark(sorted, "./benchmark_output_2.csv", 0, 100000, 10000);

    System.out.println("Attempting Benchmark 3 (Output File: benchmark_output_3.csv):");
    benchmark(reverseSorted, "./benchmark_output_3.csv", 0, 100000, 10000);

    System.out.println("Attempting Benchmark 4 (Output File: benchmark_output_4.csv):");
    benchmark2(averageCase, "./benchmark_output_4.csv", 0, 10000000, 1000000);

    System.out.println("Attempting Benchmark 5 (Output File: benchmark_output_5.csv):");
    benchmark3(sorted, "./benchmark_output_5.csv", 0, 10000000, 1000000);

    System.out.println("Attempting Benchmark 6 (Output File: benchmark_output_6.csv):");
    benchmark3(reverseSorted, "./benchmark_output_6.csv", 0, 10000000, 1000000);

  }
}
