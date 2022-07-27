// tournament - divide and conquer
// naive - TBD
// compare in pairs - TBD
public class A1_MaxMin{
    static class Pair {
        int min;
        int max;
    }
    public static Pair getMinMax(int a[], int low, int high) {
        Pair minMax = new Pair();
        // base case arr.length == 1
        if(low==high)
        {
            minMax.min=a[low];
            minMax.max=a[low];
            return minMax;
        }
        // base case arr.length == 2
        if(high==low+1)
        {
            if(a[low]<=a[high])
            {
                minMax.min=a[low];
                minMax.max=a[high];
            }
            else
            {
                minMax.min=a[high];
                minMax.max=a[low];
            }
            return minMax;
        }

        // divide
        Pair mml = new Pair();
        Pair mmr = new Pair();

        int mid = low+(high-low)/2;
        mml=getMinMax(a, low, mid);
        mmr=getMinMax(a, mid+1, high);

        // conquer

        if(mml.min<=mmr.min)
        {
            minMax.min=mml.min;
        }
        else
        {
            minMax.min=mmr.min;
        }
        if(mml.max>=mmr.max)
        {
            minMax.max=mml.max;
        }
        else
        {
            minMax.max=mmr.max;
        }

        return minMax;
    }
    
    public static void main(String[] args) {
        int arr[] = {1000, 11, 445, 1, 330, 3000};
        int arr_size = 6;
        Pair minmax = getMinMax(arr, 0, arr_size - 1);
        System.out.printf("Minimum element is %d\n", minmax.min);
        System.out.printf("Maximum element is %d", minmax.max);
    }
}