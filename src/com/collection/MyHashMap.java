package com.collection;

/**
 * 自己实现一个hashmap
 * @author Administrator
 *
 */
public class MyHashMap<K,V> {

	HashMapNode[] table;//位桶
	
	int size;//大小
	
	public MyHashMap(){
		table = new HashMapNode[16];
	}

	/**
	 * 返回hash值
	 * @param v
	 * @param length
	 * @return
	 */
	public int getHash(int v,int length){
		
//		System.out.println("hasd1:" + (v&(length-1)));
//		System.out.println("hash2:" + (v%(length-1)));
		
		return v&(length-1);
	}
	
	public void put(K key,V value){
		
		HashMapNode hashMapNode = new HashMapNode();
		hashMapNode.hash = getHash(key.hashCode(), table.length);
		hashMapNode.key = key;
		hashMapNode.value = value;
		hashMapNode.next = null;
		
		HashMapNode lastNode = new HashMapNode();
		boolean isNodeRepeat = false;
		HashMapNode mapNode = table[hashMapNode.hash];
		if(mapNode == null){
			
			table[hashMapNode.hash] = hashMapNode;
			size++;
			
		}else{
			
			while(mapNode!=null){
				
				if(mapNode.key.equals(key)){

					isNodeRepeat = true;
					mapNode.value = value;
					break;
					
				}else{
					
					lastNode = mapNode;
					mapNode = mapNode.next;
					
				}
			}
			
			//没有发生key重复的情况，则添加到链表最后
			if(!isNodeRepeat){
				lastNode.next = hashMapNode;
				size++;
			}
			
		}
	}
	
	@Override
	public String toString() {
		
		StringBuilder stringBuilder = new StringBuilder("{");
		
		//循环数组
		for(int i=0; i<table.length; i++){
			
			//循环链表
			HashMapNode hashMapNode = table[i];
			while (hashMapNode != null) {
				
				stringBuilder.append(hashMapNode.key+":"+hashMapNode.value+",");
				hashMapNode = hashMapNode.next;
			}
		}
		
		stringBuilder.setCharAt(stringBuilder.length()-1, '}');
		return stringBuilder.toString();
	}
	
	public V get(K key){
		
		V value = null;
		Integer hash = getHash(key.hashCode(), table.length);
		
		HashMapNode hashMapNode = table[hash];
		
		while(hashMapNode != null){
			
			if(key.equals(hashMapNode.key)){
				value = (V) hashMapNode.value;
				break;
			}else{
				hashMapNode = hashMapNode.next;
			}
		}
		
		return value;
	}
	
	public static void main(String[] args) {
		
		MyHashMap<Integer,String> myHashMap = new MyHashMap<>();
		myHashMap.put(10, "aa");
		myHashMap.put(20, "bb");
		myHashMap.put(30, "cc");
		myHashMap.put(30, "ssss");
		
		myHashMap.put(53, "gg");
		myHashMap.put(69, "hh");
		myHashMap.put(85, "kk");
		
		System.out.println(myHashMap);
		System.out.println(myHashMap.get(69));
		System.out.println(myHashMap.size);
	}
	
}
