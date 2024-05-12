import java.util.*;

public class knapsack{

	public static int helper(int i , int cap, int profit[], int weight[], int dp[][]){
		if(i == 0){
			if(cap >= weight[i]){
				return profit[i];
			}
			return 0;
		}
			
		if(cap < 1) return 0;
		if(dp[i][cap] != -1) return dp[i][cap];

		int take = 0;
		if(cap >= weight[i])
			take = profit[i] + helper(i-1, cap-weight[i], profit, weight, dp);
		int notTake = 0 + helper(i-1, cap, profit, weight, dp); 

		return dp[i][cap] = Math.max(take, notTake);
	}

	public static void main(String args[]){
		int profit[] = new int[]{5,4, 8, 6};
		int weight[] = new int[]{1,2,4, 5}; 
 		int W = 5;

		int dp[][] = new int[profit.length+1][W+1];
		for(int row[]: dp) Arrays.fill(row, -1);
		System.out.println(helper(profit.length-1, W, profit, weight, dp));
				
	}
}