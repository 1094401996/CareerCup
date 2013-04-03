/**
 * CareerCup 11.5
 * Given a sorted array of strings which interspersed with empty strings, 
 * write a method to find
 *  the location of a given string.
 *  Example: find "ball" in ["at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""] 
 *  will return 4
 *  Example: find "ballcar" in ["at", "", "", "", "", "ball", "car", "", "", "dad", "", ""] 
 *  will return -1
 */

package elevendot5;

public class FindString {
	public static void main(String[]args){
		
		String[] strs={"at","","","","","ball","","","car","cat","","dad","","","hello"};
		String target = "car";
		System.out.println(findString(strs,target,0,strs.length - 1));
	}
	
	public static int findString(String[] strs, String target,int left, int right){
		if(right >= left){
			int mid = (left + right)/2;
			if(strs[mid].compareTo(target) == 0){
				return mid ;
			}
			if(strs[mid].equals("")){
				//check the right
				int i = mid;
				while(i <= right && strs[i].compareTo("") == 0){
					i++;
				}
				if(strs[i].compareTo("") == 0){//rearch the right boundary,right half part are all empty string, so searc the left half 
					return findString(strs,target,left,mid - 1);
				}
				if( strs[i].compareTo(target) <=0){
					return findString(strs,target,i,right);
				}
				if( strs[i].compareTo(target) >=0){
					return findString(strs,target,left,mid - 1);
				}
//				//check the left
//				int j = mid;
//				while(j >= left && strs[j].compareTo("") == 0){
//					j--;
//				}
//				if(j >= left && strs[j].compareTo(target) >= 0){
//					return findString(strs,target,left, j);
//				}
//				if(j>=left && strs[j].compareTo(target)<=0){
//					return findString(strs,target,mid,right);
//				}
//				if(i > right && j <left){
//					return -1;
//				}	
			}else if(strs[mid].compareTo(target) >0){
				return findString(strs,target,left,mid - 1);
			}else{
				return findString(strs,target,mid + 1,right);
			}
			
	   }
		return -1;
	}
}
