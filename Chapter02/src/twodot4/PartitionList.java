package twodot4;
/**2.4
 * Write code to partition a linked list around a value x, 
 * such that all nodes less than x come before all nodes greater than of equal to x.
 * Method:
 * 运用了快排的partition思想，方法在链表类这中提供。。。。
 * 
 * 
 */

import SLinkedList.SLinkedList;

public class PartitionList {
	public static void main(String[]args){
		int[] data = {5,6,8,1,9,10,1,2,3};
		SLinkedList s = new SLinkedList(data);
		s.partitionList(7);
		System.out.println(s.length());
		s.printList();
		
	}

}
