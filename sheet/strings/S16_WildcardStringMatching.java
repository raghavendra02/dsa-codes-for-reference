/**
 * S16_WildcardStringMatching
 */
public class S16_WildcardStringMatching {
    public static boolean match(String wild, String pattern) {
        boolean dp[][] = new boolean[wild.length() + 1][pattern.length() + 1];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = true;
                } else if (i == dp.length - 1) {
                    dp[i][j] = false;
                } else if (j == dp[0].length - 1) {
                    if(wild.charAt(i) == '*'){
                        dp[i][j] = dp[i + 1][j];
                    }else{
                        dp[i][j] = false;
                    }
                } else {
                    if (wild.charAt(i) == '?') {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else if (wild.charAt(i) == '*') {
                        dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
                    } else if (wild.charAt(i) == pattern.charAt(j)) {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {

    }
}