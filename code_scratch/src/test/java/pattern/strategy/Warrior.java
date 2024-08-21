package pattern.strategy;

public class Warrior {
	public void runContext(String weaponSound){
		System.out.println("전투 시작");
		Strategy strategy = executeWeapon(weaponSound);
		strategy.runStrategy();
		System.out.println("전투 종료");
	}

	private Strategy executeWeapon(final String weaponSound) {
		return new Strategy() {
			@Override
			public void runStrategy() {
				System.out.println(weaponSound);
			}
		};
	}
}
