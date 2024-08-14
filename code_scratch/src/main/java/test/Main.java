package test;

import test.synchronizedtest.Contribute;
import test.synchronizedtest.statictest.ContributeStatic;

public class Main {
	public static void main(String[] args) {
		Contribute contribute = new Contribute();
		contribute.contribute();

		ContributeStatic contributeStatic = new ContributeStatic();
		contributeStatic.contributeStatic();
	}
}
