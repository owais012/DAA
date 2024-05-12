import java.util.*;

public class hamiltonion{
	private static int NODE = 5;
	
	private static int graph[][] = new int[][]{
					{0,1,0,1,0},
					{1,0,1,1,1},	
					{0,1,0,0,1},
					{1,1,0,0,1},
					{0,1,1,1,0}
	};

	private static int [] path = new int [NODE];
	
	public static void display(){
		for(int i =0; i < NODE; i++){
			System.out.print(path[i] + " ");
		}
	}	
	
	public static boolean isValid(int v, int k){
		//check if there is between current and previous node;
		if(graph[path[k-1]][v] == 0) return false;

		for(int i =0; i <k; i++){
			if(path[i] == v) return false;
		}

		return true;
	}
	
	public static boolean isCycle(int k){
		if(k == NODE){
			if(graph[path[k-1]][0] == 1) return true;
			return false;
		}

		//Else we are adding each vertices except for the starting
		for(int v = 0; v < NODE; v++){
			if(isValid(v, k)){
				path[k] = v;
				if(isCycle(k+1)) return true;
				path[k] = -1;
			}
		}
		return false;
	}

	public static void main(String args[]){
		Arrays.fill(path, -1);
		path[0] = 0;
	
		if(isCycle(1)){
			display();
		}else{
			System.out.println("Cycle is found");
		}
	}

}