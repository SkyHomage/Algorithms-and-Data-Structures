package Recursion;

public class Permutations {
	static int count = 0;
	public static void generate(String s){
		
		backtrack(s,"", s.length());
	}

	private static void backtrack(String s, String a, int n) {
		
		if(a.length() == n){
			processSolution(a);
			return;
		}
		
		for(int i =0; i< s.length(); i++){
			backtrack(s.substring(0, i) + s.substring(i+1), a+s.charAt(i), n);
		}
		
	}

	private static void processSolution(String a) {
		count++;
		System.out.println(a + " " + count);
		
	}

	public static void main(String[] args) {
		generate("Hello");
	}

}
