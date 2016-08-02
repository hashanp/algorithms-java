package Searching;

public class BinarySearch {
	public static void main(String[] args) {
		int b[] = {3, 4, 5, 6, 7, 8, 9};
		System.out.println(binarySearch(b, 8));
	}
	
	public static int binarySearch(int[] arr, int term) {
		int min = 0;
		int max = arr.length-1;
		while(min <= max) {
			int pos = (min + max) /2;
			if(arr[pos] < term) {
				min = pos+1;
			} else if(arr[pos] > term) {
				max = pos-1;
			} else {
				return pos;
			}
		}
		return -1;
	}
}
