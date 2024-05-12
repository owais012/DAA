import java.util.*;

public class rabinKalp{
	public static int calculateHash(String str){
		int hash = 0;
		for(char c : str.toCharArray()){
			hash = hash * 31 + c; 
		}
		return hash;
	}
	
	public static int updateHash(int hash, char oldChar, char newChar, int n) {
    		return (hash - oldChar * (int) Math.pow(31, n - 1)) * 31 + newChar;
	}

	
	public static void main(String args[]){
		String pattern = "abc";
		String text = "ababadacascasascabcads";
		
		int pattern_hash = calculateHash(pattern);
		int n = pattern.length();
		int curr_hash = calculateHash(text.substring(0, n));	

		for(int i = n; i <= text.length(); i++){
			if(curr_hash == pattern_hash && text.substring(i-n, i).equals(pattern)){
				System.out.println("Pattern matched at index " + (i-n));
				return;
			}
			if(i < text.length()){
				curr_hash = updateHash(curr_hash, text.charAt(i-n), text.charAt(i), n);
			}
		}

		System.out.println("The string do not matched");	
	}
}