/**
 * ST6_KeypadSequence
 */
public class ST6_KeypadSequence {
    public static String printSequence(String str[], String s) {
        String n = "";
        s = s.toUpperCase();
        for(char c: s.toCharArray())
        {
            if(c == ' ')
                n += '0';
            else
                n += str[c-'A'];
        }
        return n;
    }
    public static void main(String[] args) {
        // storing the sequence in array
        String str[] = { "2", "22", "222", "3", "33", "333",
                "4", "44", "444", "5", "55", "555",
                "6", "66", "666", "7", "77", "777",
                "7777", "8", "88", "888", "9", "99",
                "999", "9999" };

        String input = "GEEKS FOR GEEKS";
        System.out.println(printSequence(str, input));
    }
}