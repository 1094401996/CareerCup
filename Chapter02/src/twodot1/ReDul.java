package twodot1;
/**2.1
 * Write code to remove duplicates from an unsorted linked list.
	FOLLOW UP
	How would you solve this problem if a temporary buffer is not allowed?
	
	Method 1:
	万能的Hashmap
	Method 2:
	curr指向当前节点，prev指向curr前面的那个节点，每次检查curr的时候，使用一个runner从头部开始扫描，这里有一个循环不变量：【head prev】之间的元素都是不同的，
	这里有点插入排序的思想在里面
 */
import SLinkedList.SLinkedList;

public class ReDul {

	public static void main(String[]args){
		int val[] = {1,2,4,5,6};
		SLinkedList s = new SLinkedList(val);	
		s.printList();
		s.delDup1();
		s.printList();
		int data[] = {1,1,4,5,6,5,3,3,3,3,1,3,5,6};
		SLinkedList list = new SLinkedList(data);
		list.printList();
		list.delDup2();
		list.printList();
		int data1[] = {1,1,1,1,1,1,1,1,1,1,1};
		SLinkedList list1 = new SLinkedList(data1);
		list1.printList();
		list1.delDup2();
		list1.printList();
	
	}
}
