//User function Template for Java
/**
 * ST4_RemoveConsecutive
 */
public class ST4_RemoveConsecutive {

    
}

class Solution{
    public static String removeConsecutiveCharacter(String S){
        String new_string = new String();
        for(int i=0;i<S.length()-1;i++)
        {
            if(S.charAt(i)!=S.charAt(i+1))
            {
                new_string += S.charAt(i);
            }
        }
        new_string += S.charAt(S.length()-1);
        // int ptr1=0;
        // int ptr2=1;
        // while(ptr2<S.length())
        // {
        //     if(S.charAt(ptr1)!=S.charAt(ptr2))
        //     {
        //         new_string += S.charAt(ptr1);
        //         ptr2++;
        //         ptr1=ptr2-1;
        //     }
        //     else
        //     {
        //         ptr2++;
        //     }
        // }
        // new_string += S.charAt(S.length()-1);
        return new_string;
    }
    public static void main(String[] args) {
        String s1 = "aabbbefccccccda";
        String s = removeConsecutiveCharacter(s1);
        System.out.println(s1);
        System.out.println(s);
    }
}