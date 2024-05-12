import java.util.*;

public class colorGraph{
	public static boolean isSafe(int node, int color[], int graph[][], int col){
		for(int i = 0; i < graph.length; i++){
			if(i != node && graph[node][i] == 1 && color[i] == col) return false;

		}
		return true;
	}

	public static boolean canColor(int node, int color[], int graph[][], int m){
		if(node == graph.length) return true;

		//try filling all possible colors
		for(int i = 1; i <= m; i++){
			if(isSafe(node, color, graph, i)){
				color[node] = i;
				if(canColor(node+1, color, graph, m)) return true;
				color[node] = 0;
			}
		}
		return false;
	}

	public static void main(String args[]){
		int N = 4;
		int m = 3;
		int color[] = new int [N];
		int graph[][] = new int [N][N];
		//Edges are (0, 1), (1,2), (2, 3), (3, 0), (0, 2)
		
		graph[0][1] = 1; graph[1][0] = 1;
		graph[1][2] = 1; graph[2][1] = 1;
		graph[2][3] = 1; graph[3][2] = 1;
		graph[3][0] = 1; graph[0][3] = 1;
		graph[0][2] = 1; graph[2][0] = 1;
			
		System.out.println(canColor(0, color, graph, m));
		for(int i = 0; i < color.length; i++){
			System.out.println(color[i] + " ");
		}
	}
}