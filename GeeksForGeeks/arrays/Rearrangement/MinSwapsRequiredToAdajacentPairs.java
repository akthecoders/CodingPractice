package Rearrangement;

/**
 * MinSwapsRequiredToAdajacentPairs
 */
public class MinSwapsRequiredToAdajacentPairs {
    static void updateindex(int index[], int a, 
                        int ai, int b, int bi) 
    { 
        index[a] = ai; 
        index[b] = bi; 
    } 
    
    static int minSwapsUtil(int arr[], int pairs[], 
                        int index[], int i, int n) 
    { 
        if (i > n) 
        return 0; 
        if (pairs[arr[i]] == arr[i + 1]) 
        return minSwapsUtil(arr, pairs, index, i + 2, n); 
        int one = arr[i + 1]; 
        int indextwo = i + 1; 
        int indexone = index[pairs[arr[i]]]; 
        int two = arr[index[pairs[arr[i]]]]; 
        arr[i + 1] = arr[i + 1] ^ arr[indexone] ^ 
                    (arr[indexone] = arr[i + 1]); 
        updateindex(index, one, indexone, two, indextwo); 
        int a = minSwapsUtil(arr, pairs, index, i + 2, n); 
        arr[i + 1] = arr[i + 1] ^ arr[indexone] ^ 
                    (arr[indexone] = arr[i + 1]); 
        updateindex(index, one, indextwo, two, indexone); 
        one = arr[i]; 
        indexone = index[pairs[arr[i + 1]]]; 
        two = arr[index[pairs[arr[i + 1]]]]; 
        indextwo = i; 
        arr[i] = arr[i] ^ arr[indexone] ^ (arr[indexone] = arr[i]); 
        updateindex(index, one, indexone, two, indextwo); 
        int b = minSwapsUtil(arr, pairs, index, i + 2, n); 
        arr[i] = arr[i] ^ arr[indexone] ^ (arr[indexone] = arr[i]); 
        updateindex(index, one, indextwo, two, indexone); 
    
        return 1 + Math.min(a, b); 
    } 
    
    static int minSwaps(int n, int pairs[], int arr[]) 
    { 
        int index[] = new int[2 * n + 1]; 
    
        for (int i = 1; i <= 2 * n; i++) 
        index[arr[i]] = i; 
    
        return minSwapsUtil(arr, pairs, index, 1, 2 * n); 
    } 
    
    public static void main(String[] args) { 
        
        int arr[] = {0, 3, 5, 6, 4, 1, 2}; 
    
        int pairs[] = {0, 3, 6, 1, 5, 4, 2}; 
        int m = pairs.length; 
    
        int n = m / 2; 
    
        System.out.print("Min swaps required is " + 
                        minSwaps(n, pairs, arr)); 
    }     
}