
class P832 {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0; i < A.length; i++) {
            reverse(A[i], 0, A[0].length - 1);
        }
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                A[i][j] = (A[i][j] == 1) ? 0 : 1;
            }
        }
        return A;
    }
    
    public void reverse(int[] A, int start, int end) {
        if(start > end) {
            return;
        }
        int temp = A[start];
        A[start] = A[end];
        A[end] = temp;
        
        reverse(A, start + 1, end -1);
    }
}