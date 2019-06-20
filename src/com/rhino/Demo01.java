package com.rhino;

import java.io.FileReader;
import java.io.Reader;
import java.net.URL;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Demo01 {

	public static void main(String[] args) throws Exception {
		
		//获得脚本引擎
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine se = sem.getEngineByName("javascript");
		
		//定义变量
		se.put("msg", "张三是一个好人");
		String str  = "var user = {name:'张三',age:18,schools:['清华大学','北京尚学堂']};";
		str += "print(user.name);";
		
		se.eval(str);
		se.eval("msg = '清华是一所好学校'");
		System.out.println(se.get("msg"));
		System.out.println("########################");
		
		// 定义函数
		se.eval("function add (a, b) {var sum = a + b; return sum; }");
		// 取得调用接口
		Invocable jsInvoke = (Invocable) se;
		//执行脚本中定义的方法
		Object object = jsInvoke.invokeFunction("add", new Object[]{13,20});
		System.out.println(object);
		
		// 导入其他java包,使用其他包中的java类
		String jsCode = "var list = java.util.Arrays.asList([\"江西财经大学\",\"清华大学\",\"北京大学\"]); ";
		se.eval(jsCode);
		List<String> list2 = (List<String>) se.get("list");
		for (String temp : list2) {
			System.out.println(temp);
		}
		
		//执行一个js文件(我们将a.js至于项目的src下即可)
		URL is = Demo01.class.getClassLoader().getResource("a.js");
		Reader r = new FileReader(is.getPath());
		se.eval(r);
	}
}
