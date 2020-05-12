//Grumpy Bookstore Owner
public class P1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int res = 0, curr = 0, max = 0;
        int n = customers.length;
        for(int i = 0, j = 0; j < n; j++) {
            if(grumpy[j] == 0) res += customers[j];
            else curr += customers[j];
            
            if(j - i + 1 == X) {
                max = Math.max(max, curr);
                if(grumpy[i] == 1) {
                    curr -= customers[i];
                }
                i++;
            }
        }
        
        return res + max;
    }
}