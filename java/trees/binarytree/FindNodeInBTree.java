package trees.binarytree;

/**
 * FindNodeInBTree
 */
public class FindNodeInBTree {

    public static BinaryNode<Integer> getBNode(BinaryNode<Integer> root, int requiredData) {
        if(root == null) {
            return null;
        }
        if(root.data == requiredData) {
            return root;
        }
        if(root.data < requiredData) {
            return getBNode(root.right, requiredData);
        }
        else {
            return getBNode(root.left, requiredData);
        }
    }
}