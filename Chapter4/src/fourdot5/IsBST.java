package fourdot5;

import binarytree.BinaryTree;

public class IsBST {
	public static void main(String[] args){
		int [] data1 = {1,3,2,5,4,8,6};
		BinaryTree mytree1 = new BinaryTree(data1);
		mytree1.setRoot(8);
		System.out.println(mytree1.isBST());
		
	}

}
