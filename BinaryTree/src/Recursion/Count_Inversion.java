package Recursion;

import java.util.Arrays;

public class Count_Inversion {
	public static int count(int[] A){
		
		 return solve(A, 0, A.length -1);
	}
	
	private static int solve(int[] A, int start, int end) {
		if(start >= end) return 0;
		int mid = start +(end -start)/2;
		
		return solve(A, start, mid) + solve(A, mid+1, end) + merge(A, start, mid, end);
		
		
	}

	private static int merge(int[] A, int start, int mid, int end) {
		int inversions = 0;
		int lo = start;
		int hi = mid+1;
		int[] B = new int[(end-start)+1];
		int index = 0;
		
		while(lo <= mid && hi <= end){
			if(A[lo] <= A[hi]){
				B[index++] = A[lo++];
			}else{
				B[index++] = A[hi++];
				inversions = inversions + (mid - lo)+1;
			}
		}
		
		while(lo <= mid){
			B[index++] = A[lo++];
		}
		
		while(hi <= end){
			B[index++] = A[hi++];
		}
		
		for(int i = 0; i < B.length; i++){
			A[start+i] = B[i];
		}
		
		return inversions;
	}

	public static void main(String[] args) {
		int[] A = new int[]{1,3, 5, 2, 7, 4, 1};
		System.out.println(count(A));
		System.out.println(Arrays.toString(A));
	}

}
