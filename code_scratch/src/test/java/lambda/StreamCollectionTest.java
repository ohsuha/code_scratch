package lambda;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class StreamCollectionTest {

	@Test
	public void test() {
		String[] strArr = {"aaa","bbb","ccc"};
		Stream<String> stringStream = Stream.of(strArr);
		String result = stringStream.collect(new MyCollector()).toString();

		System.out.println(Arrays.toString(strArr));
		System.out.println(result);
	}
}
