package pattern.tempaltemethod;

public abstract class Animal {
	public void playWithOwner() {
		System.out.println("귀염둥이 이리온~");
		play();
		runSomething();
		System.out.println("잘했어~!~!~!~!");
	}

	public abstract void play();

	protected void runSomething() {
		System.out.println("꼬리를 흔든다");
	}

}
