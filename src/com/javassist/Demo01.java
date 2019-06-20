package com.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;

public class Demo01 {

	public static void main(String[] args) throws Exception {
		
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.makeClass("com.javassist.Emp");
		
		//创建属性
		CtField cf1 = CtField.make("private int empno;", cc);
		CtField cf2 = CtField.make("private String ename;", cc);
		cc.addField(cf1);
		cc.addField(cf2);
		
		//创建方法
		CtMethod cm1 = CtMethod.make("public int getEmpno(){return empno;}", cc);
		CtMethod cm2 = CtMethod.make("public void setEmpno(int empno){this.empno=empno;}", cc);
		cc.addMethod(cm1);
		cc.addMethod(cm2);
		
		//添加构造器
		CtConstructor ctConstructor = new CtConstructor(
				new CtClass[]{CtClass.intType,pool.get("java.lang.String")}, cc);
		ctConstructor.setBody("{this.empno=empno; this.ename=ename;}");
		cc.addConstructor(ctConstructor);
		
		cc.writeFile("D:/workspace/");
		System.out.println("生成类，成功！");
	}
}
