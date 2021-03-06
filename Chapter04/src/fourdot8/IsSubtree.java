package fourdot8;

/**CareerCup 4.8
 * You have two very large binary trees: T1, with millions of nodes, and T2, 
 * with hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1.
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree 
 * of n is identical to T2. That is, if you cut the tree at node n, the two trees would
 *  be identical.
 *  Method: traverse the larger tree(T1) first, if find the identical node to the root of 
 *  smaller tree(T2), then compare the subtree tO the smaller tree recursively...
 *  
 *  
 *  2013.3.26
 *  心得：很多书的问题在于遍历和递归
 */
import binarytree.BinaryTree;


public class IsSubtree {
	public static void main(String [] args){
		int [] arr1 = {1,2,3,4,5};
		BinaryTree bt1 = new BinaryTree(arr1);
		int [] arr2 = {1,2,3};
		BinaryTree bt2 = new BinaryTree(arr2);
		System.out.println(bt1.subTree(bt2));
	}
}
