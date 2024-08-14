package test.synchronizedtest.statictest;

public class ContributorStatic extends Thread{
	private ContributionStatic myContribution;
	private String myName;

	public ContributorStatic(ContributionStatic contribution, String myName){
		this.myContribution = contribution;
		this.myName = myName;
	}

	@Override
	public void run() {
		for (int i = 0; i<1000; i++) {
			myContribution.donate();
		}
		System.out.format("%s totla=%d\n", myName, myContribution.getTotal());
	}
}
