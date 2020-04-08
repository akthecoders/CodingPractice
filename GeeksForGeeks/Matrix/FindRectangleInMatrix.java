import java.util.HashMap;
import java.util.HashSet;

/**
 * FindRectangleInMatrix
 */
public class FindRectangleInMatrix {

    public static void main(String[] args) {
        int mat[][] = { { 1, 0, 0, 1, 0 }, { 0, 0, 1, 0, 1 }, { 0, 0, 0, 1, 0 }, { 1, 0, 1, 0, 1 } };
        if (isRectangle(mat))
            System.out.print("Yes");
        else
            System.out.print("No");
    }

    public static boolean isRectangle(int[][] mat) {

        int rows = mat.length;
        if(rows == 0) {return false;}

        int columns = mat[0].length;

        HashMap<Integer, HashSet<Integer>> table = new HashMap<>();

        for(int i = 0; i < rows; i++) {
            for(int j = 0;  j < columns; j++) {
                for(int k = j +1; k < columns;k++) {
                    if (mat[i][j] == 1 && mat[i][k] == 1) {
                        if(table.containsKey(j) && table.get(j).contains(k)) {
                            return true;
                        }
                        if(table.containsKey(k) && table.get(k).contains(j)) {
                            return true;
                        }
                        
                        if(!table.containsKey(j)) {
                            HashSet<Integer> temp = new HashSet<>();
                            temp.add(k);
                            table.put(j, temp);
                        }
                        else {
                            table.get(j).add(k);
                        }

                        if(!table.containsKey(k)) {
                            HashSet<Integer> temp = new HashSet<>();
                            temp.add(j);
                            table.put(k, temp);
                        }
                        else {
                            table.get(k).add(j);
                        }
                    }
                }
            }
        }
        return false;
    }
}