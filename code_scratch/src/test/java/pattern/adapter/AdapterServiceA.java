package pattern.adapter;

public class AdapterServiceA {
	ServiceA serviceA = new ServiceA();
	public void runService(){
		serviceA.runServiceA();
	}
}
