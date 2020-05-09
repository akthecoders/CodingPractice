// Construct Binary Tree from Preorder and Postorder Traversal
import java.util.*;
public class P889 {
    int preIndex = 0;

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int N = pre.length;
        if (N == 0)
            return null;

        TreeNode root = new TreeNode(pre[0]);
        if (N == 1)
            return root;
        int rightRootValue = post[N - 2];

        int rightIndex = 0;
        for (int i = 1; i < N; i++) {
            if (pre[i] == rightRootValue) {
                rightIndex = i;
                break;
            }
        }
        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, rightIndex),
                Arrays.copyOfRange(post, 0, rightIndex - 1));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, rightIndex, N),
                Arrays.copyOfRange(post, rightIndex - 1, N - 1));

        return root;
    }
}