package pattern.factorymethod;

// 팩터리 메서드가 생성할 객체
public class DogToy extends AnimalToy{
	@Override
	public void identify() {
		System.out.println("멍멍 강아지 장난감");
	}
}
