package com.collection;

import java.util.Map;
import java.util.TreeMap;

public class TestTreeMap {

	public static void main(String[] args) {
		
		Map<Integer, String> treeMap = new TreeMap<>();
		treeMap.put(20, "aa");
		treeMap.put(6, "bb");
		treeMap.put(5, "cc");
		
		for (Integer key : treeMap.keySet()) {
			
			System.out.println(key+"----"+treeMap.get(key));
		}
		
		Map<Emp,String>  treemap2 = new TreeMap<>();
		treemap2.put(new Emp(100,"张三",50000), "张三是一个好小伙");
		treemap2.put(new Emp(200,"李四",5000), "李四工作不积极");
		treemap2.put(new Emp(150,"王五",6000), "王五工作还不错");
		treemap2.put(new Emp(50,"赵六",6000), "赵六是个开心果");
		
		//按照key递增的方式排序
		for(Emp  key:treemap2.keySet()){
			System.out.println(key+"---"+treemap2.get(key)); 
		}	
	}
}

class Emp implements Comparable<Emp>{
	
	int id;
	String name;
	double salary;
	
	public Emp(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Emp o) {
		
		if(this.salary > o.salary){
			
			return 1;
			
		}else if(this.salary < o.salary){
			
			return -1;
		
		}else{
			
			if(this.id > o.id){
				
				return 1;
				
			}else if(this.id < o.id){
				
				return -1;
				
			}else {
				
				return 0;
			
			}
		}
	}
	
	
}