/**
 * ST7_PrintDuplicates
 */
public class ST7_PrintDuplicates {
    public static void printDuplicates(String s) {
        int hash[] = new int[26];
        s = s.toLowerCase();
        for(char c: s.toCharArray())
        {
            hash[c-'a']++;
        }
        // wrong approach, coz we need i not just char at i
        // for(int n: hash)
        // {
        //     if(n>1)
        //         System.out.println((char)(+'a'));
        // }
        for(int i=0;i<hash.length;i++)
        {
            if(hash[i]>1)
                System.out.println((char)(i+'a'));
        }
    }
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        printDuplicates(s);
    }
}