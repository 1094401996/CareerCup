package fivedot5;
/**
 * Write a function to determine the number of bits required to convert integer A to integer B.
 * EXAMPLE:
 * Input:31,14
 * Output:2
 * @author gengchen
 * 2013.3.27
 * method: 编程之美上面的方法。。先异或再找出1的个数，
 */

public class NumberOfChange {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numberOfChange(31,14));
	}
	
	public static int numberOfChange(int a , int b){
		a = a^b;
		return numberOf1s(a);
	}
	public static int numberOf1s(int data){
		int num = 0;
		while(data != 0){
			data &= data - 1;
			num ++;
		}
		
		return num;
	}
}
