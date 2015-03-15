package Recursion;

public class Subsets {

	public static void generate(int[] A){
		boolean[] b = new boolean[A.length];
		backtrack(A, b, 0);
	}
	
	
	private static void backtrack(int[] a, boolean[] b, int i) {
		
		if(i >= a.length){
			processSolution(a, b);
			return;
		}
		
		b[i] = true;
		backtrack(a, b, i+1);
		b[i] = false;
		backtrack(a, b, i+1);
		
	}


	private static void processSolution(int[] a, boolean[] b) {
		for(int i = 0; i < a.length; i++){
			if(b[i]) System.out.print(a[i] );
		}
		System.out.println("");
		
	}


	public static void main(String[] args) {
		generate(new int[]{1, 2, 3});
		

	}

}
