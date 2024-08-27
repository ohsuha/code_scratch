package collection.collections;

import java.util.Objects;
import java.util.function.Predicate;

public interface FakeCollection<E> extends FakeIterable<E> {
	// int를 초과하는 사이즈면 Integer.Maxvalue 리턴함
	int size();

	boolean isEmpty();

	boolean contains(Object o);

	FakeIterator<E> iterator();

	//
	Object[] toArray();

	<T> T[] toArray(T[] a);

	// modification operations
	boolean add(E e);

	boolean remove(Object o);

	boolean containsAll(FakeCollection<?> c);

	boolean addAll(FakeCollection<? extends E> c);

	boolean removeAll(FakeCollection<?> c);

	default boolean removeIf(Predicate<? super E> filter) {
		Objects.requireNonNull(filter);
		boolean removed = false;
		final FakeIterator<E> each = iterator();
		while (each.hasNext()) {
			if (filter.test(each.next())) {
				each.remove();
				removed = true;
			}
		}
		return removed;
	}

	// 지정된 컬렉션에 포함되지 않은 모든 배열 목록 요소를 제거
	boolean retainAll(FakeCollection<?> c);

	void clear();

	// Collection 인터페이스를 "직접적으로" 구현하는 프로그래머들(즉, Set이나 List가 아닌 Collection을 구현하는 클래스를 만드는 경우)은 Object.equals를 재정의할 때 주의해야 합니다.
	// 이를 재정의할 필요는 없으며, 가장 간단한 방법은 Object의 기본 구현을 사용하는 것이지만, 구현자는 기본적인 "참조 비교" 대신 "값 비교"를 구현하고자 할 수 있습니다.
	// (List와 Set 인터페이스는 이러한 값 비교를 요구합니다.)
	boolean equals(Object o);

	int hashCode();

	// stream 병렬 처리를 위한 메소드들, 여기서는 일단 주석 처리

	// Spliterator : Splittable Iterator
	// 일반적인 Iterator와 유사하게 컬렉션의 요소들을 순회하지만, 병렬 스트림(parallelStream())을 생성하거나
	// 요소들을 특정 기준에 따라 분할(splitting)할 수 있는 기능을 추가로 제공합니다. 이로 인해 대규모 데이터를 병렬로 처리할 때 성능을 개선할 수 있습니다.
	// 생성된 Spliterator는 stream() 또는 parallelStream() 메서드와 함께 사용되어 스트림을 생성하는 데 활용됩니다.

	// default Spliterator<E> spliterator() {
	// 	return Spliterators.spliterator(this, 0);
	// }

	// default Stream<E> stream() {
	// 	return StreamSupport.stream(spliterator(), false);
	// }

	// default Stream<E> parallelStream() {
	// 	return StreamSupport.stream(spliterator(), true);
	// }
}
