/**
 * CheckIfInternalNodeHaveOneChild
 */
public class CheckIfInternalNodeHaveOneChild {

    public static boolean hasOnlyOneChild(int[] pre, int n) {
        int leftDiff, rightDiff;
        for(int i  = 0; i < n - 1; i++) {
            leftDiff = pre[i] - pre[i + 1];
            rightDiff = pre[i] - pre[n - 1];
            if(leftDiff * rightDiff < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int pre[] = new int[]{8, 3, 5, 7, 6}; 
        int size = pre.length; 
        if (hasOnlyOneChild(pre, size) == true) { 
            System.out.println("Yes"); 
        } else { 
            System.out.println("No"); 
        } 
    }
}