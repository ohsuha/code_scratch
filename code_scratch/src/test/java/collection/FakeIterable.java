package collection;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

public interface FakeIterable<T> {
	FakeIterator<T> iterator();
	default void forEach(Consumer<? super T> action) {
		Objects.requireNonNull(action);
		// for (T t : this) {
		// 	action.accept(t);
		// }

		FakeIterator<T> it = this.iterator();
		while (it.hasNext()) {
			action.accept(it.next());
		}
	}
	// default Spliterator<T> spliterator() {
	// 	return Spliterators.spliteratorUnknownSize(iterator(), 0);
	// }
}
