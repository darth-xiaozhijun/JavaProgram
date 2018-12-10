package com.collection;

/**
 * 自定义ArrayList，实现基本功能
 * @author Administrator
 *
 */
public class MyArrayList<E> {

	private Object[] elementData;
	
	private int size;
	
	private static final int DEFAULT_CAPACITY = 10;
	
	public MyArrayList(){
		elementData = new Object[DEFAULT_CAPACITY];
	}
	
	public MyArrayList(int capacity){
		
		if(capacity <= 0){
			throw new RuntimeException("容器的容量错误:"+capacity);
		}else {
			elementData = new Object[capacity];
		}
		
	}
	
	public void add(E object){
		
		//数组扩容
		if(size == elementData.length){
			
			Object[] newArray = new Object[elementData.length + (elementData.length>>1)];
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			elementData = newArray;
		}
		elementData[size++] = object;
	}
	
	public void checkRange(int index){
		
		if(index<0 || index>size-1){
			throw new RuntimeException("索引越界："+index);
		}
	}
	
	public E get(int index){
		
		checkRange(index);
		return (E) elementData[index];
	}
	
	public void set(E e,int index){
		checkRange(index);
		elementData[index] = e;
	}
	
	public void remove(int index){
		checkRange(index);
		int numberMoved = size - index -1;
		if(index > 0){
			System.arraycopy(elementData, index+1, elementData, index, numberMoved);
		}
		elementData[--size] = null;
	}
	
	public void remove(E e){
		
		for (int i=0; i<size; i++) {
			if(e.equals(elementData[i])){
				remove(i);
			}
		}
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size==0?true:false;
	}
	
	@Override
	public String toString() {
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		for(int i=0; i<size; i++){
			stringBuilder.append(elementData[i] + ",");
		}
		stringBuilder.setCharAt(stringBuilder.length() -1 , ']');
		
		return stringBuilder.toString();
	}
	
	public static void main(String[] args) {
		
		MyArrayList<String> arrayList = new MyArrayList<>(20);
//		arrayList.add("AA");
//		arrayList.add("BB");
		
		for(int i=0; i<40; i++){
			arrayList.add("gao"+i);
		}
		
		System.out.println(arrayList);
		System.out.println(arrayList.size);
		
		arrayList.remove(3);
		System.out.println(arrayList);
		System.out.println(arrayList.size);
		
		arrayList.remove("gao10");
		System.out.println(arrayList);
		System.out.println(arrayList.size);
		
		System.out.println(arrayList.isEmpty());
		System.out.println(arrayList.size());
	}
}
