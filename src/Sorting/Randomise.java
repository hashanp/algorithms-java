package Sorting;

import java.util.Random;
import java.util.Arrays;

public class Randomise {
	private static Random rand = new Random();
	
	public static void randomise(int[] a) {
		for(int i = 0; i < a.length; i++) {
			int indexToBeSwapped = rand.nextInt(a.length - i) + i;
			int c = a[i];
			a[i] = a[indexToBeSwapped];
			a[indexToBeSwapped] = c;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};
		randomise(a);
		System.out.println(Arrays.toString(a));
	}
}
