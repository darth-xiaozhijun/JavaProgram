package com.collection;

/**
 * 自定义链表
 * @author Administrator
 *
 */
public class MyLinkedList {

	Node first;
	Node last;
	
	int size;
	
	public void add(Object object){
		
		Node node = new Node(object);
		
		if(first == null){
			
			node.previous = null;
			node.next = null;
			
			first = node;
			last = node;
			
		}else {
			node.previous = last;
			node.next = null;
			
			last.next = node;
			last = node;
		}
	}
	
	@Override
	public String toString() {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		
		Node temp = first;
		while(temp != null) {
			stringBuilder.append(temp.element+",");
			temp = temp.next;
		}
		
		stringBuilder.setCharAt(stringBuilder.length()-1,']');
		
		return stringBuilder.toString();
	}
	
	public static void main(String[] args) {
		
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.add("a");
		linkedList.add("b");
		linkedList.add("c");
		
		System.out.println(linkedList.toString());
	}
}
