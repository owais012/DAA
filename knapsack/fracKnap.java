import java.util.*;

class Sack{
	int profit, weight;
	Sack(int p,  int w){
		profit = p;
		weight = w;
	}
}

public class fracKnap{
	public static void main(String args []){
		Scanner input = new Scanner(System.in);
		int n = 7; //input.nextInt();
		ArrayList<Sack> sack = new ArrayList<>();

		int profit[] = new int [] {4, 6, 7, 8, 1, 3, 2};
		int weight[] = new int [] {8, 6, 3, 9, 2, 4, 5};
		

		for(int i = 0; i < n; i++){
			//System.out.print("profit: ");
			//profit[i] = input.nextDouble();

			//System.out.print("weight: ");
			//weight[i] = input.nextDouble();

			
			sack.add(new Sack(profit[i], weight[i]));
		}

		//System.out.println("Enter the capacity of the bag");
		int W = 15; //input.nextInt();
		
		Collections.sort(sack, new Comparator<Sack>(){
			public int compare(Sack s1 ,Sack s2){
				return (s2.profit*s1.weight - s1.profit*s2.weight);
			}
		});

		for(int i = 0; i < n; i++){
			System.out.println(sack.get(i).profit);
		}
	
		double total_profit = 0;
		int i = 0;

		while(W > 0){
			if(W >= sack.get(i).weight){
				total_profit += sack.get(i).profit;
				W -= sack.get(i).weight;
			}else{
				total_profit +=  ( W/(double) sack.get(i).weight) * sack.get(i).profit;
				W = 0;
				break;
			}
			i++;
		}

		System.out.println(total_profit);
	}
}