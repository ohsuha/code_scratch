package test.synchronizedtest;

public class Contributor extends Thread{
	private Contribution myContribution;
	private String myName;

	public Contributor(Contribution contribution, String myName){
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
