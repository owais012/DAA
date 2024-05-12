public class naiveString{
	
	public static void main(String args[]){
		String text = "abaabacabcabd";
		String pattern = "abz";
		
		for(int i =0; i < text.length(); i++){
			for(int j = 0; j < pattern.length(); j++){
				if(text.charAt(i) != pattern.charAt(j)) continue;
				if(j == pattern.length()-1){
					System.out.println("pattern matched at index at "+ i);
					return;
				}
			}
			
		}
		
		System.out.println("Pattern didn't match");
	}

}