import java.util.*;

public class mcm{
	public static int helper(int i, int j, int matrix[], int dp[][]){
		if(i == j) return 0;
		
		if(dp[i][j] != -1) return dp[i][j];

		int min_cost = (int) 1e9;
		for(int k = i; k <= j-1; k++){
			int curCost = matrix[i-1]*matrix[k]*matrix[j] + 
					helper(i, k, matrix, dp) + helper(k+1, j, matrix, dp);
			min_cost = Math.min(min_cost, curCost);
	
		}
		
		return dp[i][j] = min_cost;    	
	
	}

	public static void main(String args[]){
		int matrix[] = new int[]{5, 4, 6, 2, 7};
		int dp[][] = new int [matrix.length+1][matrix.length+1];
		for(int row []: dp) Arrays.fill(row, -1);

		System.out.println(helper(1, 4, matrix, dp));	
	}
}