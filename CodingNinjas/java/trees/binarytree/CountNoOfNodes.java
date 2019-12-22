package trees.binarytree;

/**
 * CountNoOfNodes
 */
public class CountNoOfNodes {

    public static int countNoOfNodes(BinaryNode<Integer> root) {
        if(root == null) {
            return 0;
        }
        int ans = 1;
        ans += countNoOfNodes(root.left);
        ans += countNoOfNodes(root.right);
        return ans;
    }
}