import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

public class ComparatorTest {
	@Test
	public void test() {
		String[] strArr = {"cat", "Dog", "lion", "tiger"};
		Arrays.sort(strArr); //String 의 Comparable 구현에 의한 정렬
		System.out.println(Arrays.toString(strArr));

		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); // 대소문자 구분안함
		System.out.println(Arrays.toString(strArr));

		Arrays.sort(strArr, new Descending());
		System.out.println(Arrays.toString(strArr));
	}

	class Descending implements Comparator {

		@Override
		public int compare(Object o1, Object o2) {
			if (o1 instanceof Comparable && o2 instanceof Comparable) {
				Comparable c1 = (Comparable) o1;
				Comparable c2 = (Comparable) o2;
				return c1.compareTo(c2) * -1;
			}
			return -1;
		}
	}
}
