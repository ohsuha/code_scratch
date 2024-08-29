package collection.set;

import java.util.Objects;

public class Person {
	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public boolean equals(Object o) {
		if (o instanceof Person) {
			Person p = (Person)o;
			return name.equals(p.name) && age == p.age;
		}
		return false;
	}

	public int hashCode() {
		//return (name + age).hashCode();
		// 1.8 부터 추가된 기능
		return Objects.hash(name, age);
	}

	public String toString() {
		return name + ":" + age;
	}

}
