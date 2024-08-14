package test.synchronizedtest;

public class Contribute {
	public void contribute() {
		Contributor[] contributors = new Contributor[10];
		Contribution contribution = new Contribution();

		for (int i = 0; i < 10; i++) {
			contributors[i] = new Contributor(contribution, " Contributor" + i);
		}

		for (int i = 0; i < 10; i++) {
			contributors[i].start();
		}
	}
}
