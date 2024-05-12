import java.util.*;
class Pair{
	int dist, node;
	Pair(int n, int d){
		node = n;
		dist = d;
	}
}

public class dijkistra{

	public static int [] dij(int S, int V, ArrayList<ArrayList<ArrayList<Integer>>> adj ){
		int dist[] = new int [V];
		PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.dist - y.dist);

		Arrays.fill(dist, (int)1e9);
		dist[S] = 0;
		pq.add(new Pair(S, 0));

		while(!pq.isEmpty()){
			int node = pq.peek().node;
			int dis = pq.peek().dist;
			pq.poll();

			for(int i =0; i < adj.get(node).size(); i++){
				int curNode = adj.get(node).get(i).get(0);
				int edgeWt = adj.get(node).get(i).get(1);

				if(dis + edgeWt < dist[curNode]){
					dist[curNode] = dis + edgeWt;
					pq.add(new Pair(curNode, dist[curNode]));
				}
			}
			
		}
		
		return dist;
	 
	}

	public static void main(String args []){
		ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
		int V = 3;

		for(int i =0; i < V; i++){
		 	adj.add(new ArrayList<>(new ArrayList<>()));
		}
		
		adj.get(0).add(new ArrayList<>(Arrays.asList(1,5)));
		adj.get(0).add(new ArrayList<>(Arrays.asList(2, 11)));
		adj.get(1).add(new ArrayList<>(Arrays.asList(0, 5)));
		adj.get(1).add(new ArrayList<>(Arrays.asList(2, 3)));
		adj.get(2).add(new ArrayList<>(Arrays.asList(0, 11)));
		adj.get(2).add(new ArrayList<>(Arrays.asList(1, 3)));

		int dist[] = dij(0, 3, adj);

		for(int i =0; i < dist.length; i++){
			System.out.print(dist[i] + " ");
		}
	}
}