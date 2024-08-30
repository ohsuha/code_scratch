package lambda;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

public class MyCollector implements java.util.stream.Collector {

	@Override
	public Supplier<StringBuilder> supplier() {
		// 작업 결과를 저장할 공간을 제공
		return () -> new StringBuilder();
	}

	@Override
	public BiConsumer<StringBuilder, String> accumulator() {
		// 스트림의 요소를 수집할 방법을 제공
		// 스트림의 요소를 어떻게 supplier()가 제공한 공간에 누적할 것인지를 정의한다.
		return (sb, s) -> sb.append(s);
	}

	@Override
	public BinaryOperator<StringBuilder> combiner() {
		// 두 저장공간을 병합할 방법을 제공(병렬 스트림)
		// 병렬 스트림인 경우 여러 스레드에 의해 처리된 결과를 어떻게 합칠것인가?
		return (sb1, sb2) -> sb1.append(sb2);
	}

	@Override
	public Function<StringBuilder, String> finisher() {
		// 결과를 최종적으로 변환할 방법을 제공
		// 변환이 필요없다면 Function.identitiy() 를 반환한다
		return sb -> sb.toString();
	}

	@Override
	public Set<Characteristics> characteristics() {
		// 컬렉터가 수행하는 작업의 속성에 대한 정보를 제공하기 위한 것이다.
		// Characteristics.CONCURRENT : 병렬로 처리할 수 있는 작업
		// Characteristics.UNORDERED : 스트림의 요소의 순서가 유지될 필요가 없는 작업
		// Characteristics.IDENTITY_FINISH : finisher()가 항등 함수인 작업
		// Collections.emptySet() : 지정할 특성이 없는 경우 비어있는 set 을 리턴
		return Collections.emptySet();
	}
}
