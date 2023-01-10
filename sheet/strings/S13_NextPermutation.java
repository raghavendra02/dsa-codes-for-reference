/**
 * S13_NextPermutation
 */
public class S13_NextPermutation {
    public static String NextPermutation(String s) {
        char[] arr = s.toCharArray();
        int i=s.length()-1;
        while(i>=0 && arr[i]<arr[i-1])
            i--;
        int j=s.length()-1;
        while(j>i && arr[j]>arr[i])
            j--;
        
        char temp = arr[i-1]; // pivot
        arr[i-1] = arr[j];
        arr[j] = temp; // successor form right
            
        //l=i
        //r=j

        j=s.length()-1;

        while(i<j)
        {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
        return String.valueOf(arr);
    }
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(NextPermutation(s));
        String s2 = "abcd";
        System.out.println(NextPermutation(s2));
    }
}