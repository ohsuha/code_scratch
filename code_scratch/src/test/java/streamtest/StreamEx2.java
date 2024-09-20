package streamtest;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class StreamEx2 {
	@Test
	public void test1() {
		Stream<String[]> strArrStrm = Stream.of(
			new String[] {"abc", "def", "jkl"},
			new String[] {"ABC", "GHI", "JKL"}
		);

		// Stream<Stream<String>> streamStream = strArrStrm.map(Arrays::stream);
		// 아래처럼 flatmap 으로 변경
		Stream<String> strStream = strArrStrm.flatMap(Arrays::stream);

		strStream.map(String::toLowerCase)
			.distinct()
			.sorted()
			.forEach(System.out::println);

		System.out.println();

		String[] lineArr = {
			"Believe or not It is true",
			"Do or do not there is no try"
		};

		Stream<String> lineStream = Arrays.stream(lineArr);
		lineStream.flatMap(line -> Stream.of(line.split(" +")))
			.map(String::toLowerCase)
			.distinct()
			.sorted()
			.forEach(System.out::println);

		System.out.println();

		Stream<String> strStrm1 = Stream.of("AAA", "ABC", "bBb", "Dd");
		Stream<String> strStrm2 = Stream.of("bbb", "aaa", "ccc", "dd");

		Stream<Stream<String>> strStrmStrm = Stream.of(strStrm1, strStrm2);
		Stream<String> strStrm = strStrmStrm.map(s -> s.toArray(String[]::new)).flatMap(Arrays::stream);
		strStrm.map(String::toLowerCase)
			.distinct()
			.forEach(System.out::println);
	}
}
