package twodot2;
/**2.2
 * Implement an algorithm to find the kth to last element of a singly linked list.
 * 类中提供了一个方法
 */

import SLinkedList.*;

public class IthNodeFromTail {
	public static void main(String[]args){
	int[] data = {3,5,6,7,57,5,1,2,3,4};
	SLinkedList s = new SLinkedList(data);
	int i = 5;
	SNode node1 = s.ithNodeFromTail1(i);
	System.out.println(node1.getVal());
	SNode node2 = s.ithNodeFromTail2(i);
	System.out.println(node2.getVal());
	SNode node3 = s.ithNodeFromTail3(i);
	System.out.println(node3.getVal());
	s.printList();
	SNode node4 = s.ithNodeFromTail4(s.getHead(),i,new IntWrapper());
	System.out.println(node3.getVal());
	
	
	}

}
