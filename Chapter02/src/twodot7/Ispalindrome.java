package twodot7;
/* 2.7
 * Implement a function to check if a linked list is a palindrome.
 * method: 老方法 反转指针  但是只转一半  然后从中间往两边走。。。
 * 
 * 别人的好方法：这位大牛还还用了递归的思想。。。。。实现的代码也比我优雅  要借鉴。。。。
 * https://github.com/quantumrose/CareerCup/blob/master/2.7.IsPalindrome.java
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
		//如果长度是偶数。。。
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
		//如果是长度是基数。。。。
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
	//回复链表
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
