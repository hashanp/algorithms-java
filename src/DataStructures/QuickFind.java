package DataStructures;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class QuickFind {
	private int[] data;
	
	public QuickFind(int n) {
		data = new int[n];
		for(int i = 0; i < n; i++) {
			data[i] = i;
		}
	}
	
	public void union(int a, int b) {
		int oldComponentNumber = Math.max(data[a], data[b]);
		int newComponentNumber = Math.min(data[a], data[b]);
		for(int i = 0; i < data.length; i++) {
			if(data[i] == oldComponentNumber) {
				data[i] = newComponentNumber;
			}
		}
	}
	
	public boolean connected(int a, int b) {
		return data[a] == data[b];
	}
	
	public int find(int a) {
		return data[a];
	}
	
	public int count() {
		int total = 0;
		int highest = -1;
		for(int i = 0; i < data.length; i++) {
			if(data[i] > highest) {
				total++;
				highest = data[i];
			}
		}
		return total;
	}
	
	public static QuickFind readFromFile(String file) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		QuickFind quickFind = new QuickFind(Integer.parseInt(buf.readLine()));
		String line = buf.readLine();
		while(line != null) {
			String[] parts = line.split(" ");
			int a = Integer.parseInt(parts[0]);
			int b = Integer.parseInt(parts[1]);
			quickFind.union(a, b);
			line = buf.readLine();
		}
		return quickFind;
	}
	
	public static void main(String[] args) throws IOException {
		QuickFind quickFind = readFromFile("./mediumUF.txt");
		System.out.println(quickFind.count());
	}
}
