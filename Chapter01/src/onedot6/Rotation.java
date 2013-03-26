package onedot6;
/**
 * CareerCup1.6
 * 此题直接把我对自己智力的信心打击一空，题目真的不难，但我被坐标的变换完全弄傻了。。。。不过也总结了一些小窍门
 * 一个数组的索引为[fisrt，last],第i个索引的offset为i - first;如果把数组倒过来索引(即从last开始索引），
 * 原来的i索引，变为last - offset;
 * @author gengchen
 *为了加深理解，把顺时针和逆时针的方法都写了。。。。还是代码量太少。。不是个合格的码农。。。
 */

public class Rotation {
	public static void main(String[] args){
		Rotation r = new Rotation();
		int[][]matrix1 ={{1,2,3},{4,5,6},{7,8,9}};
		r.rotate(matrix1, 3);
		for(int i = 0; i< 3;i++){
			for(int j = 0;j < 3; j++){
				System.out.print(matrix1[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

		int[][]matrix2 ={{1,2,3},{4,5,6},{7,8,9}};
		r.antirotate(matrix2, 3);
		for(int i = 0; i< 3;i++){
			for(int j = 0;j < 3; j++){
				System.out.print(matrix2[i][j] + " ");
			}
			System.out.println();
		}
	}
	public void antirotate(int[][]matrix,int n){
		for(int layer = 0; layer <n/2; layer ++){
			int first = layer;
			int last = n - 1- layer;
			for(int i = first; i< last;i ++){
				int offset = i - first;
				// save top
				int top = matrix[first][i];
				//top <- right
				matrix[first][i] = matrix[i][last];
				//right <- bottom
				matrix[i][last] = matrix[last][last - offset];
				//bottom <-left
				matrix[last][last - offset] = matrix[last - offset][first];
				//left <- top
				matrix[last - offset][first] = top;
			
			}
		}
	}
	public void rotate(int[][]matrix,int n){
		for (int layer = 0; layer < n/2; layer ++){
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++){
				int offset = i - first;
				//save the top
				int top = matrix[first][i];
				//  top <- left
			    matrix[first][i] = matrix[last - offset][first];
			    //  left <- bottom
			    matrix[last - offset][first] = matrix[last][last - offset];
			    //bottom <- right
			    matrix[last][last - offset] = matrix[i][last];
			    //right <- top
			    matrix[i][last] = top;
				
			}
		}
	}
}