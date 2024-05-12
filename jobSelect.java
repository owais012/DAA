import java.util.*;

class Job{
	int no, profit, dline;
	Job(int p, int d, int n){
		profit = p;
		dline = d;
		no = n;
	}
}

public class jobSelect{
	
	public static void main(String args[]){
		int profit[] = new int[]{85, 22, 16, 40, 55, 19, 92, 80, 15};
		int deadline[] = new int[]{5, 4, 3, 3, 4, 5, 2, 3, 7};

		ArrayList<Job> job = new ArrayList<>();

		for(int i =0; i < profit.length; i++){
			job.add(new Job(profit[i], deadline[i], i+1));
		}

		Collections.sort(job, new Comparator<Job>(){
			public int compare(Job j1, Job j2){
				return j2.profit - j1.profit;
			}
		});
		
		TreeSet<Integer> slot = new TreeSet<>();
		int max_deadline = 0;

		for(int i =0; i < profit.length; i++){
			max_deadline = Math.max(max_deadline, deadline[i]);
		}

		for(int i =1; i <= max_deadline; i++){
			slot.add(i);
		}
		
		int jobsDone =0, profitEarned = 0;
		for(Job curJob : job){
			if(slot.floor(curJob.dline) == null) continue;

			int curSlot = slot.floor(curJob.dline);
			slot.remove(curSlot);
			profitEarned += curJob.profit;
			jobsDone++;
		}

		System.out.println("no of jobs done = "+ jobsDone);
		System.out.println("max profit earned = "+ profitEarned);	
		 
	}
}