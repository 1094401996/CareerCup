package onedot7;
/**
 * 2013.02.23 
 * CarrerCup1.7
 * 寮�袱涓綅鍚戦噺鏁扮粍锛屼竴涓褰曡锛屼竴涓褰曞垪
 * 闆跺皯鐨勬椂鍊欎娇鐢╯et1,澶氱殑鏃跺�浣跨敤set2
 * */
import java.util.ArrayList;

public class SetZero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][]matrix ={{0,0,2,3},{4,1,5,6},{7,8,1,1}};
		int N = matrix.length;
		int M = matrix[0].length;
		boolean[]rowEmpty = new boolean[N];
		boolean[]columnEmtpy = new boolean[M];
		for(int i = 0; i < N; i++)
			for (int j = 0; j < M; j++){
				if(matrix[i][j] == 0){
					rowEmpty[i] = true;
					columnEmtpy[j] = true;
				}
			}	
		set1(matrix,rowEmpty,columnEmtpy);
		for(int p = 0; p < N;p++){
			for(int q = 0; q < M; q++){
				System.out.print(matrix[p][q] + " ");
			}
			System.out.println();
		}
		
	}
    public static void set1(int matrix[][], boolean[] rowEmpty, boolean [] columnEmpty){
    	for(int i = 0 ; i < rowEmpty.length; i++){
    		if(rowEmpty[i] == true){
    			for(int j = 0; j < matrix[0].length;j++){
    				matrix[i][j] = 0;
    			}
    		}
    	}
    	for(int i = 0; i < columnEmpty.length;i++){
    		if(columnEmpty[i] == true){
    			for (int j = 0; j < matrix.length; j++){
    				matrix[j][i] = 0;
    			}
    		}
    	}
    }
	public static void set2(int matrix[][], boolean[] rowEmpty, boolean [] columnEmpty){
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[0].length; j++){
				if (rowEmpty[i] || columnEmpty[j]){
					matrix[i][j] = 0;
				}
			}
		}
		
	}

}
