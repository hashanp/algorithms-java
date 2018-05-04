package DataStructures;

import java.util.EmptyStackException;

public class DynamicStack<T> {
	private LinkedList<T> data = new LinkedList<>();
	
	public void push(T item) {
		data.add(item);
	}
	
	public T pop() throws EmptyStackException {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		T item = data.get(data.size()-1);
		data.remove(data.size()-1);
		return item;
	}
	
	public boolean isEmpty() {
		return data.size() == 0;
	}
	
	public static void main(String[] args) {
		DynamicStack<Integer> stack = new DynamicStack<>();
		stack.push(4);
		stack.push(5);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
