package com.collection;

import java.util.Scanner;

public class TestBinaryTree {

	private TestBinaryTree left,right;
    private char data;
    public TestBinaryTree creat(String des){
        Scanner scanner=new Scanner(System.in);
        System.out.println("des:"+des);
        String str=scanner.next();
        if(str.charAt(0)<'a')return null;
        TestBinaryTree root=new TestBinaryTree();
        root.data=str.charAt(0);
        root.left=creat(str.charAt(0)+"左子树");
        root.right=creat(str.charAt(0)+"右子树");
        return root;
    }
    public void midprint(TestBinaryTree btree){
//        中序遍历
        if(btree!=null){
            midprint(btree.left);
            System.out.print(btree.data+"  ");
            midprint(btree.right);
        }
    }
    public void firprint(TestBinaryTree btree){
//        先序遍历
        if(btree!=null){
            System.out.print(btree.data+" ");
            firprint(btree.left);
            firprint(btree.right);
        }
    }
    public void lastprint(TestBinaryTree btree){
//        后序遍历
        if(btree!=null){
            lastprint(btree.left);
            lastprint(btree.right);
            System.out.print(btree.data+"  ");
        }
    }
    public static void main(String[] args) {
    	TestBinaryTree tree = new TestBinaryTree();
    	TestBinaryTree newtree=tree.creat("根节点");
        tree.firprint(newtree);
        System.out.println();
        tree.midprint(newtree);
        System.out.println();
        tree.lastprint(newtree);
    	
    	int i = 1;
    	int j = i++;
    	if((i==(++j)) &&((i++) == j) ){
    		i += j;
    	}
    	System.out.println(i);
    	
    	System.out.println(""+10+20.2*10L);
    	System.out.println((char)68);
    	
    	System.out.println(Math.round(-15.61));
    }
    

}
