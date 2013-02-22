package twodot7;
/*
 * 此题使用了2.6的方法，还算好用，倒转指针时运用了循环不变量的技巧，这个很重要，要不容易搞混
 */
import SLinkedList.SLinkedList;
import SLinkedList.SNode;

public class Ispalindrome {
	public static void main(String[] args){
		int[] data1 = {1,2,2,1,4};
		int[] data2 = {1,2,3,4,3,2,1};
		int[] data3 = {1,2,3,4,4,3,2,1};
		SLinkedList s1 = new SLinkedList(data1);
		SLinkedList s2 = new SLinkedList(data2);
		SLinkedList s3 = new SLinkedList(data3);
		System.out.println(isPalindrome(s1));
		s1.printList();
	    System.out.println(isPalindrome(s2));
		s2.printList();
		System.out.println(isPalindrome(s3));
		s3.printList();
	}
	
	public static boolean isPalindrome(SLinkedList s){
//		System.out.println(s.length());
		if (s.length() == 0)
			return false;
		int size = s.length();
		SNode slow = s.getHead();
		SNode fast = s.getHead();
		while((fast != null) && (fast.getNext()!= null)){
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
//		System.out.println(start.getNext().getVal());
		SNode curr = s.getHead();
		SNode next = curr.getNext();
		curr.SetNext(null);
		while(next!=slow){
			SNode temp = curr;
			curr = next;
			next = next.getNext();
			curr.SetNext(temp);
		}
		SNode rec = curr;
		SNode start = slow;
//		System.out.println(curr.getVal());
//		System.out.println(start.getVal());
		if(s.length() % 2 == 0){
			while(curr != null){
				if(curr.getVal() == start.getVal()){
					curr = curr.getNext();
					start = start.getNext();
					
				}
				else{
					recovery(s,rec,slow);
					return false;
				}
			}
			recovery(s,rec,slow);
			return true;
		}
		else{
			start = start.getNext();
			while(curr != null){
				if(curr.getVal() == start.getVal()){
					curr = curr.getNext();
					start = start.getNext();
				}
				else{
					recovery(s,rec,slow);
					return false;
				}
			}
			recovery(s,rec,slow);
			return true;
		}
		    
		
	}
	
	public static void recovery(SLinkedList s, SNode curr, SNode slow ){
		SNode next = curr.getNext();
		curr.SetNext(slow);
		while(next != null){
			SNode temp = curr;
			curr = next;
			next = next.getNext();
			curr.SetNext(temp);
		}
		
	}
}
