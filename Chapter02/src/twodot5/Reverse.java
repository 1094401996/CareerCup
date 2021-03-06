package twodot5;
/**
 * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
 * EXAMPLE
 * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295
 * output: 2 -> 1 -> 9. That is, 912.
 * 
 */
import SLinkedList.SLinkedList;
import SLinkedList.SNode;

public class Reverse {
	public static void main(String [] args){
		int[] data1 = {1,8,9,6};
		int[] data2 = {9,6,7,4};
		SLinkedList s1 = new SLinkedList(data1);
		SLinkedList s2 = new SLinkedList(data2);
		SLinkedList sum1 = new SLinkedList();
		sum1.printList();
		sum1(s1,s2,sum1);
		s1.printList();
		s2.printList();
		sum1.printList();
		System.out.println();
		SLinkedList sum2 = new SLinkedList();
		sum2.printList();
		sum2(s1,s2,sum2);
		s1.printList();
		s2.printList();
		sum2.printList();
		
	}
	
	public static void sum1(SLinkedList s1, SLinkedList s2, SLinkedList sum){
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
	//这个方法是在算法导论上面看到的，比较适合位数一样的时候。。。。
	public static void sum2(SLinkedList s1, SLinkedList s2, SLinkedList sum){
		SNode  node1 = s1.getHead();
		SNode  node2 = s2.getHead();
		sum.append(0);
		sum.append(0);
		SNode node3 = sum.getHead();
		while ((node1 != null) || (node2 != null)){
			int n1 = 0;
			int n2 = 0;
			if(node1 != null){
				n1 = node1.getVal();
			}
			if(node2 != null){
				n2 = node2.getVal();
			}
			node3.setVal((n1 + n2 + node3.getVal())%10);
			node3 = node3.getNext();
			node3.setVal((n1 + n2 + node3.getVal())/10);
			sum.append(0);
			if(node1 != null)
				node1 = node1.getNext();
			if(node2 != null)
				node2 = node2.getNext();
		}
		if(sum.getTail().getVal() == 0){
			sum.deleteTail();
		}
		
	}
		

}
