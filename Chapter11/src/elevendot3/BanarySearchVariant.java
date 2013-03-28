package elevendot3;
/**
 * Given a sorted array of n integers that has been rotated an unknown number oftimes, 
 * give an O(log n) algorithm that finds an element in the array. You may assume that the
 *  array was originally sorted in increasing order. 
 *  EXAMPLE:
 *  Input: find 5 in array (15 16 19 20 25 1 3 4 5 7 10 14)
 *  Output: 8 ( the index of 5 in the array)
 * @author gengchen
 * 
 * 2013.3.27
 *method: recursion....此题再次暴露了我的智商
 */

public class BanarySearchVariant {
	public static void main(String[] args){
		int[] data={2,2,2,3,4,2};
		System.out.println(findTarget(data,0,data.length - 1, 3));
	}
	
	
	public static int findTarget(int[] data, int left, int right, int x){
		if(left >  right ){
			return -1;
		}
		int middle = (left + right)/2;
		if(data[middle] == x){
			return middle;
		}
		
		if(data[middle] > data[left]){ //means the left half is normally ordered
			if(x >= data[left] && x <= data[middle]){
				return findTarget(data, left, middle - 1, x);
			}else{
				return findTarget(data, middle + 1, right, x);
			}
		}else if(data[middle] < data[left]){ // means the right half is normally ordered
			if(x <= data[right] && x >= data[middle]){
				return findTarget(data,middle + 1, right,x);
			}else{
				return findTarget(data, left, middle - 1, x);
			}
		}else if(data[middle] == data[left]){
			if(data[middle] != data[right]){// the left half are all identical element{
				return findTarget(data, middle + 1, right, x);
			}else{
				int result = findTarget(data,left, middle - 1, x);
				if(result == -1){
					return findTarget(data,middle + 1, right, x);
				}else{
					return result;
				}
			}
		}
		return -1;
	}
}


