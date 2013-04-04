/**
 * CareerCup 11.8
 * Imaging you are reading in a stream of integers.Periodically, you wish to be able
 * to look up the rank of a number x(the number of values less than or equal to x).
 * Implement the data structures and algorithms to support these operations . That
 * is, implement the method track(int x), which is called when each number is generated
 * , and the method getRankOfNUmber(int x), which return s the number of values less than 
 * or equal to x(not including x itself)
 * Example :
 * 	stream(in order of appearance) : 5,1,4,4,5,9,7,13,3
 * getRankOfNumber(1) = 0
 * getRankOfNumber(3) = 1
 * getRankOfNumber(4) = 3
 * 
 * 队排序
 */

package elevendot8;

import java.util.ArrayList;
import java.util.Random;

public class StreamOfNumber {
	public static Node root;
	public static int tempRank;
	
	

	public static void main(String[] args) throws InterruptedException{
		
			int[] data = {5,1,4,4,5,9,7,13,3};
			for(int i = 0 ; i < data.length; i++){
				track(data[i]);
				int j = getRankOfNumber(data[i]);
				System.out.println( data[i] + "'s rank is  " + j);
				
			}
		}
	private static int getRankOfNumber(int x) {
			return getRank(root,x);
	}
	
	private static int getRank(Node n,int x){
		if(n.val == x){
			return n.leftsize;
		}else if (n.val > x){
				return getRank(n.left,x);
		}else{
			return n.leftsize + getRank(n.right, x) + 1 ;
		}
	}
		
	

	private static void track(int x) {
		if(root == null){
			root = new Node(x);
			tempRank = 0;
		}else{
			insert(root,x);
		}
		
	}

	private static void insert(Node n,int x) {
		if(n.val >= x){
			if(n.left == null){
				n.left = new Node(x);	
			}else{
				insert(n.left,x);
			}
			n.leftsize ++;
			tempRank = n.leftsize;
		}else{
			if(n.right == null){
				n.right = new Node(x);
			}else{
				insert(n.right,x);
			}
		}
	}
}

class Node{
	int val;
	Node left; 
	Node right;
	int leftsize;
	
	public Node(int val){
		this.val = val;
	}
}
