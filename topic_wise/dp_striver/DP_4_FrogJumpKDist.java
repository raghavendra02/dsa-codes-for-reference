/**
 * DP_4_FrogJumpKDist
 */

import java.lang.Math;
import java.util.Arrays;

public class DP_4_FrogJumpKDist {
    public static int countStepsK(int[] H, int n, int k) {
        if(n==0) return 0;
        int new_jump=0, min=Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if(n-i>=0){
                new_jump=countStepsK(H, n-i, k)+Math.abs(H[n]-H[n-i]);
                min=new_jump<min?new_jump:min;
            }
        }
        return min;
    }

    public static int countStepsK_DP(int[] H, int n, int k, int[] dp) {
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int min=Integer.MAX_VALUE;
        int new_jump;
        for(int i=1;i<=k;i++){
            new_jump=countStepsK(H, n-i, k)+Math.abs(H[n]-H[n-i]);
            min=new_jump<min?new_jump:min;
        }
        return dp[n]=min;
    }

    public static void main(String[] args) {
        int H[] = { 30, 10, 60, 10, 60, 50 };
        int n = H.length;
        int k=5;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(countStepsK_DP(H, n - 1, k, dp));
    }
}





// Older Approach:
// public static int countStepsK(int[] H, int n) {
//     if(n==0) return 0;
//     int new_jump, min=Integer.MAX_VALUE;
//     for(int i=n;i>0;i--){
//         new_jump=countStepsK(H, i-1)+Math.abs(H[i]-H[i-1]);
//         min=new_jump<min ? new_jump : min;
//     }
//     return min;
// }