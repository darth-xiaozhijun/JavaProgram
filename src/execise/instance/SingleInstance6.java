package execise.instance;

/**
 * static静态代码块实现
 * @author Administrator
 *
 */
public class SingleInstance6 {

	private static SingleInstance6 singleInstance6 = null;
	
	private SingleInstance6(){}
	
	static{
		singleInstance6 = new SingleInstance6();
	}
	
	public SingleInstance6 getSingleInstance6(){
		return singleInstance6;
	}
}
