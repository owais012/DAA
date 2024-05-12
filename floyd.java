public class floyd{

	public static void main(String args[]){	
		int V = 4;
		int inf = (int) 1e9;
		int matrix[][] = new int[][]{
				{0, inf, 3, inf},
				{2, 0, inf, inf},
				{inf, 7, 0, 1},
				{6, inf, inf, 0}
		};

		for(int k = 0; k < V; k++){
			for(int i = 0; i < V; i++){
				for(int j = 0; j < V; j++){
					matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + 
									matrix[k][j]);
				}
			}
		}

		for(int i = 0; i < V; i++){
			for(int j =0; j < V; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}

}