import java.util.*;

public class bellmanFord{
	public static int[] dist(int V, int S,  ArrayList<ArrayList<Integer>> edges){
		int dist[] = new int[V];
		Arrays.fill(dist, (int) 1e8);
		dist[S] = 0;
		
		for(int i = 0; i < V-1; i++){
			for(ArrayList<Integer> it : edges){
				int u = it.get(0);
				int v = it.get(1);
				int wt = it.get(2);

				if(dist[u] != (int) 1e9 && dist[u] + wt < dist[v]){
					dist[v] = dist[u] + wt;
				}
			}
		}
		
		for(ArrayList<Integer> it : edges){
				int u = it.get(0);
				int v = it.get(1);
				int wt = it.get(2);

				if(dist[u] != (int) 1e9 && dist[u] + wt < dist[v]){
					return new int[]{-1};
				}
			}

		return dist;
	
	}

	public static void main(String args[]){
		ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
		edges.add(new ArrayList<Integer>(Arrays.asList(3,2,6)));
		edges.add(new ArrayList<Integer>(Arrays.asList(5,3,1)));
		edges.add(new ArrayList<Integer>(Arrays.asList(0,1,5)));
		edges.add(new ArrayList<Integer>(Arrays.asList(1,5,-3)));				
		edges.add(new ArrayList<Integer>(Arrays.asList(1,2,-2)));
		edges.add(new ArrayList<Integer>(Arrays.asList(3,4,-2)));
		edges.add(new ArrayList<Integer>(Arrays.asList(2,4,3)));
		
		int V = 6;
		int dist[] = dist(V, 0, edges);
		
		for(int i = 0; i < dist.length; i++){
			System.out.print(dist[i]+" ");
		}

	}
}