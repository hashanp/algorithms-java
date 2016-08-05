package Sorting;

import java.util.Arrays;

public class QuickSort {
	public static int partition(int[] arr, int p, int r) {
		int pivot = arr[r];
		// lastSmall refers to the last index that points to a value less 
		// than the pivot where lastSmall <= i
		int lastSmall = p - 1;
		for(int i = 0; i < r; i++) {
			if(arr[i] <= pivot) {
				lastSmall++;
				// Swap arr[lastSmall] and arr[i]
				int copy = arr[lastSmall];
				arr[lastSmall] = arr[i];
				arr[i] = copy;
			}
		}
		// Swap arr[lastSmall+1] and arr[r]
		int copy = arr[lastSmall+1];
		arr[lastSmall+1] = arr[r];
		arr[r] = copy;
		// Return the place of pivot
		return lastSmall+1;
	}
	
	public static void quickSort(int[] arr, int p, int r) {
		if(p < r) {
			int pivot = partition(arr, 0, r);
			quickSort(arr, 0, pivot-1);
			quickSort(arr, pivot+1, r);
		}
	}
	
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
	}
	
	public static void main(String[] args) {
		int[] a = {2, 8, 7, 1, 3, 5, 6, 4};
		quickSort(a);
		System.out.println(Arrays.toString(a));
	}
}
