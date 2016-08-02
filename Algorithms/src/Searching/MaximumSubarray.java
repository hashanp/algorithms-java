package Searching;

import java.util.Arrays;

public class MaximumSubarray {
	public static void main(String[] args) {
		int[] arr = {1,-4,3,-4};
		System.out.println(maxSubarray(arr,0,3));
	}
	
	public static int maxCrossingSubarry(int[] arr, int low, int mid, int high) {
		int sum = 0;
		int leftSum = 0;
		for(int i = mid; i >= low; i--) {
			sum = sum + arr[i];
			if(i == mid || sum > leftSum) {
				leftSum = sum;
			}
		}
		int rightSum = 0;
		sum = 0;
		for(int i = mid+1; i <= high; i++) {
			sum = sum + arr[i];
			if(i == mid+1 || sum > rightSum) {
				rightSum = sum;
			}
		}
		return leftSum + rightSum;
	}
	
	public static int maxSubarray(int[] arr, int low, int high) {
		if(high == low) {
			return arr[low];
		} else {
			int mid = (low + high) / 2;
			int maxLeft = maxSubarray(arr, low, mid);
			int maxRight = maxSubarray(arr, mid+1, high);
			int maxCross = maxCrossingSubarry(arr, low, mid, high);
			if(maxLeft >= maxRight && maxLeft >= maxCross) {
				return maxLeft;
			} else if(maxRight >= maxLeft && maxRight >= maxCross) {
				return maxRight;
			} else {
				return maxCross;
			}
		}
	}
}
