package twodot3;

import SLinkedList.SLinkedList;
import SLinkedList.SNode;

public class DeleteMiddle {
	public static void main(String[]args){
		int[] data = {3,3,5,6,7,57,5,1,2,3,4};
		SLinkedList s = new SLinkedList(data);
		
		SNode node = s.ithNodeFromTail(3);
		node.deleteMyself();
		s.printList();
		
		}

}
