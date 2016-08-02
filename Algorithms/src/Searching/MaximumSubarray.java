package Searching;

import java.util.Arrays;

public class MaximumSubarray {
	public static void main(String[] args) {
		int[] arr = {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
		System.out.println(maxSubarray(arr,0,15));
		System.out.println(bruteForce(arr));
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
	
	/*
	 * O(nlg(n)) 
	 */
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
	
	/*
	 * O(n^2)
	 */
	public static int bruteForce(int[] arr) {
		int maxSum = 0;
		for(int i = 0; i < arr.length; i++) {
			int sum = 0;
			int maxInIteration = 0;
			for(int j = i; j < arr.length; j++) {
				sum += arr[j];
				if(sum > maxInIteration) {
					maxInIteration = sum;
				}
			}
			if(i == 0 || maxInIteration > maxSum) {
				maxSum = maxInIteration;
			}
		}
		return maxSum;
	}
}
