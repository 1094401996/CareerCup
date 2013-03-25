package classical_questions_in_binarytree;

import binarytree.BinaryTree;

/**
 * http://blog.csdn.net/ssjhust123/article/details/7783935
 * @author gengchen
 * 自己写出的程序就是爽呀  ^_^
 * 根据一颗二叉树的preorder和inder重构这课树。。。。
 *
 */
public class ReconstructBinaryTree {
	public static void main(String[] args){
		int [] pre = {7,10,4,3,1,2,8,11};
		int [] in = {4,10,3,1,7,11,8,2};
		BinaryTree bt = new BinaryTree();
		bt.reConstruct(pre, in);
		bt.preorder(bt.getRoot());
		System.out.println();
		bt.inorder(bt.getRoot());
		System.out.println();
		bt.postorder(bt.getRoot());
		

		
	}

}
