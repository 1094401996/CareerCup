package twodot6;

/*三种方法：
 * 1，哈希图
 * 2，快慢指针（有数学推导）
 * 3。倒转链表（这个方法很好，很多题目都可以用）
 * */

import SLinkedList.SLinkedList;
import SLinkedList.SNode;

public class Circular {
	public static void main(String[]args){
		int [] data = {1,2,3,4};
		SLinkedList s = new SLinkedList(data);
		SNode node = new SNode(-1,null);
		s.append(node);
		s.append(5);
		s.append(6);
		s.append(7);
		s.append(8);
		s.append(9);
		s.append(10);
		s.append(11);
		s.getTail().SetNext(node);		
		SLinkedList s1 = new SLinkedList(data);
		System.out.println(isCircular1(s1).getVal());
		System.out.println(isCircular2(s1));

		
	}
	public static SNode isCircular1(SLinkedList s){
		SNode fast = s.getHead();
		SNode slow = s.getHead();
		while((fast != null) && (fast.getNext() != null)){
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if(slow == fast)
				break;
		}
		if ((fast == null) || (fast.getNext() == null)){
			System.out.println("no circle");
			return null;
		}
	
		slow = s.getHead();
		while(slow != fast){
			slow = slow.getNext();
			fast = fast.getNext();
		}
		   return slow;
	}
	public static boolean isCircular2(SLinkedList s){
		if(s.length() == 0){
			return false;
		}
		SNode curr = s.getHead();
		SNode next = curr.getNext();
		curr.SetNext(null);
		while(next != null){
			if(next == s.getHead()){
				return true;
			}
		    SNode temp = curr;
		    curr = next;
		    next = next.getNext();
		    curr.SetNext(temp);
		}
		next = curr.getNext();
		curr.SetNext(null);
		while(next != null){
			SNode temp = curr;
			curr = next;
			next = next.getNext();
			curr.SetNext(temp);
		}
		return false;
	}
	
}
