package execise.instance;

/**
 * 使用双重检查进一步做了优化，可以避免整个方法被锁，只对需要锁的代码部分加锁，可以提高执行效率。
 * @author Administrator
 *
 */
public class SingleInstance4 {
	
	private static SingleInstance4 singleInstance4 = null;
	
	private SingleInstance4(){}
	
	public SingleInstance4 getSingleInstance4(){
		
		if(singleInstance4 == null){
			
			synchronized (SingleInstance4.class) {
				if(singleInstance4 == null){
					singleInstance4 = new SingleInstance4();
				}
			}
		}
		
		return singleInstance4;
	}

}
