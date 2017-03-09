package Sorting;

import java.util.Arrays;

public class MergeSort {
	public static void mergeSort(int[] a, int p, int r) {
		/*
		 * Sorts array a, between indices p and r.
		 * The base case occurs when p = r, in which case,
		 * nothing occurs.
		 * 
		 * In the inductive case, the midpoint is calculated,
		 * as the floor of ((p + r) / 2). 
		 * 
		 * Suppose r = p + 1. Then the middle item will be
		 * calculated: ((p + p + 1) / 2) = (2p + 1 / 2)
		 * = p. Thus mergeSort will be invoked on (p, p) 
		 * and (p + 1, p + 1) i.e. (r, r). 
		 * 
		 * Otherwise, mergeSort will be invoked on (p, q)
		 * and (q + 1, r), where p < q < r.
		 * 
		 * Finally merge is called between the indices
		 * p and r.
		 */
		if(p < r) {
			int q = (p + r) / 2;
			mergeSort(a, p, q);
			mergeSort(a, q + 1, r);
			merge(a, p, q, r);
		}
	}
	
	public static int[] merge(int[] a, int p, int q, int r) {
		/*
		 * Merges the subsets a[p, q] and a[q + 1, r], where p < q < r.
		 * 
		 * posP holds the array of the first item in the subsequence
		 * a[p, q], and posQ holds the first item in the subsequence
		 * a[q + 1, r].
		 * 
		 * The amount of items in the combined subsequence a[p, r] is
		 * (r - p + 1). This is as r is the index of the last item in
		 * a[0, r], of which there are (r + 1) items. In the range 
		 * a[0, p], of which there are (p + 1) items. In the range
		 * a[0, p - 1] there are, therefore, p items. So there are 
		 * (r - p + 1) items.
		 */
		int posP = p;
		int posQ = q+1;
		int[] nova = new int[r - p + 1];
		for(int i = 0; i < r - p + 1; i++) {
			if(posQ > r || (posP <= q &&  a[posP] < a[posQ])) {
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
			
	public static void mergeSort(int[] a) {
		mergeSort(a, 0, a.length - 1);
	}
	
	public static void main(String[] args) {
		//int[] b = {9, 8, 7, 6, 5, 4, 3, 2, 1};
		int[] b = {-1075510490, 679660285, -325116253, 1187020704, -887141406, 1134328233, 2055195167, -356991681, 2069724824, -1258458656};
		//int[] b = {3, 9, 300, 8, 4, 3, 5, 2, 1};
	//	int[] c = {3, 9, 2, 8, 5, 2, 1};
		//int[] d = {};
		mergeSort(b);
		System.out.println(Arrays.toString(b));
	}
}