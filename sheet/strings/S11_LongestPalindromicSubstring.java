/**
 * S11_LongestPalindromicSubstring
 */
public class S11_LongestPalindromicSubstring {
    public static boolean isPalindrome(String s, int l, int r) {
        while(l<r)
        {
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
    public static int lenPalindromeFromMiddle(String s, int l, int r) { // len of longest palindrome length from middle
        if(l>r)
            return 0;
        while(l>=0 && r<s.length())
        {
            if(s.charAt(l) != s.charAt(r))
                return r-l+1;
            l--;
            r++;
        }
        return r-l+1;
    }
    public static String longestPalindrome(String s) {
        int res_s=0;
        int res_e=0;
        for(int i=0;i<s.length();i++)
        {
            int len1 = lenPalindromeFromMiddle(s, i, i);
            int len2 = lenPalindromeFromMiddle(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len>res_e-res_s)
            {
                res_s=i-(len-1)/2;
                res_e=i+(len)/2;
            }
        }
        return s.substring(res_s, res_e); 
    }
    // bruteforce - Time Limit Exceeded
    public static String longestPalindromeTLE(String s) {
        int max=0;
        int res_start=0;
        int res_end=0;
        for(int i=0;i<s.length();i++)
        {
            for(int j=i;j<s.length();j++)
            {
                if(isPalindrome(s, i, j))
                {
                    if(j-i+1 > max)
                    {
                        max=j-i+1;
                        res_start=i;
                        res_end=j;
                    }
                }
            }
        }
        String res = new String();
        for(int i=res_start;i<=res_end;i++)
        {
            res += s.charAt(i);
        }
        return res;
    }

     
    public static void main(String[] args) {
        
    }
}