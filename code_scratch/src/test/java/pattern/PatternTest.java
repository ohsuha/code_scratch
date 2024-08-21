package pattern;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import pattern.adapter.AdapterServiceA;
import pattern.adapter.AdapterServiceB;
import pattern.adapter.ServiceA;
import pattern.adapter.ServiceB;
import pattern.decoreator.Decorator;
import pattern.factorymethod.AnimalToy;
import pattern.proxy.IService;
import pattern.proxy.Proxy;
import pattern.proxy.Service;
import pattern.singleton.Singleton;
import pattern.strategy.Soldier;
import pattern.strategy.Strategy;
import pattern.strategy.StrategyBow;
import pattern.strategy.StrategyGun;
import pattern.strategy.StrategySword;
import pattern.strategy.Warrior;
import pattern.tempaltemethod.Animal;
import pattern.tempaltemethod.Cat;
import pattern.tempaltemethod.Dog;

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

	@Test
	@DisplayName("decorator pattern")
	public void ClientWithDecorator() {
		IService decorator = new Decorator();
		log.info(decorator.runSomething());
	}

	@Test
	@DisplayName("singleton pattern")
	public void ClientWithSingleton() {
		Singleton singletonA = Singleton.getInstance();
		Singleton singletonB = Singleton.getInstance();
		Singleton singletonC = Singleton.getInstance();

		log.info(String.valueOf(singletonA==singletonB)); //true
		log.info(String.valueOf(singletonC==singletonB)); //true
		log.info(String.valueOf(singletonC==singletonA)); //true
	}

	@Test
	@DisplayName("template method pattern")
	public void templateMethodTest() {
		Animal dog = new Dog();
		Animal cat = new Cat();

		dog.playWithOwner();
		cat.playWithOwner();
	}

	@Test
	@DisplayName("factory method pattern")
	public void factoryMethodTest() {
		// 팩터리 메서드를 보유한 객체들 생성
		pattern.factorymethod.Animal dog
			= new pattern.factorymethod.Dog();
		pattern.factorymethod.Animal cat
			= new pattern.factorymethod.Cat();

		// 팩터리 메서드가 반환하는 객체들
		AnimalToy dogToy = dog.getToy();
		AnimalToy catToy = cat.getToy();

		// 팩터리 메서드가 반환한 객체들을 사용한다.
		dogToy.identify();
		catToy.identify();
	}

	@Test
	@DisplayName("Strategy method pattern")
	public void strategyTest() {
		Strategy strategy = null;

		Soldier soldier = new Soldier();

		strategy = new StrategyGun();
		soldier.runContext(strategy);

		strategy = new StrategyBow();
		soldier.runContext(strategy);

		strategy = new StrategySword();
		soldier.runContext(strategy);
	}

	@Test
	@DisplayName("Template CallBack pattern")
	public void templateCallBackTest() {
		Soldier soldier = new Soldier();
		soldier.runContext(new Strategy() {
			@Override
			public void runStrategy() {
				System.out.println("총 초총 총!!");
			}
		});

		soldier.runContext(new Strategy() {
			@Override
			public void runStrategy() {
				System.out.println("칼! 카가갈 칼! 칼!");
			}
		});
	}

	@Test
	@DisplayName("Template CallBack pattern2")
	public void templateCallBackTest2() {
		Warrior warrior = new Warrior();
		warrior.runContext("총 초총 총총");
		warrior.runContext("활 화활 활");
	}
}
