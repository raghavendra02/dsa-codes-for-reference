import java.util.ArrayList;

/**
 * Rec_6_PrintAllSubSeq
 */
public class Rec_6_PrintAllSubSeq {
    public static void printSubSeq_help(int i, ArrayList<Integer> ds, int a[], int n) {
        if(i==n){
            // Printing
            // System.out.println(Arrays.toString(ds.toArray()));
            // System.out.println(ds);
            if(ds.size() == 0){
                System.out.println("{}");
                return;
            }
            for(Integer val: ds){
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }
        ds.add(a[i]);
        printSubSeq_help(i+1, ds, a, n);
        ds.remove(ds.size()-1); // popback(vector) in cpp
        printSubSeq_help(i+1, ds, a, n); // pushback(vector) in cpp
    }
    public static void printSubSeq(int a[]) {
        int n=a.length;
        ArrayList<Integer> ds=new ArrayList<Integer>();
        printSubSeq_help(0, ds, a, n);
    }
    public static void main(String[] args) {
        int a[] = {3,1,2};
        printSubSeq(a);
    }
}