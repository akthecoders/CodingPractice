package OrderStatistics;

/**
 * MaxElementToAddToMakeMedianEqualToX
 */
public class MaxElementToAddToMakeMedianEqualToX {

    public static void main(String[] args) {
        int x = 10; 
        int a[] = { 10, 20, 30 }; 
        int n = a.length; 
        System.out.println( minNumber(a, n, x) );
    }

    public static int minNumber(int[] arr, int n, int k) {
        int l = 0, h = 0, e = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] < k){
                l++;
            }
            else if(arr[i] == k){
                e++;
            }
            else if(arr[i] > k){
                h++;
            }
        }
        int ans = 0;
        if(l > h) {
            ans = l - h;
        }
        else if(l < h) {
            ans = h - l - 1;
        }
        return ans - e + 1;
    }
}