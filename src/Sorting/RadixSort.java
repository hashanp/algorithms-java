package Sorting;

import java.util.Arrays;

public class RadixSort {
	public static int[] radixSort(int[] arr, int d) {
		for(int i = 1; i <= d; i++) {
			arr = CountingSort.countingSortOnDigit(arr, i);
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] testData = {26, 14, 105, 15, 16, 3, 13};
		System.out.println(Arrays.toString(radixSort(testData, 3)));
	}
}
