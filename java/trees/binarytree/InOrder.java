package trees.binarytree;

/**
 * InOrder
 */
public class InOrder {

    public static void inOrder(BinaryNode<Integer> root) {
        if(root == null) {return;}
        inOrder(root.left);
        System.out.println(root.data + ", ");
        inOrder(root.right);
    }
}