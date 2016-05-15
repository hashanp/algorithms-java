package DataStructures;

import java.util.Iterator;

public interface List<T> extends Iterable<T> {
	public void add(T item);
	public void remove(int index);
	public T get(int index);
	public int size();
	
	default public Iterator<T> iterator() {
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
