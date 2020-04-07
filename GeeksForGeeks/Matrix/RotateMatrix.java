/**
 * RotateMatrix
 */
public class RotateMatrix {

    public static void main(String[] args) {
        int a[][] = { {1, 2, 3, 4}, 
                  {5, 6, 7, 8}, 
                {9, 10, 11, 12}, 
                {13, 14, 15, 16} }; 
        rotatematrix(4, 4, a); 
    }

    public static void rotatematrix(int MR, int MC, int [][] a) {
        int sR = 0;
        int eR = MR;
        int sC = 0;
        int eC = MC;
        int prev, curr;

        while(sR < eR && sC < eC) {
            if(sR + 1 == eR || sC + 1 == eC) {
                break;
            }

            prev = a[sR + 1][sC];

            for(int i = sC; i < eC; i++) {
                curr = a[sC][i];
                a[sC][i] = prev;
                prev = curr;
            }
            sR++;

            for(int i = sR; i < eR; i++) {
                curr = a[i][eC - 1];
                a[i][eC - 1] = prev;
                prev = curr;
            }
            eC--;

            if(sR < eR) {
                for(int i = eC - 1; i >= sC; i--) {
                    curr = a[eR-1][i];
                    a[eR - 1][i] = prev;
                    prev = curr;
                }
                eR--;
            }

            if(sC < eC) {
                for(int i = eR - 1; i >= sR; i--) {
                    curr = a[i][sC];
                    a[i][sC] = prev;
                    prev = curr;
                }
                sC++;
            }
        }
        for (int i = 0; i < MR; i++) { 
            for (int j = 0; j < MC; j++) 
            System.out.print( a[i][j] + " "); 
            System.out.print("\n"); 
        } 
    }
}