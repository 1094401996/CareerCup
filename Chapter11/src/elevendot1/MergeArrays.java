package elevendot1;

import java.util.*;
/**
 * CareerCup 11.1
 * You are givin two sorted arrays, A and B, where A has a large enough buffer at the end to hold B. Write 
 * a method to merge B into A in sorted order.....
 * 
 * Method: 此题思路和第一章的一提相当。。。。
 * set three pointers, the first points to the end elment of A, the second points to the end element of B.
 * the third one pointers to the end of merged array
 * @author gengchen
 *
 */
public class MergeArrays {
	public static void main(String[] args){
		int[] a = {1,3,5,7,9,0,0,0,0,0};
		int [] b = {2,4,6,8,10};
		a = mergeSortedArrays(a,b,4);
		for(int i : a){
			System.out.print(i + " ");
		}
	}
	public static int[] mergeSortedArrays(int[] a, int[] b, int LastElementIndexofA){
		int LastElementIndexafterMerge = b.length + LastElementIndexofA ;
		int indexOfA = LastElementIndexofA;
		int indexOfB = b.length - 1;
		while(indexOfA>= 0 && indexOfB>= 0 ){
			if(a[indexOfA] > a[indexOfB]){
				a[LastElementIndexafterMerge--] = a[indexOfA--];
			}else{
				a[LastElementIndexafterMerge--] = b[indexOfB--];
			}
		}
		while(indexOfB >= 0){
			a[LastElementIndexafterMerge--] = b[indexOfB--];
		}
		return a;
	}
}
