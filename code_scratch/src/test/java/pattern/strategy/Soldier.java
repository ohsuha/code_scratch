package pattern.strategy;

// 전략을 사용할 컨텍스트
public class Soldier {
	public void runContext(Strategy strategy) {
		System.out.println("전투 시작");
		strategy.runStrategy();
		System.out.println("전투 종료");
	}
}
