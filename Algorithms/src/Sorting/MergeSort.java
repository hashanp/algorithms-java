package Sorting;

import java.util.Arrays;

public class MergeSort {
	public static int[] combine(int[] a, int[] b) {
		int[] output = new int[a.length + b.length];
		int i = 0;
		int posA = 0;
		int posB = 0;
		while(posA != a.length  && posB != b.length) {
			if(a[posA] < b[posB]) {
				output[i] = a[posA];
				posA++;
			} else {
				output[i] = b[posB];
				posB++;
			}
			i++;
		}
		while(posA != a.length) {
			output[i] = a[posA];
			posA++;
			i++;
		}
		while(posB != b.length) {
			output[i] = b[posB];
			posB++;
			i++;
		}
		return output;
	}
	
	public static int[] mergeSort(int[] a) {
		if(a.length == 0 || a.length == 1) {
			return a;
		} else if(a.length == 2) {
			if(a[0] > a[1]) {
				int[] output = {a[1], a[0]};
				return output;
			} else {
				return a;
			}
		} else {
			int[] part1 = new int[a.length/2];
			int[] part2 = new int[a.length - part1.length];
			System.arraycopy(a, 0, part1, 0, part1.length);
			System.arraycopy(a, part1.length, part2, 0, part2.length);
			return combine(mergeSort(part1), mergeSort(part2));
		}
	}
	
	public static void main(String[] args) {
		int[] b = {3, 9, 8, 3, 5, 2, 1};
		System.out.println(Arrays.toString(mergeSort(b)));
	}
}
