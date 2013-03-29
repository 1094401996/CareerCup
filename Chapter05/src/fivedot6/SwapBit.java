package fivedot6;
/**CareerCup 5.6
 * Write a program to swap odd and even bits in an integer with as few instructions as
 *  possible (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).

 * @author gengchen
 *example : 
 *10101010111
 *11010101011
 *
 *still no feeling about bit manipulation...
 *method: process the odd and even bits separately
 */
public class SwapBit {
	public static void main(String[] args){
		int x = -5;
		System.out.println("before : " + Integer.toBinaryString(x) + "  after : " + Integer.toBinaryString(swap(x)));
	}
	public static int swap(int n){
		return  ((n & 0xaaaaaaaa) >> 1) | ( (n & 0x55555555) << 1 );
	}
}
