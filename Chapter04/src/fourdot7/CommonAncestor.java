package fourdot7;
/**CareerCup 4.7
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. 
 * Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
 * 觉得自己的智力已经没救了。。。。。。。答案的第二种方法看不懂了。。。。。。。。。。。
 * 
 * 2013.3.26
 * 心得体会：这个一道经典的题目，首先要搞清楚树是binary tree or binary search tree
 * 第二种方法每次不用重复扫描树，但是很坑爹的是它相当于从递归底层慢慢冒起。。。。。对于本屌的智力来说考验很大。。。。
 */

import binarytree.BinaryTree;
import binarytree.Node;

public class CommonAncestor {
	public static void main(String[]args){
    	int [] pre = {7,10,4,3,1,2,8,11};
		int [] in = {4,10,3,1,7,11,8,2};
		BinaryTree bt = new BinaryTree();
		bt.reConstruct(pre, in);
		Node p = bt.findNode(1);
		Node q = bt.findNode(4);
		System.out.println(bt.lowestCommonAncester1(p, q).getElement());
		System.out.println(bt.lowestCommonAncester2(p, q).getElement());
		
		
//		int [] data1 = {1,3,2,5,4,8,6};
//    	BinaryTree bt = new BinaryTree(data1);
//    	Node p =  bt.findNode(2);
//    	Node q =  bt.findNode(6);
//		System.out.println(bt.lowestCommonAncester1(p, q).getElement());
		
	}
}
