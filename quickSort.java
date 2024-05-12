public class quickSort{
	public static int getPartition(int left ,int right, int arr[]){
		int pivot = arr[left];

		int i = left, j = right;
		do{
			while(	 && arr[i] <= pivot)i++;
			while(arr[j] > pivot)j--;
			if(i < j){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			
		}while(i < j);
		int temp = arr[left];
		arr[left] = arr[j];
		arr[j] = temp;
		return j;
	}
	
	public static void quickSort(int left, int right, int arr[]){
		if(left < right){
			int partition = getPartition(left, right, arr);
			quickSort(left, partition-1, arr);
			quickSort(partition+1, right, arr);
		}
	}

	public static void main(String args[]){
		int arr[] = new int []{4,65,4,85,2,6,4,9,1,4,6};
		
		quickSort(0, arr.length-1, arr);
		for(int i =0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}
		
}