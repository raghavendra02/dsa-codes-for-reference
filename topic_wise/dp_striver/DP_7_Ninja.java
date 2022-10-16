import java.util.Arrays;

public class DP_7_Ninja {
    public static int countWays(int day, int last, int tasks[][]) {
        if(day==0){
            int max=0;
            for(int i=0;i<3;i++){
                if(last!=i){
                    max=Math.max(max, tasks[0][i]);
                }
            }
            return max;
        }
        int max=0;
        for(int i=0;i<3;i++){
            if(last!=i){
                int points=tasks[day][i]+countWays(day-1, i, tasks);
                max=Math.max(max, points);
            }
        }
        return max;
    }
    public static int countWays_DP(int day, int last, int tasks[][], int dp[][]) {
        if(day==0){
            int max=0;
            for(int i=0;i<3;i++){
                if(last!=i){
                    max=Math.max(max, tasks[0][i]);
                }
            }
            return max;
        }
        if(dp[day][last] != -1) return dp[day][last];
        int max=0;
        for(int i=0;i<3;i++){
            if(last!=i){
                int points=tasks[day][i]+countWays_DP(day-1, i, tasks, dp);
                max=Math.max(max, points);
            }
        }
        return dp[day][last] = max;
    }
    public static void main(String[] args) {
        int tasks[][] = {{2,1,3},
                        {3,4,6},
                        {10,1,6},
                        {8,3,7}};
        int n=tasks.length;
        System.out.println(countWays(n-1, 3, tasks));
        int dp[][] = new int[n][4];
        // Arrays.fill(dp, -1);
        for(int i=0;i<n;i++){
                Arrays.fill(dp[i], -1);
        }
        System.out.println(countWays_DP(n-1, 3, tasks, dp));
            
    }
}
