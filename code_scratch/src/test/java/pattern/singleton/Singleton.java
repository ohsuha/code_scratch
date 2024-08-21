package pattern.singleton;

public class Singleton {
	public static Singleton singletonObject;

	private Singleton() {};

	public static Singleton getInstance() {
		if (singletonObject == null) {
			singletonObject = new Singleton();
		}

		return singletonObject;
	}
}
