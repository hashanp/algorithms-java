package Sorting;

import java.util.Arrays;

public class BubbleSort {
	public static void bubbleSort(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
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
			 * 
			 * An alternative implementation of the algorithm,
			 * that is presented in CLRS, is with the inner loop,
			 * going downwards, meaning that the algorithm,
			 * sorts from the front.
			 */
		
			for(int j = 0; j < arr.length - i - 1; j++) {
				if(arr[j] > arr[j + 1]) {
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
	
	public static void main(String[] args) {
		int[] testData = {3, 9, 8, 3, 5, 2, 1};
		bubbleSort(testData);
		System.out.println(Arrays.toString(testData));
	}
}
