package twodot2;

import SLinkedList.*;

public class IthNodeFromTail {
	public static void main(String[]args){
	int[] data = {3,3,5,6,7,57,5,1,2,3,4};
	SLinkedList s = new SLinkedList(data);
	SNode node = s.ithNodeFromTail(s.length() -1 );
	System.out.println(node.getVal());
	
	
	}

}
