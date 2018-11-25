package execise.instance;

public class SingleInstanceTest {

	public static void main(String[] args) {
		
		SingleInstance singleInstance = SingleInstance.getInstance();
		SingleInstance singleInstance2 = SingleInstance.getInstance();
		
		singleInstance.setNum(10);
		singleInstance2.setNum(20);
		
		System.out.println(singleInstance == singleInstance2);
		System.out.println(singleInstance.getNum());
		System.out.println(singleInstance2.getNum());
		
//		SingleInstance singleInstance2 = SingleInstance.singleInstance;
	}
}
