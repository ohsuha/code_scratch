package lambdatest;

import org.junit.jupiter.api.Test;

public class LambdaEx2 {
	@Test
	public void test() {
		MyFunction2 f = () -> {};
		// 익명객체는 타입이 없다. 대입 연산자 양변의 타입을 일치 시키기 위해 형변환이 필요하다.
		// 람다식은 MyFunction2 인터페이스를 직접 구현하지 않았지만, 이 인터페이스를 구현한 클래스의 객체와 완전히 동일하기 때문에 허용한다.
		// 그리고 이러한 경우 생략될 수 있다.

		Object obj = (MyFunction) () -> {};
		// 람다식은 객체이지만 Object 타입으로 형변환할 수 없다. 오직 함수형 인터페이스로만 형변환이 가능하다.
		//Object 로 형변환 하기 위해서는 먼저 함수형 인터페이스로 변환해야한다.

		String str = ((Object)(MyFunction2)(() -> {})).toString();
		System.out.println(f);
		System.out.println(obj);
		System.out.println(str);
		System.out.println((MyFunction2)() -> {});
		System.out.println(((Object)(MyFunction2)(() -> {})).toString());
		//lambdatest.LambdaEx2$$Lambda/0x00007fff01139f88@f1da57d 컴파일러는 람다의 타입을 이러한 형식으로 만들어 낸다.
	}

	int val = 10;

	class Inner {
		int val = 20;

		void method(int i) {
			int val = 30;
			MyFunction2 f = () -> {
				//람다식 내에서 참조하는 지역변수는 final 이 붙지 않아도 상수로 간주된다.
				// 람다식 내에서 지역변수 val 과 i를 참조하고 있으므로 람다식 내에서나 다른 어느곳에서도 이 변수들의 값을 변경하는 일은 허용되지 않는다.
				// 반면에 Inner 클래스와 Outer 클래스의 인스턴스 변수인 hits.val 과 Outer.this.val 은 상수로 간주되지 않으므로 값을 변경할 수 있다.
				this.val = 333333;
				LambdaEx2.this.val = 222222;
				System.out.println("i : " + i); // 매개변수로 들어온 지역변수 변경 불가능 : final 취급
				System.out.println("val : " + val); // 메소드 내의 지역변수 val 변경 불가능 : fianl 취급
				System.out.println("this.val : " + ++this.val); // 클래스의 인스턴스 변수는 값 변경 가능
				System.out.println("Outer.this.val : "+ ++LambdaEx2.this.val); // Outer 클래스의 인스턴스 변수는 값 변경 가능
			};
			f.myMethod();
		}
	}

	@Test
	public void test2() {
		LambdaEx2 f = new LambdaEx2();
		Inner i = new Inner();
		i.method(100);
	}
}
