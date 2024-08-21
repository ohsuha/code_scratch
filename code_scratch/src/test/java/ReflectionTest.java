import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import generics.juice.Juice;

@Slf4j
public class ReflectionTest {

	@SneakyThrows
	@Test
	void reflectionTest () {
		// refelction 을 사용하면 접근 제어자와 무관하게 클래스의 필드나 메소드도 가져와서 호출 할 수 있다.

		// 1. 클래스 객체 획득
		Class<String> stringClass = String.class;
		Class<Juice> juiceClass = Juice.class;
		log.info("1-1 : {}", stringClass.getName());
		log.info("1-2 : {}", juiceClass.getName());

		Juice juice = new Juice("오렌지");
		Class<? extends Juice> aClass = juice.getClass();
		log.info("1-3 : {}", aClass.getName());

		try {
			Class<?> aClass1 = Class.forName("java.lang.String");
			log.info("1-4 : {}", aClass1.getName());
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		// 2. getXXX : 상속받은 클래스와 인터페이스를 포함하여 모든 public 요소를 가져온다.
		Class<ArrayList> arrayListClass = ArrayList.class;
		for (Method method : arrayListClass.getMethods()) {
			log.info("2-1 : {}", method.getName());
		}

		// 3. getDeclaredXXX : 상속받은 클래스와 인터페이스를 제외하고 해당 클래스에 직접 정의된 내용만 가져온다.
		// 클래스에만 직접 정의된 private, protected, public 메소드를 전부 가져온다.
		Class<ArrayList> arrayListClassDeclare = ArrayList.class;
		for (Method method : arrayListClassDeclare.getDeclaredMethods()) {
			log.info("3-1 : {}", method.getName());
		}

		// 4. Constructor 를 통해 생성자에 직접 접근해서 객체를 생성할 수 있다.
		try {
			Constructor<?> constructor = stringClass.getDeclaredConstructor(String.class);
			Object object = constructor.newInstance("new instance test");
			String string = (String) constructor.newInstance("casting test");
			log.info("4-1 : {} , {}", object, string);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}

		try {
			Constructor<Juice> declaredConstructor = juiceClass.getDeclaredConstructor();
			declaredConstructor.setAccessible(true);
			Juice juice1 = declaredConstructor.newInstance();
			log.info("4-2 : {}", juice1.getClass().getName());
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}


		// 5. filed 에 접근하고 값 변경하기
		Field quantityField = juiceClass.getDeclaredField("quantity");
		quantityField.setAccessible(true);
		quantityField.set(juice, 10);

		for (Field field : juiceClass.getDeclaredFields()) {
			field.setAccessible(true);
			log.info("5-1 : type : {} / name : {} / value : {}", field.getType(), field.getName(), field.get(juice));
		}

		// 6. method 가져오고 실행하기
		Method juiceMethod = (Method)juiceClass.getDeclaredMethod("getJuice");
		juiceMethod.invoke(juice);
	}
}
