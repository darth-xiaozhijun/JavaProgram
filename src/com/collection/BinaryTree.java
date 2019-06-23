package com.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树
 * @author Administrator
 *
 */
public class BinaryTree {

	public BinaryTree leftNode;//左节点
	
	public BinaryTree rightNode;//右节点
	
	public BinaryTree rootNode;//根节点
	
	private Object data;//数据域
	
	public List<BinaryTree> datas;//存节点数据

	public BinaryTree(BinaryTree leftNode, BinaryTree rightNode, Object data) {
		super();
		this.leftNode = leftNode;
		this.rightNode = rightNode;
		this.data = data;
	}

	/**
	 * 将初始的左右孩子值为空
	 * @param data
	 */
	public BinaryTree(Object data) {
		this(null, null, data);
	}

	public BinaryTree() {
		super();
	}
	
	public void creat(Object[] objs){
        datas = new ArrayList<BinaryTree>();
        //        将一个数组的值依次转换为Node节点
        for(Object o:objs){
            datas.add(new BinaryTree(o));
        }
//        第一个数为根节点
        rootNode=datas.get(0);
//        建立二叉树
        for (int i = 0; i <objs.length/2; i++) {
//            左孩子
            datas.get(i).leftNode=datas.get(i*2+1);
//            右孩子
            if(i*2+2<datas.size()){//避免偶数的时候 下标越界
                datas.get(i).rightNode=datas.get(i*2+2);
            }
        }
    }
	//先序遍历
	public void preorder(BinaryTree root){
	    if(root!=null){
	        System.out.println(root.data);
	        preorder(root.leftNode);
	        preorder(root.rightNode);
	    }
	}
	//中序遍历
	    public void inorder(BinaryTree root){
	        if(root!=null){
	            inorder(root.leftNode);
	            System.out.println(root.data);
	            inorder(root.rightNode);
	        }
	    }
	//    后序遍历
	    public void afterorder(BinaryTree root){
	        if(root!=null){
	            System.out.println(root.data);
	            afterorder(root.leftNode);
	            afterorder(root.rightNode);
	        }
	    }
	    public static void main(String[] args) {
	        BinaryTree bintree=new BinaryTree();
	        Object []a={2,4,5,7,1,6,12,32,51,22};
	        bintree.creat(a);
	        bintree.preorder(bintree.rootNode);
	    }

}
