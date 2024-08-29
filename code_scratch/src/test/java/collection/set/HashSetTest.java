package collection.set;

import java.util.HashSet;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HashSetTest {
	@Test
	public void test() {
		Person person1 = new Person("aaa", 20);
		Person person2 = new Person("bbb", 30);
		Person person3 = new Person("aaa", 20);

		log.info("1 : 2 = {}", person1.equals(person2));
		log.info("1 : 3 = {}", person1.equals(person3));

		log.info("hash code : {}", person1.hashCode());
		log.info("hash code : {}", person2.hashCode());
		log.info("hash code : {}", person3.hashCode());
	}

	@Test
	public void test2() {
		HashSet setA = new HashSet();		HashSet setB = new HashSet();
		HashSet setHab = new HashSet();		HashSet setKyo = new HashSet();
		HashSet setCha =  new HashSet();

		setA.add("1");		setA.add("2");		setA.add("3");		setA.add("4");		setA.add("5");
		log.info("setA = {}", setA);

		setB.add("4");		setB.add("5");		setB.add("6");		setB.add("7");		setB.add("8");
		log.info("setB = {}", setB);

		Iterator it = setB.iterator();
		while (it.hasNext()) {
			Object o = it.next();
			if (setA.contains(o)) {
				setKyo.add(o);
			}
		}

		it = setA.iterator();
		while (it.hasNext()) {
			Object o = it.next();
			if(!setB.contains(o)) {
				setCha.add(o);
			}
		}

		it = setA.iterator();
		while(it.hasNext()) {
			setHab.add(it.next());
		}

		it = setB.iterator();
		while (it.hasNext()) {
			setHab.add(it.next());
		}

		log.info("setHab = {}", setHab);
		log.info("setKyo = {}", setKyo);
		log.info("setCha = {}", setCha);

		setA.retainAll(setB);
		log.info("set retain A , B = {}", setA);

		setA.addAll(setB);
		log.info("set addAll A , B = {}", setA);

		setA.add("1");		setA.add("2");		setA.add("3");		setA.add("4");		setA.add("5");
		setA.removeAll(setB);
		log.info("set remove A , B = {}", setA);
	}
}
