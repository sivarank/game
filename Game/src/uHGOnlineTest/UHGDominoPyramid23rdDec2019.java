/**
 * UHG question https://stackoverflow.com/questions/52340958/checking-the-validity-of-a-pyramid-of-dominoes .
 * 
 * I took almost two hours to complete this question
 * 
 * 
 */
package uHGOnlineTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UHGDominoPyramid23rdDec2019 {
    private static void swap(int[] B, int index1, int index2){
        if(index1 != index2){
            int temp1 = B[2*index1];
            int temp2 = B[2*index1 + 1];
            B[2*index1] = B[2*index2];
            B[2*index1 + 1] = B[2*index2+1];
            B[2*index2] = temp1;
            B[2*index2+1] = temp2;
        }
    }
    private static boolean permute(int[] B, int start, int end){
        if(start == end){
            // check solution
            return B[0] == B[3] && B[1] == B[4] && B[2] == B[7] && B[3] == B[8] 
            && B[4] == B[9] && B[5] == B[10];
        }
        for(int i =start; i<=end; i++){
            swap(B, i, start);
            boolean result = permute(B, start+1, end);
            swap(B, i, start);
            if(result){
                return true;    
            }
        }
        return false;
    }
    
    
	public static void main(String[] args) {
		int[] A = {3,4,3,4,1,2,2,3,5,6,4,5};
        for(int i =0; i< 64; i++){
            int[]  B = new int[12];
            for(int j=0; j<6; j++){
                // j th Domino needs to be rotated if 1 bit set
                if((i & 1<<j) > 0){
                    B[2*j] = A[2*j + 1];
                    B[2*j +1] = A[2*j];
                }else{
                    B[2*j] = A[2*j];
                    B[2*j+1] = A[2*j +1];
                }
            }
            boolean result = permute(B, 0, 5);
            if(result){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
	}
}
//
//class Domino{
//	int first;
//	int second;
//	boolean used = false;
//	public Domino(int a, int b) {
//		first = a;
//		second =b;
//	}
//	public boolean getUsage() {
//		return used;
//	}
//	
//	public void setUsage(boolean val) {
//		used = val;
//	}
//	
//	public int getFirst() {
//		return first;
//	}
//	public int getSecond() {
//		return second;
//	}
//}
//class Solution1 {
//    public int solution(int[] A) {
//        // write your code in Java SE 8
//        Arrays.sort(A);
//        //skip negative numbers in A
//        int i=0;
//        while( i< A.length && A[i] <1){
//            i++;
//        }
//        // all are negative numbers
//        if(i==A.length){
//            return 1;
//        }
//        //first +ve number is not one
//        if(A[i] != 1){
//            return 1;
//        }
//        while((i+1)<A.length){
//            if(A[i+1]- A[i] > 1){
//                return A[i]+1;
//            }
//            i++;
//        }
//        return A[i]+1;
//    }
//}