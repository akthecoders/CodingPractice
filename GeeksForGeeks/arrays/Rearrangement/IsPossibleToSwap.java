package Rearrangement;

import java.util.HashMap;

/**
 * IsPossibleToSwap
 */
public class IsPossibleToSwap {

    public static void main(String[] args) {
        int a[] = { 7, 7, 7, 7 }; 
        int n = 4; 
        distinctAdjacentElement(a, n); 
    }

    public static void distinctAdjacentElement(int[] a, int n) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; ++i){ 
            if(m.containsKey(a[i])){ 
                int x = m.get(a[i]) + 1; 
                m.put(a[i],x);  
            } 
            else{ 
                m.put(a[i],1); 
            } 
        }

        int mx = 0;
        for (int i = 0; i < n; ++i) 
        if (mx < m.get(a[i])) 
            mx = m.get(a[i]);
        
        if (mx > (n + 1) / 2) 
            System.out.println("NO"); 
        else
            System.out.println("YES"); 
    }
}