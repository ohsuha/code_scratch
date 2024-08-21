package pattern.adapter;

public class AdapterServiceB {
	ServiceB serviceB = new ServiceB();
	public void runService(){
		serviceB.runServiceB();
	}
}
