package execise.instance;

/**
 * 单例模式-饿汉式
 * 饿汉式单例在类加载初始化时就创建好一个静态的对象供外部使用，除非系统重启，这个对象不会改变，所以本身就是线程安全的。
 * @author Administrator
 *
 */
public class SingleInstance {

	private static SingleInstance singleInstance = new SingleInstance();
	
	private Integer num;
	
	private SingleInstance(){}
	
	public static SingleInstance getInstance(){
		return singleInstance;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
	
	
}
