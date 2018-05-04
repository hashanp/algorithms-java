package DataStructures;

import java.util.EmptyStackException;

public class Stack<T> {
	T[] data;
	int length = 0;
	
	@SuppressWarnings("unchecked")
	public Stack(int capacity) {
		data = (T[]) new Object[capacity];
	}
	
	public void push(T item) {
		data[length] = item;
		length++;
	}
	
	public T pop() throws EmptyStackException {
		if(this.isEmpty()) {
			throw new EmptyStackException();
		}
		length--;
		return data[length];
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public boolean isFull() {
		return length == data.length;
	}
	
	public static void main(String[] args) {
		Stack<Integer> c = new Stack<>(1);
		c.push(4);
		System.out.println(c.pop());
		System.out.println(c.pop());
	}
}
