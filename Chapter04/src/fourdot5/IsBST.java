package fourdot5;
/*Implement a function to check if a binary tree is a binary searchtree.
 * 好吧，自己写出递归的感觉还是不错的。。。。不过似乎方法恶心了点。。。下周再优化一下。。。
 * */

import binarytree.BinaryTree;

public class IsBST {
	public static void main(String[] args){
		//reconstruct a binary tree....
		int [] pre = {20,10,25,30};
		int [] in = {10,25,20,30};
		BinaryTree bt = new BinaryTree();
		bt.reConstruct(pre, in);
		System.out.println(bt.isBST1());
		System.out.println(bt.isBST2());
		
		
		int [] data1 = {1,3,2,5,4,8,6};
    	BinaryTree mytree1 = new BinaryTree(data1);
		System.out.println(mytree1.isBST1());
		System.out.println(mytree1.isBST2());

		
	}

}
