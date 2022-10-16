
/**
 * DP_3_FrogJump
 */

import java.lang.Math;
import java.util.Arrays;

public class DP_3_FrogJump {
    public static int countSteps_R(int[] H, int n) {
        if (n == 0) {
            return 0;
        }
        int left = countSteps_R(H, n - 1) + Math.abs(H[n] - H[n - 1]);
        int right = Integer.MAX_VALUE;
        if (n > 1) {
            right = countSteps_R(H, n - 2) + Math.abs(H[n] - H[n - 2]);
        }
        return Math.min(left, right);
    }

    public static int countSteps_DP(int[] H, int n, int[] dp) {
        if (n == 0)
            return 0;
        if (dp[n] != -1)
            return dp[n];
        int left = countSteps_DP(H, n - 1, dp) + Math.abs(H[n] - H[n - 1]);
        int right = Integer.MAX_VALUE;
        if (n > 1) {
            right = countSteps_DP(H, n - 2, dp) + Math.abs(H[n] - H[n - 2]);
        }
        return dp[n] = Math.min(left, right);
    }

    public static int countSteps_T(int[] H, int n, int[] dp) {
        dp[0] = 0;
        int fs, i, ss=Integer.MAX_VALUE;
        for (i = 1; i <= n; i++) {
            fs=dp[i-1]+Math.abs(H[i]-H[i-1]);
            if(i>1){
                ss=dp[i-2]+Math.abs(H[i]-H[i-2]);
            }
            dp[i]=Math.min(fs, ss);
        }
        return dp[i-1];
    }

    public static int countSteps_SO(int[] H, int n) {
        int prev = 0;
        int prev2 = 0;
        for (int i = 1; i <= n; i++) {
            int jump2=Integer.MAX_VALUE;
            int jump1=prev+Math.abs(H[i]-H[i-1]);
            if(i>1){
                jump2=prev2+Math.abs(H[i]-H[i-2]);
            }
            int curr=Math.min(jump1, jump2);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        int H[] = { 30, 10, 60, 10, 60, 50 };
        int n = H.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(countSteps_T(H, n - 1, dp));
        System.out.println(countSteps_SO(H, n - 1));
    }
}