package pattern.factorymethod;

public class Dog extends Animal{
	@Override
	public AnimalToy getToy() {
		return new DogToy();
	}
}
