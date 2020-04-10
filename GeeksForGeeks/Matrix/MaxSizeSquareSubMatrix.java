
public class MaxSizeSquareSubMatrix {
    public static void main(String[] args) {
        int M[][] = {{0, 1, 1, 0, 1},  
                    {1, 1, 0, 1, 0},  
                    {0, 1, 1, 1, 0}, 
                    {1, 1, 1, 1, 0}, 
                    {1, 1, 1, 1, 1}, 
                    {0, 0, 0, 0, 0}}; 
              
        printMatrixSubSquare(M); 
    }

    public static void printMatrixSubSquare(int[][] M) {
        int i, j;
        int R = M.length;
        int C = M[0].length;
        int S[][] = new int[R][C];

        int maxOfS, maxI, maxJ;
        S[0][0] =M[0][0];
        for(i = 1; i < R; i++) {
            for(j = 1; j < C; j++) {
                if(M[i][j] == 1) {
                    S[i][j] = Math.min(S[i][j-1], Math.min(S[i-1][j], S[i-1][j-1])) + 1;
                }
                else {
                    S[i][j] = 0;
                }
            }
        }

        maxOfS = 0; 
        maxI = 0;
        maxJ = 0;

        for(i = 0; i < R; i++) 
        { 
            for(j = 0; j < C; j++) 
            { 
                if(maxOfS < S[i][j]) 
                { 
                    maxOfS = S[i][j]; 
                    maxI = i;  
                    maxJ = j; 
                }      
            }                  
        }  
        System.out.println("Maximum size sub-matrix is: "); 
        for(i = maxI; i > maxI - maxOfS; i--) 
        { 
            for(j = maxJ; j > maxJ - maxOfS; j--) 
            { 
                System.out.print(M[i][j] + " "); 
            }  
            System.out.println(); 
        }      
    }
}