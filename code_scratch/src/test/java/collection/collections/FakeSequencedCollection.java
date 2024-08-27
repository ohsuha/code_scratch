package collection.collections;

import java.util.SequencedCollection;

public interface FakeSequencedCollection<E> extends FakeCollection<E> {
	SequencedCollection<E> reversed(); // 역순으로 정렬된 콜렉션을 리턴해준다.
	default void addFirst(E e) {
		throw new UnsupportedOperationException();
	}
	default void addLast(E e) {
		throw new UnsupportedOperationException();
	}
	default E getFirst() {
		return this.iterator().next();
	}
	default E getLast() {
		return this.reversed().iterator().next();
	}
	default E removeFirst() {
		var it = this.iterator();
		E e = it.next();
		it.remove();
		return e;
	}
	default E removeLast() {
		var it = this.reversed().iterator();
		E e = it.next();
		it.remove();
		return e;
	}

}
