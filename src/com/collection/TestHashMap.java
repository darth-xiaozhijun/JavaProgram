package com.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试HashMap的使用
 * @author Administrator
 *
 */
public class TestHashMap {

	public static void main(String[] args) {
		
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		
		System.out.println(map.get(1));
		System.out.println(map.size());
		System.out.println(map.isEmpty());
		System.out.println(map.containsKey(1));
		System.out.println(map.containsValue("four"));
		
		Map<Integer, String> map2 = new HashMap<>();
		map2.put(4, "四");
		map2.put(5, "五");
		
		map.putAll(map2);
		System.out.println(map);
		
		map.put(3, "三");
		System.out.println(map);
		
		Employee employee = new Employee(1001, "小小", "3000");
		Employee employee2 = new Employee(1002, "李二", "4500");
		Employee employee3 = new Employee(1003, "王五", "40000");
		
		Map<Integer, Employee> map3 = new HashMap<>();
		map3.put(1001, employee);
		map3.put(1002, employee2);
		map3.put(1003, employee3);
		
		Employee employee4 = map3.get(1001);
		System.out.println(employee4.getEname());
	}
}
class Employee{
	
	private Integer id;
	private String ename;
	private String salary;
	
	public Employee(Integer id, String ename, String salary) {
		super();
		this.id = id;
		this.ename = ename;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
	
}
