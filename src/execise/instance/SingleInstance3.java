package execise.instance;

/**
 * 在方法上加synchronized同步锁或是用同步代码块对类加同步锁，
 * 此种方式虽然解决了多个实例对象问题，但是该方式运行效率却很低下，
 * 下一个线程想要获取对象，就必须等待上一个线程释放锁之后，才可以继续运行。
 * @author Administrator
 *
 */
public class SingleInstance3 {

	private static SingleInstance3 singleInstance3 = null;
	
	private SingleInstance3(){}
	
	public static SingleInstance3 getSingleInstance3(){
		
		synchronized (SingleInstance3.class) {
			if(singleInstance3 == null){
				singleInstance3 = new SingleInstance3();
			}
		}
		
		return singleInstance3;
	}
}
