package fourdot5;
/*Implement a function to check if a binary tree is a binary searchtree.
 * 好吧，自己写出递归的感觉还是不错的。。。。不过似乎方法恶心了点。。。下周再优化一下。。。
 * */

import binarytree.BinaryTree;

public class IsBST {
	public static void main(String[] args){
		int [] data1 = {1,3,2,5,4,8,6};
		BinaryTree mytree1 = new BinaryTree(data1);
		mytree1.setRoot(8);
		System.out.println(mytree1.isBST());
		
	}

}
