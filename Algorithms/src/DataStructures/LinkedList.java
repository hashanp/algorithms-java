package DataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {
	private static class Node<T> {
		T item;
		Node<T> next;
		
		public Node(T item) {
			this.item = item;
		}
	}
	
	private Node<T> first;
	private int length = 0;
	
	public void add(T item) {
		if(first == null) {
			first = new Node<T>(item);
		} else {
			Node<T> k = first;
			while(k.next != null) {
				k = k.next;
			}
			k.next = new Node<T>(item);
		}
		length++;
	}
	
	public T get(int index) throws NoSuchElementException {
		if(index >= length) {
			throw new NoSuchElementException();
		}
		Node<T> k = first;
		for(int i = 0; i < index; i++) {
			k = k.next;
		}
		return k.item;
	}
	
	public void remove(int index) {
		if(index >= length) {
			throw new NoSuchElementException();
		}
		if(index == 0) {
			first = first.next;
		} else {
			Node<T> k = first;
			for(int i = 0; i < index-1; i++) {
				k = k.next;
			}
			k.next = k.next.next;
		}
		length--;
	}
	
	public int size() {
		return this.length;
	}
	
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Node<T> node = first;
			
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return node != null;
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				Node<T> t = node;
				node = node.next;
				return t.item;
			}
			
		};
	}

	public static void main(String[] args) {
		LinkedList<Integer> k = new LinkedList<>();
		k.add(4);
		k.add(5);
		for(Integer y: k) {
			System.out.println(y);
		}
		System.out.println(k.get(0));
		k.remove(0);
		System.out.println(k.get(0));
	}
}
