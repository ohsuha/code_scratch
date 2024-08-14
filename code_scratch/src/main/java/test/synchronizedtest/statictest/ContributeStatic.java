package test.synchronizedtest.statictest;

public class ContributeStatic {
	public void contributeStatic() {
		ContributorStatic[] contributors = new ContributorStatic[10];

		for (int i = 0; i < 10; i++) {
			ContributionStatic contribution = new ContributionStatic();
			contributors[i] = new ContributorStatic(contribution, " Contributor static" + i);
		}

		for (int i = 0; i < 10; i++) {
			contributors[i].start();
		}
	}
}
