package lambdatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

public class LambdaEx3 {
	@Test
	public void test() {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}

		//list 의 모든 요소를 출력
		list.forEach(i -> System.out.print(i + ","));
		System.out.println();

		//list 에서 2 또는 3의 배수를 제거한다.
		list.removeIf(x -> x % 2 == 0 || 2 % 3 == 0);
		System.out.println(list);

		// list 의 각 요소에 10을 곱한다.
		list.replaceAll(i -> i * 10);
		System.out.println(list);

		Map<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");

		//map 의 모든 요소를 {k,v} 형식으로 출력한다.
		map.forEach((k, v) -> System.out.print("{" + k + "," + v + "}"));
		System.out.println();
	}

	@Test
	public void test2() {
		//지네릭과 래퍼클래스를 사용하는 함수형 인터페이스
		Supplier<Integer> s = () -> (int)(Math.random() * 100) + 1;
		Consumer<Integer> c = i -> System.out.print(i + ",");
		Predicate<Integer> p = i -> i % 2 == 0;
		Function<Integer, Integer> f = i -> i / 10 * 10;

		List<Integer> list = new ArrayList<>();
		makeRandomList(s, list);
		System.out.println(list);
		printEvenNum(p, c, list);
		List<Integer> newList = doSomething(f, list);
		System.out.println(newList);
	}

	<T> List<T> doSomething(Function<T, T> f, List<T> list) {
		List<T> newList = new ArrayList<>(list.size());

		for (T t : list) {
			newList.add(f.apply(t));
		}
		return newList;
	}

	<T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
		System.out.print("[");
		for (T i : list) {
			if (p.test(i)) {
				c.accept(i);
			}
		}
		System.out.println("]");
	}

	<T> void makeRandomList(Supplier<T> s, List<T> list) {
		for (int i = 0; i < 10; i++) {
			list.add(s.get());
		}
	}

	@Test
	public void test3() {
		//기본형을 사용하는 함수형 인터페이스
		IntSupplier s = () -> (int)(Math.random() * 100) + 1;
		IntConsumer c = i -> System.out.print(i + ",");
		IntPredicate p = i -> i % 2 == 0;
		IntUnaryOperator o = i -> i / 10 * 10;
		int[] arr = new int[10];
		makeRandomIntList(s, arr);
		System.out.println(Arrays.toString(arr));
		printEvenIntNum(p, c, arr);
		int[] newArr = doIntSomething(o, arr);
		System.out.println(Arrays.toString(newArr));
	}

	void makeRandomIntList(IntSupplier s, int[] arr) {
		for (int i = 0; i < 10; i++) {
			arr[i] = s.getAsInt();
		}
	}

	void printEvenIntNum(IntPredicate p, IntConsumer c, int[] arr) {
		System.out.print("[");
		for (int i : arr) {
			if (p.test(i)) {
				c.accept(i);
			}
		}
		System.out.println("]");
	}

	int[] doIntSomething(IntUnaryOperator f, int[] list) {
		int[] newArr = new int[list.length];
		for (int i = 0; i < list.length; i++) {
			newArr[i] = f.applyAsInt(list[i]);
		}
		return newArr;
	}

	@Test
	public void test4() {
		Function<String, Integer> f = (s) -> Integer.parseInt(s, 16);
		Function<Integer, String> g = (i) -> Integer.toBinaryString(i);

		Function<String, String> h = f.andThen(g);
		Function<Integer, Integer> h2 = f.compose(g);

		System.out.println(h.apply("FF")); // FF -> 255 -> "11111111"
		System.out.println(h2.apply(2)); // 2-> "10" -> 16

		Function<String, String> f2 = x -> x;
		System.out.println(f2.apply("AAA"));

		Predicate<Integer> p = i -> i < 100;
		Predicate<Integer> q = i -> i < 200;
		Predicate<Integer> r = i -> i % 2 == 0;
		Predicate<Integer> notP = p.negate(); //p 의 반대 조건 i>=100

		Predicate<Integer> all = notP.and(q.or(r));
		System.out.println(all.test(150));

		String str1 = "abc";
		String str2 = "abc";

		Predicate<String> p2 = Predicate.isEqual(str1);
		boolean result = p2.test(str2);
		System.out.println(result);
	}
}
