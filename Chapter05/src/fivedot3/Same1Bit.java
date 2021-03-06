package fivedot3;
/**CareerCup 4.8
 * Given a positive integer, print the next smallest and the next largest number that have the same number 
 * of 1 bits in their binary representation.
 * method: I found that bit manipulation is just something about the IQ....My poor IQ.... the book provides two
 * kinds of solution... I just finish one tonight..The second one will be left for the next turn...I am struggling
 * in headache now...
 * @author gengchen
 *
 */

public class Same1Bit {
	
	public static void main(String[] args){
		System.out.println(Integer.toBinaryString(getNextGreater(Integer.parseInt("11011001111100", 2))));
		System.out.println(Integer.toBinaryString(getNextSmaller(Integer.parseInt("10011110000011", 2))));
	}
	public static int getNextGreater(int n){
		int c = n;
		int c0 = 0;
		int c1 = 0;
		
		while(((c & 1) == 0) &&(c != 0)){
			c0++;
			c >>= 1;
		}
		while((c & 1 ) == 1){
			c1 ++;
			c >>= 1;
		}
		if(c0 + c1 == 31 || c0 + c1 == 0){
			return -1;
		}
		
		int p = c0 + c1;
		
		n = setBit(n,p);
		n = clearBitsIthrough0(n,p -1);
		n = setBitsIthrough0(n,c1 - 2);
		return n;
	}
	public static int getNextSmaller(int n){
		int temp = n;
		int c0 = 0;
		int c1 = 0;
		while((temp & 1) == 1){
			c1++;
			temp >>= 1;
		}
		if(temp == 0)  // 000000...111.....1 this pattern doesn't have the required "smaller number"
			return -1;
		while(((temp &1) == 0) && (temp != 0)){
			c0++;
			temp >>= 1;
		}
		
		int p = c0 + c1;
		n = clearBitsIthrough0(n, p );
		return setBItsThroughItoJ(n, p - 1,p - 1 - (c1 + 1) + 1);
		
		
	}
	public static int getBit(int num,int i){
		int mask = 1 << i;
		return (mask & num) >> i;
	}
	public static int setBit(int num, int i){ 
		int mask = 1 << i;
		return mask | num;
	}

	public static int clearBit(int num ,int i){
		int mask = ~(1 << i);
		return mask & num;
	}
	
	public static int clearBitsMSBthroughI(int num, int i){
		int mask = ( 1 << i ) - 1;
		return num & mask;
	}
	
	public static int clearBitsIthrough0(int num, int i){
		int mask = ~((1 << (i + 1)) -1 );
		return mask & num;
	}
	public static int setBitsIthrough0(int num, int i){
		int mask = (1 << ( i + 1)) - 1;
		return mask | num;
	}
	
	public static int setBItsThroughItoJ(int num , int i , int j){
		int mask1 = (1 << (i + 1)) - 1;
		int mask2 = ~ ((1 << j) - 1 );
		int mask = mask1 & mask2;
		return num | mask;
	}
	public static int updateBit(int num , int i , int v){
		int mask = ~(1 << i);
		return (num & mask) | (v << i);
		
	}
}


