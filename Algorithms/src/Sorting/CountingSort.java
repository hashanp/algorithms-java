package Sorting;

import java.util.Arrays;

public class CountingSort {
	public static int[] countingSort(int[] arr, int k) {
		int[] ret = new int[arr.length];
		int[] temp = new int[k+1];
		for(int i = 0; i < arr.length; i++) {
			temp[arr[i]]++;
		}
		// temp[i] contains the number of values of i in arr
		for(int i = 1; i <= k; i++) {
			temp[i] += temp[i-1];
		}
		// temp[i] contains the number of values <= i in arr
		for(int i = arr.length - 1; i >= 0; i--) {
			ret[temp[arr[i]]-1] = arr[i];
			temp[arr[i]]--;
		}
		return ret;
	}
	
	public static void main(String[] args) {
		int[] a = {2, 8, 7, 1, 3, 5, 6, 4};
		System.out.println(Arrays.toString(countingSort(a, 8)));
	}
}
