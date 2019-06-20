package com.gof.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * 反射和反序列化破解单例模式
 * @author xiaozhijun
 *
 */
public class ReflectionClient {

	public static void main(String[] args) {
		
		ReflectionLazySingleton reflectionLazySingleton = ReflectionLazySingleton.getInstance();
		
		ReflectionLazySingleton reflectionLazySingleton2 = ReflectionLazySingleton.getInstance();
		
		System.out.println(reflectionLazySingleton);
		System.out.println(reflectionLazySingleton2);
		
		try {
			
			//通过反射的方式直接调用私有构造器
			/*Class<ReflectionLazySingleton> clazz = (Class<ReflectionLazySingleton>) Class.forName("com.gof.singleton.ReflectionLazySingleton");
			Constructor<ReflectionLazySingleton> constructor = clazz.getDeclaredConstructor(null);
			
			constructor.setAccessible(true);
			
			ReflectionLazySingleton reflectionLazySingleton3 = constructor.newInstance();
			ReflectionLazySingleton reflectionLazySingleton4 = constructor.newInstance();
			
			System.out.println(reflectionLazySingleton3);
			System.out.println(reflectionLazySingleton4);*/
			
			//通过反序列化的方式构造多个对象
			FileOutputStream fos = new FileOutputStream(new File("c:/A/a.txt"));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(reflectionLazySingleton);
			oos.close();
			fos.close();
			
			FileInputStream fis = new FileInputStream(new File("c:/A/a.txt"));
			ObjectInputStream ois = new ObjectInputStream(fis);
			ReflectionLazySingleton reflectionLazySingleton5 = (ReflectionLazySingleton) ois.readObject();
			System.out.println(reflectionLazySingleton5);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
