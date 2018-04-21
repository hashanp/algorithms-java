package DataStructures;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashSet;
import java.util.Set;

public class QuickUnion {
  public int[] data; // Stores component information
  private int[] size; // Stores height of trees

  public QuickUnion(int n) {
    data = new int[n];
    size = new int[n];
    for(int i = 0; i < n; i++) {
      data[i] = i;
      size[i] = 1;
    }
  }

  private int root(int a) {
    while(data[a] != a) {
      a = data[a];
    }
    return a;
  }

  public void union(int a, int b) {
    int rootA = root(a);
    int rootB = root(b);
    if(size[rootA] > size[rootB]) {
      int currentB = b;
      while(data[currentB] != currentB) {
        int temp = currentB;
        currentB = data[currentB];
        data[temp] = rootA;
      }
      data[rootB] = rootA;
      size[rootB] = Math.max(size[rootB], 1 + size[rootA]);
    } else {
      int currentA = a;
      while(data[currentA] != currentA) {
        int temp = currentA;
        currentA = data[currentA];
        data[temp] = rootB;
      }
      data[rootA] = rootB;
      size[rootA] = Math.max(size[rootA], 1 + size[rootB]);
    }
  }

  public boolean connected(int a, int b) {
    return root(data[a]) == root(data[b]);
  }

  public int find(int a) {
    return root(data[a]);
  }

  public static QuickUnion readFromFile(String file) throws IOException {
    BufferedReader buf = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
    QuickUnion quickUnion = new QuickUnion(Integer.parseInt(buf.readLine()));
    String line = buf.readLine();
    while(line != null) {
      String[] parts = line.split(" ");
      int a = Integer.parseInt(parts[0]);
      int b = Integer.parseInt(parts[1]);
      quickUnion.union(a, b);
      line = buf.readLine();
    }
    return quickUnion;
  }

  public static void main(String[] args) throws IOException {
    QuickUnion quickUnion = readFromFile("./largeUF.txt");
    Set<Integer> set = new HashSet<Integer>();
    for(int i = 0; i < quickUnion.data.length; i++) {
      set.add(quickUnion.root(quickUnion.data[i]));
    }
    System.out.println(set.size());
  }
}
