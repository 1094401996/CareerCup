package fourdot6;

import binarytree.Node;
/**CareerCup 4.6
 * Write an algorithm to find the ‘next’ node (i.e., in-order successor) of a given node in
 *  a binary search tree. You may assume that each node has a link to its parent.
 * @author gengchen
 * 
 * pseudocode
 * Node inorderSucc (Node n){
 * 	if( n has a right subtree)
 * 		return leftmost child of right subtree) 
 *	else{
 *		while( n is a right child of n.parent){
 *			n = n.parent
 *		}
 *		return n.parent;
 * 
 * what I got: I admit that I just see the solution( my poor IQ)....But it deepened my understanding in traverse.
 * Remember what is inorder: 
 * 		1, traverse the left subtree 
 * 		2, the current node
 * 		3, traverse the right subtree
 * 
 * 2013/3/26
 * 心得体会： 书的一些问题可以通过自己在稿纸上画画图然后帮忙理解
 */

public class NextNode {
	public static void main(String[] args){

	}
	
	public Node inorderSucc(Node n){
		if( n == null){
			return null;
		}
		/* found right child -> return leftmost node of right subtree*/
		
		if(n.getParent() == null || n.getRight() != null)  /*we actually didn't implement it*/{
			return leftMostChild(n.getRight());
		}else{
			Node q = n;
			Node x = q.getParent();
			//go up until we are on left instead of right
			
			while(x != null && x.getLeft() != q){
				q = x;
				x = x.getParent();
			}
			return x;
		}
	}
	
	private Node leftMostChild(Node n){
		if(n == null)
			return null;
		
		while(n.getLeft() != null){
			n = n.getLeft();
		}
		return n;
	}
}	
