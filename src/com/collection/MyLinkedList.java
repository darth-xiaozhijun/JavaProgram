package com.collection;

/**
 * 自定义链表
 * @author Administrator
 *
 */
public class MyLinkedList {

	private Node first;
	private Node last;
	
	private int size;
	
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
		
		size++;
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
	
	public Object get(int index){
		
		if(index<0 || index>size-1){
			throw new RuntimeException("索引越界："+index);
		}
		
		Node temp = getNode(index);
		
		return temp!=null?temp.element:null;

	}
	
	public Node getNode(int index){
		
		Node temp = null;
		
		if(index<=(size>>1)){ //size>>1相当于除以2
			
			temp = first;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
			
		}else{
			temp = last;
			for (int i = size-1; i > index; i--) {
				temp = temp.previous;
			}
		}
		
		return temp;
	}
	
	public void remove(int index){
		
		Node temp = getNode(index);
		if(temp != null){
			
			Node up = temp.previous;
			Node down = temp.next;
			
			if(up !=null){
				up.next = down;
			}
			if(down != null){
				down.previous = up;
			}
			if(index == 0){
				first = down;
			}
			if(index == size-1){
				last = up;
			}
			
			size--;
		}
	}
	
	public void add(int index,Object object){
		
		Node newNode = new Node(object);
		Node temp = getNode(index);
		
		if(temp != null){
			
			if(index == 0){
				
				newNode.previous = null;
				
				newNode.next = temp;
				temp.previous = newNode;
				
				first = newNode;
			
			}else if(index == size-1){
				
				newNode.next = null;
				
				temp.next = newNode;
				newNode.previous = temp;
				
				last = newNode;
			
			}else{
				
				Node up = temp.previous;
				
				up.next = newNode;
				newNode.previous = up;
				
				newNode.next = temp;
				temp.previous = newNode;
				
			}
			
			size++;
		}
	}
	
	public static void main(String[] args) {
		
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.add("a");
		linkedList.add("b");
		linkedList.add("c");
		linkedList.add("d");
		linkedList.add("e");
		linkedList.add("f");
		
		System.out.println(linkedList.toString());
//		System.out.println(linkedList.get(0));
//		System.out.println(linkedList.get(2));
//		System.out.println(linkedList.get(6));
//		System.out.println(linkedList.get(5));
		
		linkedList.remove(1);
		System.out.println(linkedList);
		linkedList.remove(0);
		System.out.println(linkedList);
		linkedList.remove(3);
		System.out.println(linkedList);
		System.out.println(linkedList.size);
		linkedList.add(1, "li");
		System.out.println(linkedList);
		System.out.println(linkedList.size);
		linkedList.add(0, "le");
		System.out.println(linkedList);
		System.out.println(linkedList.size);
		linkedList.add(4, "lo");
		System.out.println(linkedList);
		System.out.println(linkedList.size);
	}
}
