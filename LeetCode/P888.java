//Fair Candy Swap
public class P888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int candyPair[] = new int[2];
        int count1 = 0;
        int count2 = 0;
        for(int x: A) count1 += x;
        for(int x: B) count2 += x;
        
        int required = Math.abs(count1 - count2) / 2;
        
        if(count1 > count2) {
            for(int i = 0;i < A.length; i++) {
                for(int j = 0; j < B.length; j++) {
                    if(Math.abs(A[i] - B[j]) == required) {
                        if(A[i] - B[j] == required) {
                            candyPair[0] = A[i];
                            candyPair[1] = B[j];
                            return candyPair;
                        }
                    }
                }
            }
        }
        else {
            for(int i = 0;i < A.length; i++) {
                for(int j = 0; j < B.length; j++) {
                    if(Math.abs(A[i] - B[j]) == required) {
                        if(B[j] - A[i] == required) {
                            candyPair[0] = A[i];
                            candyPair[1] = B[j];
                            return candyPair;
                        }
                    }
                }
            }
        }
        return candyPair;
    }  
}