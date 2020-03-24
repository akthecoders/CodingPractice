/**
 * PostOrderWithPreOrder
 */
public class PostOrderWithPreOrder {

    public static void main(String[] args) {
        int pre[] = { 40, 30, 35, 80, 100 };
        int n = pre.length;
        findPostOrder(pre, n, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }

    public static void findPostOrder(int[] pre, int n, int minVal, int maxVal, int index) {
        if(index == n) {
            return;
        }

        if(pre[index] < minVal || pre[index] > maxVal ) {
            return;
        }

        int val = pre[index];

        findPostOrder(pre, n, minVal, val, index + 1);
        findPostOrder(pre, n, val, maxVal, index + 1);

        System.out.println(val + " ");

    }

}