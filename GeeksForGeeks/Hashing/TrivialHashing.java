/**
 * TrivialHashing
 */
public class TrivialHashing {
    static boolean has[][] = new boolean[100][100];

    public static void insert(int[] input, int n) {
        for (int i = 0; i < n; i++) {
            if (input[i] > 0) {
                has[input[i]][0] = true;
            } else {
                has[Math.abs(input[i])][1] = true;
            }
        }
    }

    public static boolean search(int key) {
        if (key >= 0) {
            return has[key][0] == true ? true : false;
        } else {
            return has[Math.abs(key)][1] == true ? true : false;
        }
    }

    public static void main(String[] args) {
        int a[] = { -1, 9, -5, -8, -5, -2 };
        int n = a.length;
        insert(a, n);
        int X = -5;
        if (search(X) == true) {
            System.out.println("Present");
        } else {
            System.out.println("Not Present");
        }
    }
}