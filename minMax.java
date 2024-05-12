class Pair{
	int min, max;
	Pair(int min, int max){
		this.min = min;
		this.max = max;
	}
}

public class minMax{

	public static Pair findMinMax(int arr[], int start, int end){
		//If there is only one element in the list;
		if(start == end){
			return new Pair(arr[start], arr[start]);
		}
		
		int mid = (start + end)/2;
		
		// Divide the array into halves and recursively find min and max in each half
		Pair leftPair = findMinMax(arr, start, mid);
		Pair rightPair = findMinMax(arr, mid+1, end);

		//Combine the result from the two halves
		int min_val = Math.min(leftPair.min, rightPair.min);
		int max_val = Math.max(rightPair.max, leftPair.max);

		return	new Pair(min_val, max_val);
	}

	public static void main (String args[]){
		int arr[] = new int []{-1,0,5,6,7,91,100};
		int n = arr.length;
		Pair ans = findMinMax(arr, 0, n-1);

		System.out.println(ans.min);
		System.out.println(ans.max);
			
	}	
	
}