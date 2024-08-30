package collection.map;

import java.util.Enumeration;
import java.util.Properties;

import org.junit.jupiter.api.Test;

public class Property {
	@Test
	public void test() {
		Properties properties = new Properties();
		properties.setProperty("time", "30");
		properties.setProperty("name","suah");
		properties.setProperty("age","18");
		properties.setProperty("birth","0319");

		Enumeration enumeration = properties.propertyNames();

		while (enumeration.hasMoreElements()) {
			String element = (String) enumeration.nextElement();
			System.out.println(element + " : " + properties.getProperty(element));
		}

		properties.setProperty("age", "34");
		System.out.println("age = " + properties.getProperty("age"));

		System.out.println(properties);
		properties.list(System.out);
	}
}
