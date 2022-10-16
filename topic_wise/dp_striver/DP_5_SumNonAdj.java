/**
 * DP_5_SumNonAdj
 */

import java.util.Arrays;

public class DP_5_SumNonAdj {
    public static int findSum(int[] a, int n) {
        if(n==0) return a[0];
        if(n<0) return 0;
        int pick=a[n]+findSum(a, n-2);
        int not_pick=0+findSum(a, n-1);
        return Math.max(pick, not_pick);
    }
    public static int findSum_DP(int[] a, int n, int[] dp) {
        if(n==0) return a[0];
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        int pick=a[n]+findSum_DP(a, n-2, dp);
        int not_pick=0+findSum_DP(a, n-1, dp);
        return dp[n]=Math.max(pick, not_pick);
    }
    public static void main(String[] args) {
        int[] a={2,1,4,9};
        int n=a.length;
        int[] dp=new int[n];
        Arrays.fill(dp, -1);
        // System.out.println(findSum(a, n-1));
        System.out.println(findSum_DP(a, n-1, dp));
    }
}