import java.util.Stack;

/**
 * IsPreOrderBST
 */
public class IsPreOrderBST {

    public static void main(String[] args) {
        int[] pre1 = new int[]{40, 30, 35, 80, 100}; 
        int n = pre1.length; 
        if (canRepresentBST(pre1, n) == true) { 
            System.out.println("true"); 
        } else { 
            System.out.println("false"); 
        } 
        int[] pre2 = new int[]{40, 30, 35, 20, 80, 100}; 
        int n1 = pre2.length; 
        if (canRepresentBST(pre2, n1) == true) { 
            System.out.println("true"); 
        } else { 
            System.out.println("false"); 
        } 
    }

    public static boolean canRepresentBST(int[] pre, int n) {
        Stack<Integer> s = new Stack<>();
        int root = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            if(pre[i] < root) {
                return false;
            }
            while(!s.isEmpty() && pre[i] > s.peek()) {
                root = s.peek();
                s.pop();
            }
            s.push(pre[i]);
        }
        return true;
    }
}