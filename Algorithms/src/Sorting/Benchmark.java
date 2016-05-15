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
	
	/*public static int[] random(int len) {
		int[] res = new int[len];
		for(int i = 0; i < len; i++) {
			res[i] = rand.nextInt(Integer.MAX_VALUE);
		}
		return res;
	}*/
	
	public static void main(String[] args) throws IOException {
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./sorting.csv")));
		writer.write("Length,Heap Sort,Insertion Sort,Merge Sort,Selection Sort\n");
		int[] arr = new int[0];
		for(int i = 100; i < 20000; i+=100) {
			System.out.println(i);
			int[] arr2 = new int[i];
			System.arraycopy(arr, 0, arr2, 0, i-100);
			for(int j = i-100; j < i; j++) {
				arr2[j] = rand.nextInt();
			}
			System.out.println(i);
	        long start = System.nanoTime();
	        HeapSort.heapSort(arr);
	        long heapSort =  System.nanoTime() - start;
	        start = System.nanoTime();
	        InsertionSort.insertionSort(arr);
	        long insertionSort =  System.nanoTime() - start;
	        start = System.nanoTime();
	        MergeSort.mergeSort(arr);
	        long mergeSort =  System.nanoTime() - start;
	        start = System.nanoTime();
	        SelectionSort.selectionSort(arr);
	        long selectionSort =  System.nanoTime() - start;
	        writer.write(i + "," + heapSort + "," + insertionSort + "," + mergeSort + "," + selectionSort + "\n");
	        arr = arr2;
		}
		writer.close();
	}
}
