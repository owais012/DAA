import java.util.*;

public class coinChangeGreedy{

	public static void main(String args[]){
		int coins[] = new int []{5,1,2,10};
		int T = 13;
		Arrays.sort(coins);
		int coinCnt = 0;

		for(int i = coins.length-1; i >= 0; i--){
			while(T >= coins[i]){
				coinCnt++;
				T -= coins[i];
			}
			if(T == 0) break;			
		}
		
		System.out.println(coinCnt);
	}

}