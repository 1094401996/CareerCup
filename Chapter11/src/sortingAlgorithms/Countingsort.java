package sortingAlgorithms;

public class Countingsort {
	private int[]a;
	public Countingsort(int[] a){
		this.a = a;
	}
	
	public void sort(){
		int range = findMax() + 1;
		int[] c = new int[range];
		int[] b = new int[a.length];
		for (int i = 0 ; i < a.length; i++){
			c[a[i]]++;
		}
//		
//		for(int i = 1 ; i < c.length ; i++){
//			c[i] = c[i] + c[i-1];
//		}
//		
//		for(int i = a.length - 1; i >=0 ; i--){
//			b[c[a[i]] - 1] = a[i];//REMENBER
//			c[a[i]]--;
//		}
//		for(int i = 0 ; i < b.length; i++){
//			a[i] = b[i];
//		}
		//optimized counting 
		int j = 0;
		for(int i = 0; i < c.length; i++ ){
			while(c[i] > 0){
				a[j++] = i;
				c[i] --;
			}
		}
		
	}
	
	private int findMax(){
		int max = a[0];
		for(int i = 0 ; i < a.length; i++){
			if(a[i] > max){
				max = a[i];
			}
		}
		return max;
	}
	private int findMin(){
		int min = a[0];
		for(int i = 0 ; i < a.length; i++){
			if(a[i] < min){
				min = a[i];
			}
		}
		return min;
	}
	
	public static void main(String[] args){
		int [] a = {5,4,3,2,1};
		Countingsort cs = new Countingsort(a);
		cs.sort();
		for(int i : a){
			System.out.print(i + " ");
		}
	}
}
