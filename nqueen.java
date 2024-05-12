public class nqueen{	
	private static int queen[];

	public static boolean isSafe(int row, int col){
		for(int i = 0; i < row; i++){
			if(queen[i] == col || Math.abs(queen[i] - col) == Math.abs(row - i)){
				return false;
			}
		}
		return true;
	}

	public static void printQueen(int n){
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(queen[i] == j){
					System.out.print("Q");
				}else System.out.print(".");
				
			}	
			System.out.println();
		}
	}

	public static void placeQueen(int row, int n){
		if(row == n){
			printQueen(n);
			return;
		}

		for(int col = 0; col < n; col++){
			if(isSafe(row, col)){
				queen[row] = col;
				placeQueen(row+1, n);
			}
		}
	}
	
	public static void main(String args[]){
		int n = 4;
		queen = new int[n];
		placeQueen(0, 4);
	}
	
}