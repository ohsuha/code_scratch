package collection.collections;

import java.util.Arrays;
import java.util.Objects;

public abstract class FakeAbstractCollection<E> implements FakeCollection<E> {
	protected FakeAbstractCollection() {};
	public abstract int size();
	public boolean isEmpty() {return size() == 0;}
	public boolean contains(Object o) {
		FakeIterator<E> iterator = iterator();
		if (o == null) {
			while (iterator.hasNext()) {
				if (iterator.next() == null) {
					return true;
				}
			}
		} else {
			while (iterator.hasNext()) {
				if (o.equals(iterator.next())) {
					return true;
				}
			}
		}
		return false;
	}
	public abstract FakeIterator<E> iterator();

	public Object[] toArray() {
		Object[] array = new Object[size()];
		FakeIterator<E> iterator = iterator();
		for (int i = 0; i < array.length; i++) {
			if (!iterator.hasNext()) {
				return Arrays.copyOf(array, i);
			}
			array[i] = iterator.next();
		}
		return iterator.hasNext() ? finishToArray(array, iterator) : array;
	}

	public <T> T[] toArray(T[] a) {
		int size = size();
		T[] r = a.length >= size ? a : (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
		/**
		 * java.lang.reflect.Array.newInstance()를 사용해 런타임에 타입 정보에 기반하여 새로운 배열을 생성합니다. 이 방법을 사용하면 T의 런타임 타입을 유지할 수 있습니다.
		 * 제네릭 이레이저는 Java에서 제네릭 타입 정보를 컴파일 후 제거하는 과정입니다.
		 * 리플렉션을 사용하여 런타임에 새로운 배열을 생성하고, 그 배열에 요소를 복사한 후 반환합니다.
		 *
		 * Java의 제네릭은 컴파일 타임에만 타입 정보를 유지하고, 런타임에는 이 타입 정보가 지워집니다.
		 * 따라서 제네릭 타입 파라미터 T는 런타임에 Object로 처리됩니다.
		 * 이로 인해, T[] 배열을 직접 생성하는 것이 불가능합니다. 예를 들어, new T[size]와 같은 코드를 작성할 수 없습니다.
		 * 이는 Java가 배열의 런타임 타입을 알 수 없기 때문입니다.
		 * toArray(T[] a) 메서드에서 배열 a의 타입을 기준으로 새 배열을 생성할 때,
		 * 제네릭 이레이저로 인해 실제 타입 정보를 유지할 수 없습니다.
		 * 따라서 java.lang.reflect.Array.newInstance()를 사용하여 런타임에 정확한 배열 타입을 생성해야 합니다.
		 * 이 과정에서 (T[])와 같은 캐스팅이 필요합니다.
		 * 캐스팅은 컴파일러에게 타입을 믿으라고 알리는 역할을 하지만, 제네릭 이레이저로 인해 실제 타입 안전성은 보장되지 않습니다.
		 */
		FakeIterator<E> it = iterator();

		for (int i = 0; i < r.length; i++) {
			if (!it.hasNext()) {

			}
			r[i] = (T) it.next();
		}
		return it.hasNext() ? finishToArray(r, it) : r;
	}

	public boolean add(E e) {
		throw new UnsupportedOperationException();
		// 아직 어떤 형태의 콜렉션인지 정해지지 않았으므로???
	}

	public boolean remove(Object o) {
		FakeIterator<E> it = iterator();
		if (o==null) {
			while (it.hasNext()) {
				if (it.next()==null) {
					it.remove();
					return true;
				}
			}
		} else {
			while (it.hasNext()) {
				if (o.equals(it.next())) {
					it.remove();
					return true;
				}
			}
		}
		return false;
	}

	public boolean containsAll(FakeCollection<?> c) {
		FakeIterator<?> iterator = c.iterator();
		while (iterator.hasNext()) {
			Object e = iterator.next();
			if (!contains(e)) {
				return false;
			}
		}
		// for (Object e : c) { stream 구현을 안해놔서 여기에 FakeCollection 을 쓸 수 없음
		// 	if (!contains(e))
		// 		return false;
		// }
		return true;
	}

	public boolean addAll(FakeCollection<? extends E> c) {
		boolean modified = false;
		FakeIterator<?> iterator = c.iterator();
		while (iterator.hasNext()) {
			if (add(iterator().next())){
				modified = true;
			}
		}
		// for (E e : c)
		// 	if (add(e))
		// 		modified = true;
		return modified;
	}

	public boolean removeAll(FakeCollection<?> c) {
		Objects.requireNonNull(c);
		boolean modified = false;
		FakeIterator<?> it = iterator();
		while (it.hasNext()) {
			if (c.contains(it.next())) {
				it.remove();
				modified = true;
			}
		}
		return modified;
	}

	public boolean retainAll(FakeCollection<?> c) {
		Objects.requireNonNull(c);
		boolean modified = false;
		FakeIterator<E> it = iterator();
		while (it.hasNext()) {
			if (!c.contains(it.next())) {
				it.remove();
				modified = true;
			}
		}
		return modified;
	}

	public void clear() {
		FakeIterator<E> it = iterator();
		while (it.hasNext()) {
			it.next();
			it.remove();
		}
	}





	// java internal
	private static <T> T[] finishToArray(T[] r, FakeIterator<?> it) {
		int len = r.length;
		int i = len;
		while (it.hasNext()) {
			if (i == len) {
				len = newLength(len, 1, len + 1);
			}
			r[i++] = (T)it.next();
		}
		// trim if overallocated
		return (i == len) ? r : Arrays.copyOf(r, i);
	}


	private static int newLength(int oldLength, int minGrowth, int prefGrowth) {
		int prefLength = oldLength + Math.max(minGrowth, prefGrowth); // might overflow
		if (0 < prefLength && prefLength <= Integer.MAX_VALUE - 8) {
			return prefLength;
		} else {
			// put code cold in a separate method
			return hugeLength(oldLength, minGrowth);
		}
	}

	private static int hugeLength(int oldLength, int minGrowth) {
		int minLength = oldLength + minGrowth;
		if (minLength < 0) { // overflow
			throw new OutOfMemoryError(
				"Required array length " + oldLength + " + " + minGrowth + " is too large");
		} else if (minLength <= Integer.MAX_VALUE - 8) {
			return Integer.MAX_VALUE - 8;
		} else {
			return minLength;
		}
	}
}
