package Sorting;

import DataStructures.MaxHeap;
import java.util.Arrays;

public class HeapSort {
	public static void maxHeapify(int[] arr, int i, int size) {
		int l = getLeftChild(i);
		int r = getRightChild(i);
		if(l < size && (r >= size || arr[l] > arr[r]) && arr[l] > arr[i]) {
			int temp = arr[i];
			arr[i] = arr[l];
			arr[l] = temp;
			maxHeapify(arr, l, size);
		} else if(r < size && arr[r] > arr[i]) {
			int temp = arr[i];
			arr[i] = arr[r];
			arr[r] = temp;
			maxHeapify(arr, r, size);
		}
	}
	
	public static void buildMaxHeap(int[] arr) {
		for(int i = arr.length / 2; i >= 0; i--) {
			maxHeapify(arr, i, arr.length);
		}
	}
	
	public static void heapSort(int[] arr) {
		buildMaxHeap(arr);
		int heapSize = arr.length;
		for(int i = arr.length - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapSize--;
			maxHeapify(arr, 0, heapSize);
		}
	}
	
	public static int getParent(int n) {
		return n / 2;
	}
	
	public static int getLeftChild(int n) {
		return 2 * n;
	}
	
	public static int getRightChild(int n) {
		return (2 * n) + 1;
	}
	
	public static void main(String[] args) {
		int b[] = {4, 6, 3, 5, 2, 9, 11, 9};
		heapSort(b);
		System.out.println(Arrays.toString(b));
	}
}
