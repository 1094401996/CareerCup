package twodot5;

import SLinkedList.SLinkedList;
import SLinkedList.SNode;
/*此题一开始使用了算法导论的中的方法 但是有bug....不知道怎么回事。。。。回头再看看
 * */
public class Reverse {
	public static void main(String [] args){
		int[] data1 = {1,8,9,6};
		int[] data2 = {9,6,7,4};
		SLinkedList s1 = new SLinkedList(data1);
		SLinkedList s2 = new SLinkedList(data2);
		SLinkedList sum = new SLinkedList();
		sum.printList();
		sum(s1,s2,sum);
		s1.printList();
		s2.printList();
		sum.printList();
	}
	
	public static void sum(SLinkedList s1, SLinkedList s2, SLinkedList sum){
		SNode  node1 = s1.getHead();
		SNode  node2 = s2.getHead();
		int carry = 0;
		while ((node1 != null) && (node2 != null)){
			int i = (node1.getVal() + node2.getVal() + carry) % 10;
			carry = (node1.getVal() + node2.getVal() + carry) / 10;
			sum.append(i);
			node1 = node1.getNext();
			node2 = node2.getNext();
			
		}
		while(node1 != null){
			int i = (node1.getVal()  + carry) % 10;
			carry = (node1.getVal() + carry) / 10;
			sum.append(i);
			node1 = node1.getNext();
		}
		while (node2 != null){
			int i = (node2.getVal() + carry) % 10;
			carry = (node2.getVal() + carry) / 10;
			sum.append(i);
			node2 = node2.getNext();	
		}
		if (carry == 1)
			sum.append(carry);
		
	}	


}
