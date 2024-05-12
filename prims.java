import java.util.*;

class Pair{
	int dist, node;
	Pair(int n, int d){
		dist = d;
		node = n;
	}
}

public class prims{
	public static int solvePrims(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj){
		int vis[] = new int[V];
		PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.dist - y.dist);
		int sum = 0;
		int parent[] = new int [V];
		parent[0] = -1;
		pq.add(new Pair(0,0));

		while(!pq.isEmpty()){
			int node = pq.peek().node;	
			int wt = pq.peek().dist;
			pq.poll();
			
			if(vis[node] == 1) continue;
			
			vis[node] = 1;	
			sum += wt;
	
			for(int i = 0; i < adj.get(node).size(); i++){
				int adjNode = adj.get(node).get(i).get(0);
				int edgeWt = adj.get(node).get(i).get(1);

				if(vis[adjNode] == 0){
					
					pq.add(new Pair(adjNode, edgeWt));
				
				}
			}
		}
		return sum;
	
	}

	public static void main(String args[]){
		int V = 4;
		ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
		for(int i = 0; i <  V; i++){
			adj.add(new ArrayList<>());
		}

		adj.get(0).add(new ArrayList<>(Arrays.asList(1,1)));
		adj.get(0).add(new ArrayList<>(Arrays.asList(2,5)));
		adj.get(0).add(new ArrayList<>(Arrays.asList(3,2)));
		adj.get(0).add(new ArrayList<>(Arrays.asList(0,1)));
		adj.get(0).add(new ArrayList<>(Arrays.asList(0,5)));
		adj.get(0).add(new ArrayList<>(Arrays.asList(3,2)));
		adj.get(0).add(new ArrayList<>(Arrays.asList(2,3)));
		adj.get(0).add(new ArrayList<>(Arrays.asList(0,2)));

		System.out.println(solvePrims(4,adj)); 
	}

}