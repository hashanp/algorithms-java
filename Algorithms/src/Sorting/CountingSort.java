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
	
	/*
	 * This is a special implementation of counting sort,
	 * which sort on a particular digit d, in this case k = 10.
	 */
	public static int[] countingSortOnDigit(int[] data, int d) {
		int modulus1 = (int) Math.pow(10, d);
		int modulus2 = (int) Math.pow(10, d-1);
		int[] ret = new int[data.length];
		int[] temp = new int[10];
		for(int j = 0; j < data.length; j++) {
			int digit = ((data[j] % modulus1) - (data[j] % modulus2)) / modulus2;
			temp[digit]++;
		}
		for(int i = 0; i < temp.length - 1; i++) {
			temp[i + 1] += temp[i];
		}
		for(int i = data.length - 1; i >= 0; i--) {
			int digit = ((data[i] % modulus1) - (data[i] % modulus2)) / modulus2;
			ret[temp[digit] - 1] = data[i];
			temp[digit]--;
		}
		return ret;
	}
	
	public static void main(String[] args) {
		int[] a = {2, 8, 7, 1, 3, 5, 6, 4};
		System.out.println(Arrays.toString(countingSort(a, 8)));
		int[] testData = {26, 14, 15, 16, 3, 13};
		System.out.println(Arrays.toString(countingSortOnDigit(testData, 1)));
	}
}