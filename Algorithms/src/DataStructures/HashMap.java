package DataStructures;

import java.util.LinkedList;

public class HashMap<A, B> {
	private static class Node<A, B> {
		A key;
		B value;
		
		public Node(A key, B value) {
			this.key = key;
			this.value = value;
		}
	}
	
	@SuppressWarnings("unchecked")
	private LinkedList<Node<A, B>>[] list = (LinkedList<Node<A, B>>[]) new LinkedList<?>[16];
	private int length = 0;
	
	public B get(A key) {
		int hash = key.hashCode() % list.length;
		for(Node<A, B> el: list[hash]) {
			if(el.key == key) {
				return el.value;
			}
		}
		return null;
	}
	
	private void rehash() {
		LinkedList<Node<A, B>>[] list2 = (LinkedList<Node<A, B>>[]) new LinkedList<?>[list.length * 2];
		for(int i = 0; i < list.length; i++) {
			if(list[i] != null) {
				for(Node<A, B> el: list[i]) {
					int hash = el.key.hashCode() % list2.length;
					if(list2[hash] == null) {
						list2[hash] = new LinkedList<Node<A, B>>();
					}
					list2[hash].add(el);
				}
			}	
		}
		list = list2;
	}
	
	public void put(A key, B value) {
		int hash = key.hashCode() % list.length;
		if(list[hash] == null) {
			list[hash] = new LinkedList<Node<A, B>>();
		}
		list[hash].add(new Node<A, B>(key, value));
		length++;
		if(length > list.length * 0.75) {
			rehash();
		}
	}
	
	public int size() {
		return length;
	}
	
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("Hello", 5);
		map.put("Bye", 3);
		map.put("Phi", 4);
		map.put("Why", 4);
		map.put("Why5", 4);
		map.put("Why6", 4);
		map.put("Why7", 4);
		map.put("Why8", 4);
		map.put("Why9", 4);
		map.put("Why10", 4);
		map.put("Why11", 4);
		map.put("Why12", 4);
		map.put("Why13", 4);
		map.put("Why14", 4);
		map.put("Why15", 4);
		map.put("Why16", 4);
		map.put("Why17", 4);
		System.out.println(map.get("Hello"));
		System.out.println(map.get("Bye"));
		System.out.println(map.get("Why17"));
		System.out.println(map.size());
	}
}
