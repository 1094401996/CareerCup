package fourdot3;
/**
 * Given a sorted (increasing order) array, write an algorithmto create a binary search tree with minimal height.
 * 
 *递归的认识还是不到位，对这种思维还不习惯，希望通过大量做题能够解决这个问题
 *通过递归每次取中间的那个，形式上和快排有点类似。。。。
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import binarytree.BinaryTree;
import binarytree.Node;

public class MinHeightTree {

	
	public static void main(String[] args) {
	    	int [] data = {1,2,3,4,5};
	    	BinaryTree mytree = new BinaryTree(data,true);
	    	//the implementation is in the BinaryTree.java
	    	mytree.preorder(mytree.getRoot());
	    	System.out.println();
	    	mytree.postorder(mytree.getRoot());
	    	System.out.println();
	    	mytree.levelorder(mytree.getRoot());

	}

}
