import java.util.*;

public class minCoinChange{
	public static int helper(int ind, int T, int coins[], int dp[][]){
		if(ind == 0){
			if(T % coins[0] == 0) return T / coins[0];
			return (int) 1e9;
		}
		if(dp[ind][T] != -1) return dp[ind][T];
		
		int notTake = 0 + helper(ind-1, T, coins, dp);
		int take = (int) 1e9;

		if(T >= coins[ind]) 
			take = 1 +  helper(ind, T-coins[ind], coins, dp);

		return dp[ind][T] =  Math.min(take, notTake);
	}
	
	public static void main(String args[]){
		int coins[] = new int []{1,2,3,4};
		int target = 4;

		int dp[][] = new int [coins.length+1][target+1];
		for(int row[]: dp) Arrays.fill(row, -1);

		System.out.println(helper(3, target, coins, dp));
		
	}

}
