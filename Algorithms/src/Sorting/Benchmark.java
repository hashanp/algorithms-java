package Sorting;

import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Benchmark {
	private static Random rand = new Random();
	
	public static long timeHeapSort(int[] arr) {
		long start = System.nanoTime();
        HeapSort.heapSort(arr);
        return System.nanoTime() - start;
	}
	
	public static long timeInsertionSort(int[] arr) {
		long start = System.nanoTime();
        InsertionSort.insertionSort(arr);
        return System.nanoTime() - start;
	}
	
	public static long timeMergeSort(int[] arr) {
		long start = System.nanoTime();
        MergeSort.mergeSort(arr);
        return System.nanoTime() - start;
	}
	
	public static long timeQuickSort(int[] arr) {
		long start = System.nanoTime();
        QuickSort.betterQuickSort(arr);
        return System.nanoTime() - start;
	}
	
	public static long timeSelectionSort(int[] arr) {
		long start = System.nanoTime();
        SelectionSort.selectionSort(arr);
        return System.nanoTime() - start;
	}
	
	public static long timeBubbleSort(int[] arr) {
		long start = System.nanoTime();
        BubbleSort.bubbleSort(arr);
        return System.nanoTime() - start;
	}
	
	public static long timeOptimisedBubbleSort(int[] arr) {
		long start = System.nanoTime();
        BubbleSort.optimisedBubbleSort(arr);
        return System.nanoTime() - start;
	}
	
	public static int[] copy(int[] arr) {
		int[] copy = new int[arr.length];
		System.arraycopy(arr, 0, copy, 0, arr.length);
		return copy;
	}
	
	@FunctionalInterface
	public static interface ITestDataGenerator {
		int[] generate(int n);
	}
	
	public static ITestDataGenerator averageCase = (n) -> {
		int[] ret = new int[n];
		for(int i = 0; i < n; i++) {
			ret[i] = rand.nextInt();
		}
		return ret;
	};
	
	public static ITestDataGenerator sorted = (n) -> {
		int[] ret = new int[n];
		for(int i = 0; i < n; i++) {
			ret[i] = i;
		}
		return ret;
	};
	
	public static ITestDataGenerator reverseSorted = (n) -> {
		int[] ret = new int[n];
		for(int i = 0; i < n; i++) {
			ret[i] = -i;
		}
		return ret;
	};
	
	public static void benchmark(ITestDataGenerator testDataGenerator, String output, int start, int end, int increment) throws IOException {
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output)));
		writer.write("Length,Optimised Bubble Sort,Bubble Sort,Heap Sort,Insertion Sort,Merge Sort,Quick Sort,Selection Sort\n");
		for(int i = start; i <= end; i += increment) {
			System.out.println(i);
			int[] arr = testDataGenerator.generate(i);
	        
	        long heapSort = timeHeapSort(copy(arr));
	        long insertionSort = timeInsertionSort(copy(arr));
	        long mergeSort =  timeMergeSort(copy(arr));
	        long quickSort = timeQuickSort(copy(arr));
	        long selectionSort = timeSelectionSort(copy(arr));
	        long bubbleSort =  timeBubbleSort(copy(arr));
	        long optimisedBubbleSort = timeOptimisedBubbleSort(copy(arr));
	      
	        writer.write(i + "," + optimisedBubbleSort + "," + bubbleSort + "," + heapSort + "," + insertionSort + "," + mergeSort + "," + quickSort + "," + selectionSort + "\n");
		}
		writer.close();

	}
	
	public static void main(String[] args) throws IOException {
		benchmark(averageCase, "./sorting8.csv", 0, 100000, 10000);
	}
}
