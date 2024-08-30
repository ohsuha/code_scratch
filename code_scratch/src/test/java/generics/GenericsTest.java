package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import generics.Box.Box;
import generics.Box.FruitBox;
import generics.fruit.Apple;
import generics.fruit.Fruit;
import generics.fruit.Grape;
import generics.juice.Juicer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenericsTest {
	@Test
	@DisplayName("Generics test")
	public void generics01() {
		Box<String> box = new Box<>();
		box.setItem("ABC");
		String item = box.getItem();
		// 지네릭스가 없을때는 모두 item 이 object 여서 캐스팅을 해줘야 했다.
		// String item = (String) box.getItem();

		Box box1 = new Box<>();
		box1.setItem(new Object());
		box1.setItem("EDF");
		// 이전 코드와 호환을 위해 위와 같은 생성 방식도 가능하지만 unchecked warning 이 발생한다.
	}

	@Test
	@DisplayName("generic test2")
	public void generics02() {
		FruitBox<Fruit> fruitBox = new FruitBox<>();
		FruitBox<Apple> appleBox = new FruitBox<>();
		;

		fruitBox.add(new Grape());
		fruitBox.add(new Fruit());

		appleBox.add(new Apple());
		appleBox.add(new Apple());

		log.info(Juicer.makeJuice(fruitBox).toString());
		log.info(Juicer.makeJuice(appleBox).toString());
	}

	@Test
	public void generics03() {
		String[] strings = createArray(String.class, 10);
		String[] stirngs1 = {"a", "b", "c", "d"};
		strings = stirngs1;
		Integer[] integers = createArray(Integer.class, 10);
		// integers = stirngs2; //에러

		String[] strings2 = createArray2(String.class, 10);
		Integer[] integers1 = createArray(Integer.class, 10);

	}

	public <T> T[] createArray(Class<T> clazz, int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[])java.lang.reflect.Array.newInstance(clazz, size);
		return array;
	}

	public <T> String[] createArray2(Class<T> clazz, int size) {
		@SuppressWarnings("unchecked")
		String[] array = (String[])java.lang.reflect.Array.newInstance(clazz, size);
		return array;
	}

	public <T> T test4() {
		String[] strings = new String[10];
		T[] arrays = (T[])new String[10];
		return arrays[0];
	}

	@Test
	public void test5() {
        Integer[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"Hello", "World"};

        // <String>printArray(strArray);
        printArray(strArray);

        // <Integer>printArray(intArray);
        printArray(intArray);

        int key = 1;
        String value = "ABC";
        print(key, value);
	}

    public <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    public <T,E> void print(T t, E e) {
        HashMap map = new HashMap();
        map.put(t, e);
        System.out.println(map);
    }
}
