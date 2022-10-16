import java.util.Arrays;

/**
 * DP_6_HouseRobber2
 */
public class DP_6_HouseRobber2 {
    public static int robHouse_(int a[], int n) {
        if(n==0) return a[0];
        if(n<0) return 0;
        int pick=a[n]+robHouse_(a, n-2);
        int not_pick=0+robHouse_(a, n-1);
        return Math.max(pick, not_pick);
    }

    public static int robHouse(int a[], int n) {
        if(n==1) return a[0];
        int[] temp1=new int[n];
        int[] temp2=new int[n];
        for(int i=0;i<=n;i++){
            if(i!=0){
                temp1[i-1]=a[i];
            }
            if(i!=n){
                temp2[i]=a[i];
            }
        }
        return Math.max(robHouse_(temp1, n-1), robHouse_(temp2, n-1));
    }
    public static void main(String[] args) {
        int[] a={2,1,4,9};
        int n=a.length;
        int[] dp=new int[n];
        Arrays.fill(dp, -1);
        System.out.println(robHouse(a, n-1));
        // System.out.println(robHouse_DP(a, n-1, dp));
    }
}