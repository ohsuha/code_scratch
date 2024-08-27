package collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListTest {

	@Test
	public void test1() {
		ArrayList list1 = new ArrayList(10);

		list1.add(5);
		list1.add(4);
		list1.add(2);
		list1.add(0);
		list1.add(1);
		list1.add(3);
		log.info(list1.toString());

		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		log.info(list2.toString());

		Collections.sort(list1);
		Collections.sort(list2);

		log.info(list1.toString());
		log.info(list2.toString());
		log.info("list1 size {} ", list1.size());
		list1.trimToSize();
		//내부 배열이 실제 요소 수보다 더 큰 경우, 배열의 크기를 현재 요소의 수에 딱 맞도록 줄여서 불필요한 메모리 사용을 줄입니다.
		log.info("list1 size trim {} ", list1.size());
		list1.ensureCapacity(10);
		//ArrayList의 용량을 주어진 minCapacity 값 이상으로 증가시켜서, ArrayList가 최소한 그만큼의 요소를 저장할 수 있도록 준비
		//이 예시에서 ensureCapacity(100)을 호출하면, ArrayList는 내부 배열의 크기를 최소 100으로 설정합니다. 이후 100개의 요소를 추가할 때, 배열 크기를 늘리기 위해 다시 할당하는 과정을 생략할 수 있습니다.
		//ArrayList에 많은 요소를 추가할 계획이 있을 때, 미리 충분한 용량을 확보함으로써 배열 크기를 반복적으로 늘리는 작업을 줄일 수 있습니다. 이렇게 하면 성능이 향상됩니다.
		log.info("list1 size  {} ", list1.size());

		list2.add("B");
		list2.add("C");
		list2.add("D");

		list2.set(3, "AA");
		log.info("list retain : {}", list1.retainAll(list2)); //겹치는 부분을 제외하고 삭제한다.
		log.info("list 1 : {}", list1);
		log.info("list 2 : {}", list2.toString());
	}

	@Test
	public void test2() {
		final int LIMIT = 10;
		String source = "0123456789abcdefghijklmnop!@#$%^&*";
		int length = source.length();

		List list = new ArrayList<>(length / LIMIT + 10);

		for (int i = 0; i < length; i += LIMIT) {
			if(i+LIMIT < length) {
				list.add(source.substring(i, i+LIMIT));
			} else {
				list.add(source.substring(i));
			}
		}

		for(int i=0; i < list.size(); i++) {
			log.info(list.get(i).toString());
		}

	}

	@Test
	public void test3() {
		Vector vector = new Vector(10);
		vector.add("A");
		vector.add("B");
		vector.add("C");
		print(vector);

		vector.trimToSize();
		print(vector);

		vector.setSize(100);
		print(vector);

		vector.clear();
		print(vector);
	}

	private void print(Vector vector) {
		log.info(vector.toString());
		log.info("size : {}", vector.size());
		log.info("capacity : {}", vector.capacity());
	}

	@Test
	public void test4() {
		List list = new LinkedList();
		list.add("A");
		list.add("B");
		list.add("C");

	}
}
