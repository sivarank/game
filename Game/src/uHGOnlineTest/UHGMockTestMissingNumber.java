package uHGOnlineTest;

import java.util.Arrays;

public class UHGMockTestMissingNumber {

	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int[] test = new int[4];
		System.out.println(sol.solution(test));
	}
}

class Solution2 {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        //skip negative numbers in A
        int i=0;
        while( i< A.length && A[i] <1){
            i++;
        }
        // all are negative numbers
        if(i==A.length){
            return 1;
        }
        //first +ve number is not one
        if(A[i] != 1){
            return 1;
        }
        while((i+1)<A.length){
            if(A[i+1]- A[i] > 1){
                return A[i]+1;
            }
            i++;
        }
        return A[i]+1;
    }
}