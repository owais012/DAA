public class kmp{
	public static int [] computePrefix(String pattern){
		int m = pattern.length();
		int j = 0, i = 0;
		int prefix[] = new int[m];

		for(i = 1; i < m; i++){
			while(j < 0 && pattern.charAt(i) != pattern.charAt(j)){
				j = prefix[j-1];
			}
			if(pattern.charAt(i) == pattern.charAt(j)){
				j++;
			}

			prefix[i] = j;
		}
		return prefix;
	}	
	

	public static void main(String args[]){
		String pattern = "aabadssa";
		String text = "adascdfdfaabadssadfdfdsezxasaas";
		int prefix [] = computePrefix(pattern);
		int j = 0;
		int m = pattern.length();

		for(int i =0; i < text.length(); i++){
			while(j > 0 && pattern.charAt(j) != text.charAt(i)){
				j = prefix[j-1];
			}
				
			if(pattern.charAt(j) == text.charAt(i)) j++;
			if(j == m){
				System.out.println("String matched :)");
				j = prefix[j-1];   // reset the j pointer to find the further matches
				return;  	   // then do not return from the function
			}
		}
		
		System.out.println("The String did not match :(");
			
	}
}