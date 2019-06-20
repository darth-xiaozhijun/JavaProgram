package com.thread;

/**
 * Lambda表达式+返回值
 * @author Administrator
 *
 */
public class LambdaTest3 {

	//静态内部类
	static class Find2 implements IFind{

		@Override
		public int lambda(int a,int c) {
			return a + c;
		}
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(new Find().lambda(1,1));
		
		System.out.println(new Find2().lambda(2,2));
		
		//局部内部类
		class Find3 implements IFind{

			@Override
			public int lambda(int a,int c) {
				return a+c;
			}
		}
		
		System.out.println(new Find3().lambda(3, 3));
		
		//匿名内部类
		new IFind() {
			
			@Override
			public int lambda(int a, int c) {
				return a+c;
			}
		}.lambda(4,4);
		
		//lambda表达式
		IFind find = (int a,int c)->{
			return a+c;
		};
		System.out.println(find.lambda(5,5));
		
		find = (a,c)->{
			return a+c;
		};
		System.out.println(find.lambda(6,6));
		
		find = (a,c)->a+c;
		System.out.println(find.lambda(7, 7));
		
	}

}

interface IFind{
	int lambda(int a,int c);
}

class Find implements IFind{

	@Override
	public int lambda(int a,int c) {
		return a + c;
	}
	
}