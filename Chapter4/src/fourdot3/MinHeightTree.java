package fourdot3;
/**
 * 2.23： 递归的认识还是不到位，对这种思维还不习惯，希望通过大量做题能够解决这个问题
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
	    	
	    	ArrayList al = mytree.linlkedTree(mytree.getRoot());
	    	for (LinkedList ll : al){
	    		
	    		 
	    		 
	    	}
	    	mytree.levelorder(mytree.getRoot());
	    	mytree.preorder(mytree.getRoot());

	}

}