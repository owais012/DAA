import java.util.*;

public class coinChangeDP{

	public static int helper(int i, int target, int coins[], int dp[][]){

		if(i == 0){
			if(target % coins[i] == 0) return 1;
			return 0;
		}
	
		if(dp[i][target] != -1) return dp[i][target];
	
		int notTake =  helper(i-1, target, coins, dp);
		int take = 0;

		if(target >= coins[i]){
			take =  helper(i, target - coins[i], coins, dp);
		}

		return dp[i][target] =  take + notTake;	
	}
	
	public static void main(String args[]){
		int coins[] = new int []{1,2,3};
		int target = 4;

		int dp[][] = new int [coins.length+1][target+1];
		for(int row[]: dp) Arrays.fill(row, -1);

		System.out.println(helper(2, target, coins, dp)); 

		for(int i = 0; i < dp.length; i++){
			for(int j =0; j < dp[0].length; j++){
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}

}