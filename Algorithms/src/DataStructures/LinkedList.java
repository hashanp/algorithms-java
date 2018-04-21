package DataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {

  private final LinkedListNode<T> first = new LinkedListNode<>(null);
  private int length = 0;

  public void add(T item) {
    LinkedListNode<T> k = first;
    while (k.getNext() != null) {
      k = k.getNext();
    }
    k.setNext(new LinkedListNode<>(item));
    length++;
  }

  public T get(int index) {
    if (index >= length) {
      throw new NoSuchElementException();
    }
    LinkedListNode<T> k = first.getNext();
    for (int i = 0; i < index; i++) {
      k = k.getNext();
    }
    return k.getItem();
  }

  public void remove(int index) {
    if (index >= length) {
      throw new NoSuchElementException();
    }
    LinkedListNode<T> k = first;
    for(int i = 0; i < index; i++) {
      k = k.getNext();
    }
    k.setNext(k.getNext().getNext());
    length--;
  }

  public int size() {
    return this.length;
  }

  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private LinkedListNode<T> node = first.getNext();

      @Override
      public boolean hasNext() {
        return node != null;
      }

      @Override
      public T next() {
        LinkedListNode<T> t = node;
        node = node.getNext();
        return t.getItem();
      }

    };
  }

  /*public void reverse() {
    LinkedListNode<T> last = null;
    LinkedListNode<T> current = first;
    while (current != null) {
      LinkedListNode<T> temp = current.getNext();
      current.setNext(last);
      last = current;
      current = temp;
    }
    first = last;
  }*/

  public boolean isEmpty() {
    return this.size() == 0;
  }

  public static void main(String[] args) {
    LinkedList<Integer> k = new LinkedList<>();
    k.add(4);
    k.add(5);
    k.add(6);
    for (Integer y: k) {
      System.out.println(y);
    }
  //	System.out.println(k.get(0));
  	//k.remove(0);
    k.remove(2);
  //	System.out.println(k.get(0));
    //k.reverse();
    for (Integer y: k) {
      System.out.println(y);
    }
  }
}
