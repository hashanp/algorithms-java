package DataStructures;

import java.util.ArrayList;

public class MaxHeap {
	private ArrayList<Integer> data = new ArrayList<>();
	
	public void add(int item) {
		int index = data.size();
		data.add(item);
		while(index != 0) {
			int oldIndex = index;
			index = (index-1)/2;
			int k = data.get(index);
			if(k < item) {
				data.set(index, item);
				data.set(oldIndex, k);
			} else {
				break;
			}
		}
	}
	
	public int remove() {
		int c = data.get(0);
		int last = data.get(data.size()-1);
		data.set(0, last);
		data.remove(data.size()-1);
		int index = 0;
		while(true) {
			if((2*index)+2 > data.size()) {
				break;
			} else if((2*index)+2 == data.size()) {
				int leftChild = data.get((2*index)+1);
				if(last < leftChild) {
					data.set((2*index)+1, last);
					data.set(index, leftChild);
				}
				break;
			} else {
				int leftChild = data.get((2*index)+1);
				int rightChild = data.get((2*index)+2);
				if(leftChild > rightChild && last < leftChild) {
					data.set((2*index)+1, last);
					data.set(index, leftChild);
					index = (2*index)+1;
				} else if(last < rightChild) {
					data.set((2*index)+2, last);
					data.set(index, rightChild);
					index = (2*index)+2;
				} else {
					break;
				}
			}	
		}
		return c;
	}
	
	public boolean isEmpty() {
		return data.size() == 0;
	}
	
	public static void main(String[] args) {
		MaxHeap k = new MaxHeap();
		k.add(4);
		k.add(3);
		k.add(12);
		k.add(6);
		k.add(11);
		System.out.println(k.remove());
		System.out.println(k.remove());
		System.out.println(k.remove());
		System.out.println(k.remove());
		System.out.println(k.remove());
		System.out.println(k.data);
	}
}
