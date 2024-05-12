public class mergeSort{
	public static void sort(int low, int mid,int high, int arr[]){
		int i = low, j = mid+1, k = low;
		int B[] = new int[arr.length];
		
		while(i <= mid && j <= high){
			if(arr[i] < arr[j]){
				B[k++] = arr[i];
				i++;
			}else{
				B[k++] = arr[j];
				j++;
			} 
		}
		
		while(i <= mid)B[k++] = arr[i++];
		while(j <= high)B[k++] = arr[j++];
		
		for(i = low; i <= high; i++){
			arr[i] = B[i];
		}
	}

	public static void merge(int low, int high, int arr[]){
		int mid = 0;
		if(low < high){
			mid = (low + high)/2;
			merge(low, mid, arr);
			merge(mid+1, high, arr);
			sort(low, mid, high, arr);
		}
	}

	public static void main(String args[]){
		int arr[] = new int[]{4,5,7,2,6,8,41,70,5};
		merge(0, arr.length-1, arr);
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}

}