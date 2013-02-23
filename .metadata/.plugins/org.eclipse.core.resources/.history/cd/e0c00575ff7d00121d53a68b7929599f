package onedot6;

public class Rotation {
	public static void main(String[] args){
		int[][]matrix ={{1,2,3},{4,5,6},{7,8,9}};
		Rotation r = new Rotation();
		r.rotate(matrix, 3);
		for(int i = 0; i< 3;i++)
			for(int j = 0;j < 3; j++)
				System.out.println(matrix[i][j]);
	}
	public void rotate(int[][]matrix,int n){
		for(int layer = 0; layer <n/2; ++layer){
			int first = layer;
			int last = n - 1- layer;
			for(int i = first; i< last;++i){
				int offset = i - first;
				//save top 
				int temp = matrix[layer][i];
				//left->top
				matrix[layer][i] = matrix[n - 1 -i][layer];
				//bottom->left
				matrix[n - 1 -i][layer] = matrix[last][n - 1 -i];
				//right->bottom
				matrix[last][n - 1 -i] = matrix[i][last];
				//top->right
				matrix[i][last] = temp;
			}
		}
	}
}