/**
 * S12_PalindromicSubstrings
 */
public class S12_PalindromicSubstrings {
    public static boolean isPalindrome(String s, int l, int r) {
        while(l<r)
        {
            if(s.charAt(l) != s.charAt(r))
                return false;
            else
            {
                l++;
                r--;
            }
        }
        return true;
    }
    public static int countSubstrings(String s) {
        int len=0;
        for(int i=0;i<s.length();i++)
        {
            for(int j=i;j<s.length();j++)
            {
                if(isPalindrome(s, i, j))
                    len++;
            }
        }
        return len;
    }
    public static void main(String[] args) {
        
    }
}