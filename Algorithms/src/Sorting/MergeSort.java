package Sorting;

import java.util.Arrays;

public class MergeSort {
	public static int[] mergeSort(int[] a, int p, int r) {
		if(p < r) {
			int q = (p + r) / 2;
			mergeSort(a, p, q);
			mergeSort(a, q + 1, r);
			merge(a, p, q, r);
		}
		return a;
	}
	
	public static int[] merge(int[] a, int p, int q, int r) {
		int posP = p;
		int posQ = q+1;
		int[] nova = new int[r - p + 1];
		for(int i = 0; i < (r - p + 1); i++) {
			if(posQ > r || a[posP] < a[posQ]) {
				nova[i] = a[posP];
				posP++;
			} else {
				nova[i] = a[posQ];
				posQ++;
			}
		}
		for(int i = 0; i < (r - p + 1); i++) {
			a[p + i] = nova[i];
		}
		return a;
	}
			
	public static int[] mergeSort(int[] a) {
		return mergeSort(a, 0, a.length);
	}
	
	public static void main(String[] args) {
		int[] b = {3, 9, 8, 3, 5, 2, 1};
		int[] c = {3, 9, 2, 8, 5, 2, 1};
		int[] d = {};
		System.out.println(Arrays.toString(mergeSort(b, 0, 6)));
	}
}