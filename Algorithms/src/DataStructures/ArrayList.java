package DataStructures;

import java.util.NoSuchElementException;

public class ArrayList<T> implements List<T> {
	private T[] data;
	private int length = 0;
	
	@SuppressWarnings("unchecked")
	public ArrayList() {
		data = (T[]) new Object[10];
	}
	
	@SuppressWarnings("unchecked")
	public void add(T item) {
		if(length == data.length) {
			T[] m = (T[]) new Object[data.length * 2];
			System.arraycopy(data, 0, m, 0, data.length);
			data = m;
		}
		data[length] = item;
		length++;
	}
	
	public T get(int index) throws NoSuchElementException {
		if(index >= length) {
			throw new NoSuchElementException();
		}
		return data[index];
	}
	
	public int size() {
		return length;
	}
	
	public void remove(int index) {
		for(int i = index; i < length-1; i++) {
			data[i] = data[i+1];
		}
		length--;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> m = new ArrayList<>();
		m.add(4);
		m.add(2);
		//m.remove(0);
		System.out.println(m.get(0));
		
		for(Integer i: m) {
			System.out.println(i);
		}
	}
}
