
public class PerimeterInMatrix {
    static final int R = 3;
    static final int C = 5;

    static int numofneighbour(int mat[][], int i, int j) {

        int count = 0;
        if (i > 0 && mat[i - 1][j] == 1)
            count++;
        if (j > 0 && mat[i][j - 1] == 1)
            count++;
        if (i < R - 1 && mat[i + 1][j] == 1)
            count++;
        if (j < C - 1 && mat[i][j + 1] == 1)
            count++;
        return count;
    }

    static int findperimeter(int mat[][]) {
        int perimeter = 0;
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (mat[i][j] == 1)
                    perimeter += (4 - numofneighbour(mat, i, j));
        return perimeter;
    }

    public static void main(String[] args) {
        int mat[][] = { { 0, 1, 0, 0, 0 }, { 1, 1, 1, 0, 0 }, { 1, 0, 0, 0, 0 } };

        System.out.println(findperimeter(mat));
    }
}