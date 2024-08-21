import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import test.pattern.adapter.AdapterServiceA;
import test.pattern.adapter.AdapterServiceB;
import test.pattern.adapter.ServiceA;
import test.pattern.adapter.ServiceB;
import test.pattern.proxy.IService;
import test.pattern.proxy.Proxy;
import test.pattern.proxy.Service;

@Slf4j
public class PatternTest {
	@Test
	@DisplayName("adapter pattern 1 : no adapter")
	public void ClientWithNoAdapter() {
		ServiceA sa1 = new ServiceA();
		ServiceB sb1 = new ServiceB();

		sa1.runServiceA();
		sb1.runServiceB();
		// 참조 변수를 통해 호출하는 각 메서드가 비슷한 일을 하지만 메서드명이 다르다.
	}

	@Test
	@DisplayName("adapter pattern 2 : with adapter")
	public void ClientWithAdapter() {
		AdapterServiceA adapterServiceA = new AdapterServiceA();
		AdapterServiceB adapterServiceB = new AdapterServiceB();

		adapterServiceA.runService();
		adapterServiceB.runService();
		// adapter 를 통해 runService() 라는 동일한 메서드명으로 두 객체의 메서드를 호출 할 수 있다.
		// 변환기들이 인터페이슬 구현하게 해서 더 개선할 수도 있다.

	}

	@Test
	@DisplayName("proxy pattern 1 : no proxy")
	public void ClientWithNoProxy() {
		Service service = new Service();
		log.info(service.runSomething());
	}

	@Test
	@DisplayName("proxy pattern 2 : with proxy")
	public void ClientWithProxy() {
		IService proxy = new Proxy();
		log.info(proxy.runSomething());
	}
}
