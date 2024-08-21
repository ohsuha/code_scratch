package pattern.tempaltemethod;

public class Cat extends Animal {

	@Override
	public void play() {
		System.out.println("야옹");
	}

	@Override
	protected void runSomething() {
		System.out.println("그르릉 거린다.");
	}
}
