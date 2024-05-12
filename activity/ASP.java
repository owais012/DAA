import java.util.*;

class Activity{
	int start;
	int end;
	int actNo;
	Activity(int st, int ed, int an){
		start = st;
		end = ed;
		actNo = an;
	}
}

public class ASP{
	public static void main(String args[]){
		int start[] = new int[]{1, 0, 1, 4, 2, 5, 3, 4};
		int finish[] = new int[]{3, 4, 2, 6, 9, 8 ,5 ,5};

		ArrayList<Activity> act = new ArrayList <>();
		for(int i =0; i < start.length; i++){
			act.add(new Activity(start[i], finish[i], i+1));
		}
		
		Collections.sort(act, new Comparator<Activity>(){
			public int compare(Activity a1, Activity a2){
				return a1.end - a2.end;			
			}		
		});		

		ArrayList<Integer> ans = new ArrayList <>();
		int j = 0;
		ans.add(act.get(0).actNo);
		for(int i = 1; i < start.length; i++){
			if(act.get(j).end <= act.get(i).start){
				ans.add(act.get(i).actNo);
				j = i;
			}

		}

		System.out.println(ans);
	}
}