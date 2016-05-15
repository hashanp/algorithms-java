package DataStructures;

import java.util.NoSuchElementException;

public class BinarySearchTree<A extends Comparable<A>, B> {
	public static class Node<A extends Comparable<A>, B> {
		A key;
		B value;
		Node left;
		Node right;
		
		public Node(A key, B value) {
			this.key = key;
			this.value = value;
		}
	}
	
	public Node<A, B> root;
		
	public void insert(A key, B value) {
		if(root == null) {
			root = new Node<>(key, value);
		} else {
			Node<A, B> current = root;
			while(true) {
				if(key.compareTo(current.key) < 0) {
					if(current.left == null) {
						current.left = new Node<>(key, value);
						break;
					} else {
						current = current.left;
					}
				} else if(key.compareTo(current.key) > 0) {
					if(current.right == null) {
						current.right = new Node<>(key, value);
						break;
					} else {
						current = current.right;
					}
				}
			}
		}
	}
	
	public B get(A key) {
		Node<A, B> current = root;
		while(current != null && current.key != key) {
			if(key.compareTo(current.key) < 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		if(current == null) {
			throw new NoSuchElementException();
		} else {
			return current.value;
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTree<Integer, Integer> k = new BinarySearchTree<>();
		k.insert(4, 7);
		k.insert(1, 3);
		k.insert(6, 8);
		k.insert(7, 8);
		System.out.println(k.get(4));
		System.out.println(k.get(1));
		System.out.println(k.get(6));
		System.out.println(k.get(7));
	}
}
