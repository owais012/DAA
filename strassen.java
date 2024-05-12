public class strassen{

	public static void main(String args[]){
		int A[][] = new int[][] {{1,2},{2,3}};
		int B[][] = new int[][] {{1,2}, {3,4}};
		int C[][] = new int[2][2];

		int P = (A[0][0] + A[1][1]) * (B[0][0]+B[1][1]);
		int Q = (A[1][0] + A[1][1]) * B[0][0];
		int R = A[0][0] * (B[0][1] - B[1][1]);
		int S = A[1][1] * (B[1][0] - B[0][0]);
		int T = (A[0][0] + A[1][0]) * B[1][1];
		int U = (A[1][0] - A[0][0]) * (B[0][0] + B[0][1]);
		int V = (A[0][1] - A[1][1]) * (B[1][0] + B[1][1]);

		C[0][0] = P+S-T+V;
		C[0][1] = R +T;
		C[1][0] = Q+S;
		C[1][1] = P + R - Q + U;

		for(int i =0; i < 2; i++){
			for(int j = 0; j < 2; j++){
				System.out.print(C[i][j] + " ");
			}
			System.out.println();
		}
	}

}