package uHGOnlineTest;

import java.util.Arrays;

public class UHGArrangement23rdDec2019 {
    private static boolean arrangement(int A, int B, char[] ans, int index){
    	if(A == 0 && B == 0) {
    		return true;
    	}
        if(A>0){
            if((index < 2) || !(ans[index-1] == 'a' && ans[index-2] == 'a') ){
                ans[index] = 'a';
                if(arrangement( A-1, B, ans, index+1)){
                    return true;
                }
            }
        }
        if(B>0){
            if((index < 2) || !(ans[index-1] == 'b' && ans[index-2] == 'b') ){
                ans[index] = 'b';
                if(arrangement( A, B-1, ans, index+1)){
                    return true;
                }
            }
        }
        return false;
    }
    
	public static void main(String[] args) {
		char[] ans = new char[8];
        boolean result = arrangement(5,3, ans, 0);
        if(result) {
            System.out.println(new String(ans));
        }

	}
}

class Solution {

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