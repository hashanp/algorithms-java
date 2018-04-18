package DataStructures;

import java.util.Iterator;

public interface List<T> extends Iterable<T> {
  void add(T item);
  void remove(int index);
  T get(int index);
  int size();

  default Iterator<T> iterator() {
    return new Iterator<T>() {
      private int i = 0;

      @Override
      public boolean hasNext() {
        return i != size();
      }

      @Override
      public T next() {
        return get(i++);
      }
    };
  }
}
