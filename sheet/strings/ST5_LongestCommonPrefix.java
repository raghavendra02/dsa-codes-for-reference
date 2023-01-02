/**
 * ST5_LongestCommonPrefix
 */
public class ST5_LongestCommonPrefix {
    public static String longestCommonPrefix(String strs[]) {
        int prefix_len = strs[0].length();
        for(int i=1;i<strs.length;i++)
        {
            int j = 0;
            while(j < prefix_len && j < strs[i].length())
            {
                if(strs[0].charAt(j) == strs[i].charAt(j))
                {
                    j++;
                }
                else
                    break;
            }
            prefix_len = j;
        }
        String prefix = "";
        for(int i=0;i<prefix_len;i++)
        {
            prefix += strs[0].charAt(i);
        }
        return prefix;
    }
    public static void main(String[] args) {
        String strs[] = {"flower","flow","flowat"};
        System.out.println(longestCommonPrefix(strs));
    }
}