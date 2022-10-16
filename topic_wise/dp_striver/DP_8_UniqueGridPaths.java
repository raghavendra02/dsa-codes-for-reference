import java.util.* ;
import java.io.*; 
public class DP_8_UniqueGridPaths {
    public static int uniquePaths_tab(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 && j==0){
                    dp[0][0]=1;
                }
                int up=0, left=0;
                if(i>0) up = dp[i-1][j];
                if(j>0) left = dp[i][j-1];
                dp[i][j]=up+left;
            }
        }
        return dp[m][n];
    }
    public static int uniquePaths_dp(int m, int n, int dp[][]) {
        if(m==0 && n==0){
            return 1;
        }
        if(m<0 || n<0){
            return 0;
        }
        if(dp[m][n]!=-1) return dp[m][n];
        int left = uniquePaths_dp(m, n-1, dp);
        int up = uniquePaths_dp(m-1, n, dp);
        return dp[m][n] = left+up;
    }
    public static int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return uniquePaths_dp(m-1, n-1, dp);
        return uniquePaths_tab(m-1, n-1, dp);
    }
}
