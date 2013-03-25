package twodot3;
/**
 * 
 * 
 *Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
 *EXAMPLE
 *Input: the node c from the linked list a->b->c->d->e
 *Result: nothing is returned, but the new linked list looks like a->b->d->e
 *此题的思想很好，但有点坑爹地方，middle指的不是正中间的元素。。。
 */
import SLinkedList.SLinkedList;
import SLinkedList.SNode;


public class DeleteMiddle {
	public static void main(String[]args){
		int[] data = {3,3,5,6,7,57,5,1,2,3,4};
		SLinkedList s = new SLinkedList(data);
		
		SNode node = s.ithNodeFromTail1(3);
		node.deleteMyself();
		s.printList();
		
		}

}
