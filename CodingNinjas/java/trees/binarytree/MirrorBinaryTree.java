package trees.binarytree;

/**
 * MirrorBinaryTree
 */
public class MirrorBinaryTree {

    public static void mirror(BinaryNode<Integer> root) {
        if(root == null) {return;}
        BinaryNode<Integer> tNode = root.left;
        root.left = root.right;
        root.right = tNode;
        mirror(root.right);
        mirror(root.left);
    }
}