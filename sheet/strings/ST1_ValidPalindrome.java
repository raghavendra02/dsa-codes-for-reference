// /**
//  * ST1_ValidPalindrome
//  */

public class ST1_ValidPalindrome {
    public static boolean isPalindrome(String s) {
        String new_string = "";
        for(char c: s.toCharArray())
        {
            if(Character.isDigit(c) || Character.isLetter(c))
            {
                new_string += c;
            }
        }

        new_string = new_string.toLowerCase();

        int start = 0;
        int end = new_string.length()-1;

        while(start < end)
        {
            if(new_string.charAt(start) != new_string.charAt(end))
            {
                return false;
            }
            ++start;
            --end;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        // String s = "race a car";
        // String s = " ";
        if(isPalindrome(s))
        System.out.println("Palindrome");
        else
        System.out.println("Not palindrome");

    }
}