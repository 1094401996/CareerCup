package sortingAlgorithms;

public class Heapsort {
	private int[] arr;
	
	public Heapsort(int[]arr){
		this.arr = arr;
		
	}
	
	public void sort(){
		buildHeap();
		for(int i = arr.length - 1; i > 0 ; i --){
			swap (0,i);
			heapify(0,i);
		}
	}
	private int parent(int i ){
		return i/2;
	}
	
	private int left(int i){
		return 2*i;
	}
	private int right(int i){
		return 2 *i + 1;
	}
	
	//i 堆化的起始节点
	private void heapify(int i ){
		heapify(i,arr.length);
	}
	
	/**
	 * @param i
	 * @param size 堆化的范围
	 */
	private void heapify(int i , int size){
		int left = left(i);
		int right = right(i);
		int largest = i;
		if(left < size && arr[left] > arr[i]){
			largest = left;
		}
		if(right < size &&  arr[right] > arr[largest]){
			largest = right;
		}
		if(largest != i){
			swap(i, largest);
			heapify(largest,size);
		}
	}
	private void swap(int i , int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	//bulit heap
	private void buildHeap(){
		for(int i = arr.length / 2 - 1; i >= 0; i--){
			heapify(i);
		}
	}
	
	public static void main(String[]args){
		int[] arr = {3,4,1,2,5,3,0,1,2,3,4,1,11,23,34};
		Heapsort hs = new Heapsort(arr);
		hs.sort();
		for(int e : arr){
			System.out.print(e + " ");
		}
	}
}
