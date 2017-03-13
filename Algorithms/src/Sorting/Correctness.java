package Sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.Arrays;

public class Correctness {
	private static Random rand = new Random();

	public static void generateTestData(int n) throws IOException {
		int[] test = new int[n];
		int[] other = new int[n];
		for(int i = 0; i < n; i++) {
			test[i] = rand.nextInt();
			other[i] = test[i];
		}
		BubbleSort.bubbleSort(other);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./test.txt")));
		BufferedWriter writer2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./correct.txt")));
		for(int i = 0; i < n; i++) {
			System.out.println(test[i] + " " + other[i]);
			writer.append(Integer.toString(test[i]) + "\n");
			writer2.append(Integer.toString(other[i]) + "\n");
		}
		writer.close();
		writer2.close();
	}
	
	public static boolean testMergeSort(int n) throws IOException {
		int[] test = new int[n];
		int[] other = new int[n];
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("./test.txt")));
		BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream("./correct.txt")));
		for(int i = 0; i < n; i++) {
			String s1 = reader.readLine();
			String s2 = reader2.readLine();
			test[i] = Integer.parseInt(s1);
			other[i] = Integer.parseInt(s2);
		}
		MergeSort.mergeSort(test);
		for(int i = 0; i < n; i++) {
			if(test[i] != other[i]) {	
				return false;
			}
		}
		reader.close();
		reader2.close();
		return true;
	}
	
	
	public static boolean testQuickSort(int n) throws IOException {
		int[] test = new int[n];
		int[] other = new int[n];
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("./test.txt")));
		BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream("./correct.txt")));
		for(int i = 0; i < n; i++) {
			test[i] = Integer.parseInt(reader.readLine());
			other[i] = Integer.parseInt(reader2.readLine());
		}
		QuickSort.betterQuickSort(test);
		for(int i = 0; i < n; i++) {
			if(test[i] != other[i]) {	
				return false;
			}
		}
		return true;
	}
	
	public static boolean testBubbleSort(int n) throws IOException {
		int[] test = new int[n];
		int[] other = new int[n];
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("./test.txt")));
		BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream("./correct.txt")));
		for(int i = 0; i < n; i++) {
			String s1 = reader.readLine();
			String s2 = reader2.readLine();
			//System.out.println(Integer.parseInt(s1) + " " + Integer.parseInt(s2));
			test[i] = Integer.parseInt(s1);
			other[i] = Integer.parseInt(s2);
		}
		BubbleSort.optimisedBubbleSort(test);
		for(int i = 0; i < n; i++) {
			if(test[i] != other[i]) {	
				return false;
			}
		}
		reader.close();
		reader2.close();
		return true;
	}
	
	public static boolean testSelectionSort(int n) throws IOException {
		int[] test = new int[n];
		int[] other = new int[n];
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("./test.txt")));
		BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream("./correct.txt")));
		for(int i = 0; i < n; i++) {
			String s1 = reader.readLine();
			String s2 = reader2.readLine();
			//System.out.println(Integer.parseInt(s1) + " " + Integer.parseInt(s2));
			test[i] = Integer.parseInt(s1);
			other[i] = Integer.parseInt(s2);
		}
		SelectionSort.selectionSort(test);
		for(int i = 0; i < n; i++) {
			if(test[i] != other[i]) {	
				return false;
			}
		}
		reader.close();
		reader2.close();
		return true;
	}
	
	public static boolean testHeapSort(int n) throws IOException {
		int[] test = new int[n];
		int[] other = new int[n];
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("./test.txt")));
		BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream("./correct.txt")));
		for(int i = 0; i < n; i++) {
			String s1 = reader.readLine();
			String s2 = reader2.readLine();
			//System.out.println(Integer.parseInt(s1) + " " + Integer.parseInt(s2));
			test[i] = Integer.parseInt(s1);
			other[i] = Integer.parseInt(s2);
		}
		HeapSort.heapSort(test);
		for(int i = 0; i < n; i++) {
			if(test[i] != other[i]) {	
				return false;
			}
		}
		reader.close();
		reader2.close();
		return true;
	}
	
	public static boolean testInsertionSort(int n) throws IOException {
		int[] test = new int[n];
		int[] other = new int[n];
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("./test.txt")));
		BufferedReader reader2 = new BufferedReader(new InputStreamReader(new FileInputStream("./correct.txt")));
		for(int i = 0; i < n; i++) {
			String s1 = reader.readLine();
			String s2 = reader2.readLine();
			//System.out.println(Integer.parseInt(s1) + " " + Integer.parseInt(s2));
			test[i] = Integer.parseInt(s1);
			other[i] = Integer.parseInt(s2);
		}
		InsertionSort.insertionSort(test);
		for(int i = 0; i < n; i++) {
			if(test[i] != other[i]) {	
				return false;
			}
		}
		reader.close();
		reader2.close();
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		generateTestData(10000);
		//System.out.println(testMergeSort(10000));
		//System.out.println(testBubbleSort(10000));
		//System.out.println(testQuickSort(10000));
		//System.out.println(testSelectionSort(10000));
		//System.out.println(testInsertionSort(10000));
		System.out.println(testHeapSort(10000));
		//System.out.println(SelectionSort.assignments);
	}
}
