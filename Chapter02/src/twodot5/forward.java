package twodot5;

import SLinkedList.SLinkedList;
import SLinkedList.SNode;

/**FOLLOW UP
* Suppose the digits are stored in forward order. Repeat the above problem.
* EXAMPLE
* Input: (6 -> 1 -> 7) + (2 -> 9 -> 5). That is, 617 + 295.
* Output: 9 -> 1 -> 2. That is, 912.
* 基本方法就是讲链表反转
*/
public class forward {
	
	public static void main(String [] args){
		int[] data1 = {1,8,9,6,7,8};
		int[] data2 = {9,6,7,4};
		SLinkedList s1 = new SLinkedList(data1);
		SLinkedList s2 = new SLinkedList(data2);
		reverse(s1);
//		System.out.println(s1.getTail().getVal());

		reverse(s2);
		SLinkedList sum = new SLinkedList();
		sum1(s1,s2,sum);
		recovery(s1);
		recovery(s2);
		reverse(sum);
		s1.printList();
		s2.printList();
		SNode temp = sum.getHead();
		sum.setHead(sum.getTail());
		sum.setTail(temp);
		sum.printList();		
	}
	
	public static SLinkedList reverse(SLinkedList s){
		SNode curr = s.getHead();
		SNode next = curr.getNext();
		curr.SetNext(null);
		while(next!= null){
			SNode temp = curr;
			curr = next;
			next = next.getNext();
			curr.SetNext(temp);
		}
		return s;
	}
	public static SLinkedList recovery(SLinkedList s){
		SNode curr = s.getTail();
		SNode next = curr.getNext();
		curr.SetNext(null);
		while(next!= null){
			SNode temp = curr;
			curr = next;
			next = next.getNext();
			curr.SetNext(temp);
		}
		return s;
	}
	
	public static void sum1(SLinkedList s1, SLinkedList s2, SLinkedList sum){
		SNode  node1 = s1.getTail();
		SNode  node2 = s2.getTail();
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
		while(sum.getTail().getVal() == 0){
			sum.deleteTail();
		}
		
	}
		
}
