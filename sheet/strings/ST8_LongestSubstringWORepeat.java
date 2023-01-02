import java.util.Arrays;
import java.util.HashMap;

/**
 * ST8_LongestSubstringWORepeat
 */
public class ST8_LongestSubstringWORepeat {
    // OG code wrong
    // Think about this later
    public static int lengthOfLongestSubstring1(String st) {
        int n, s, e;
        n = s = e = 0;
        int count[] = new int[26];
        Arrays.fill(count, 0);
        while(e<st.length())
        {
            if(count[st.charAt(e)-'a']==0)
            {
                count[st.charAt(e)-'a']=1;
                e++;
                n=Math.max(n, e-s);
            }
            else
            {
                count[e]=0;
                while(s>0 && s<st.length() && count[st.charAt(s)-'a']!=0) s++;
                s++;
                count[e]=1;
                e++;
                n=Math.max(n, e-s);
            }
        }
        return n;
    }

public static int lengthOfLongestSubstring(String s) {
    int l, r, len;
    l=r=len=0;
    HashMap<Character, Integer> m = new HashMap<Character, Integer>();
    while(r<s.length())
    {
        if(m.containsKey(s.charAt(r)))
        {
            if(m.get(s.charAt(r))>=l)
            {
                l=m.get(s.charAt(r))+1;
            }
        }
        m.put(s.charAt(r), r);
        len= Math.max(len, r-l+1);
        r++;
    }
    return len;
}
    public static void main(String[] args) {
        // String s = "abcabcbb";
        // String s = "bbbbb";
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}