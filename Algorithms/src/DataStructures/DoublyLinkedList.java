package DataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

import DataStructures.LinkedList.Node;

public class DoublyLinkedList<T> implements List<T> {
	public static class Node<T> {
		T item;
		Node<T> next;
		Node<T> prev;
		
		public Node(T item, Node<T> prev) {
			this.item = item;
			this.prev = prev;
		}
	}
	
	public Node<T> first;
	private int length = 0;
	
	public void add(T item) {
		if(first == null) {
			first = new Node<T>(item, null);
		} else {
			Node<T> k = first;
			while(k.next != null) {
				k = k.next;
			}
			k.next = new Node<T>(item, k);
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
			first.next.prev = null;
			first = first.next;
		} else {
			Node<T> k = first;
			for(int i = 0; i < index-1; i++) {
				k = k.next;
			}
			k.next.next.prev = k;
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
	
	public void reverse() {
		Node<T> last = null;
		Node<T> current = first;
		while(current != null) {
			current.prev = current.next;
			Node<T> temp = current.next;
			current.next = last;
			last = current;
			current = temp;
		}
		first = last;
	}

	public static void main(String[] args) {
		DoublyLinkedList<Integer> k = new DoublyLinkedList<>();
		k.add(4);
		k.add(5);
		k.add(6);
		System.out.println(k.first.prev);
		System.out.println(k.first.next.prev.item);
		System.out.println(k.first.next.next.prev.item);
		for(Integer y: k) {
			System.out.println(y);
		}
	//	System.out.println(k.get(0));
	//	k.remove(0);
	//	System.out.println(k.get(0));
		k.reverse();
		for(Integer y: k) {
			System.out.println(y);
		}
		System.out.println(k.first.prev);
		System.out.println(k.first.next.prev.item);
		System.out.println(k.first.next.next.prev.item);
		System.out.println(k.first);
	}
}
