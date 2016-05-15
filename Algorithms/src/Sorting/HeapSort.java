package Sorting;

import DataStructures.MaxHeap;
import java.util.Arrays;

public class HeapSort {
	public static int[] heapSort(int[] arr) {
		MaxHeap a = new MaxHeap();
		for(Integer b: arr) {
			a.add(b);
		}	
		int[] sorted = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			int c = a.remove();
			sorted[i] = c;
		}
		return sorted;
	}
	
	public static void main(String[] args) {
		int b[] = {4, 6, 3, 5, 2, 9, 11, 9};
		System.out.println(Arrays.toString(heapSort(b)));
	}
}
