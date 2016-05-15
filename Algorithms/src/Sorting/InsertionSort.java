package Sorting;

import java.util.Arrays;

public class InsertionSort {
	public static int[] insertionSort(int[] input) {
		int[] output = new int[input.length];
		for(int i = 0; i < input.length; i++) {
			output[i] = input[i];
			int j = i - 1;
			while(j >= 0 && output[j] > output[j+1]) {
				int c = output[j+1];
				output[j+1] = output[j];
				output[j] = c;
				j--;
			}
		}
		return output;
	}
	
	public static void main(String[] args) {
		int b[] = {4, 6, 3, 5, 2, 9, 11, 9};
		System.out.println(Arrays.toString(insertionSort(b)));
	}
}
