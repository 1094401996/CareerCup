package fourdot7;
/**CareerCup 4.7
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. 
 * Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
 * 觉得自己的智力已经没救了。。。。。。。答案的第二种方法看不懂了。。。。。。。。。。。
 * 
 */

import binarytree.BinaryTree;
import binarytree.Node;

public class CommonAncestor {
	public static void main(String[]args){
		int [] data1 = {1,3,2,5,4,8,6};
    	BinaryTree mytree1 = new BinaryTree(data1);
    	Node p = mytree1.findNode(2);
    	Node q = mytree1.findNode(6);
    	Node ancester = mytree1.lowestCommonAncester(mytree1.getRoot(), p, q);
    	System.out.println(ancester.getElement());
	}
}
