package fourdot4;
/**
 * Given a binary tree, design an algorithm which creates a linked 
 * list of all the nodes at each depth (e.g., if you have a tree with depthD, you’ll have D linked lists).
 * 
 * 方法： 本质上是变形的层次遍历。。。。树的坑好深 给递归跪了。。。。
 */

import java.util.Iterator;
import java.util.LinkedList;

import binarytree.BinaryTree;
import binarytree.Node;

public class LinkedTree {
	public static void main(String[] args){
		int [] data1 = {1,3,2,5,4,8,6};
		BinaryTree mytree1 = new BinaryTree(data1);
		mytree1.levelorder(mytree1.getRoot());
		LinkedList[] array =mytree1.linlkedTree(mytree1.getRoot());
		for(int i= 0; i < array.length; i++){
			LinkedList temp = array[i];
			Iterator it = temp.iterator();
			while(it.hasNext()){
				System.out.print(((Node)it.next()).getElement() + " ");
			}
			System.out.println();
		}
	}
}
