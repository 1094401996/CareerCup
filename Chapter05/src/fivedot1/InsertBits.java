package fivedot1;
/**
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j. 
 * Write a method to insert M into N such that M starts at bit j and ends at bit i.
 *  You can assume that the bits j through i have enough space to fit all of M. That
 *   is, if M=10011, you can assume that there are at least 5 bits between j and i.
 *    You would not, for example, have j = 3 and i=2, because M could not fully fit 
 *    between bit 3 and bit 2. 
 *    EXAMPLE
 *    Input: N = 10000000000, M = 10011, i = 2, j = 6
 *    Output: N = 10001001100
 *    
 *    
 *    method: 
 *    1,  basic bit operation,one bit by one bit....
 *    2 , the standard solution is better than me....
 *    	a, clear the bits from i to j in N
 *    	b, shift M so that it lines up with bits from i to j
 *    	c, merge the two num......
 * @author gengchen
 *
 */

public class InsertBits {
	public static void main(String[] args) throws Exception{
		int N = 1024;
		int M = 19;
		int N1 = InsertBits1(N,M,2,6);
		int N2 = InsertBits2(N,M,2,6);
		System.out.println("Method 1 :     N = " + Integer.toBinaryString(N) + ", M = " + Integer.toBinaryString(M) + ", after the insertion, N becaomes " + Integer.toBinaryString(N1));
		System.out.println("Method 2 :     N = " + Integer.toBinaryString(N) + ", M = " + Integer.toBinaryString(M) + ", after the insertion, N becaomes " + Integer.toBinaryString(N2));
	
	}
	
	public static int InsertBits1(int N, int M, int i , int j) throws Exception{
		String str = Integer.toBinaryString(M);
		int size = str.length();;
		if (j - i + 1 < size)
			throw new Exception("illegal opeation");
		for( int k = 0; k < size ; k++){
			int v = getBit(M,k);
			N =updateBit(N,i,v);
			i++;
		}
		return N;
	}
	
	
	public static int InsertBits2( int N , int M , int i , int j){
		int right = ~((1 << (j + 1)) - 1 );
		int left =  (1 << (i + 1)) - 1;
		
		int mask = left | right;
		
		int clear_i_j = mask & N;
		
		int M_shift_i = M << i;
		
		return clear_i_j | M_shift_i;
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
	public static int updateBit(int num , int i , int v){
		int mask = ~(1 << i);
		return (num & mask) | (v << i);
		
	}

}
