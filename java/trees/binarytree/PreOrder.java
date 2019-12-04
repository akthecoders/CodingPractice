package trees.binarytree;

/**
 * PreOrder
 */
public class PreOrder {

    public static void preOrder(BinaryNode<Integer> root) {
        if(root == null) {return;}
        System.out.println(root.data + ", ");
        preOrder(root.left);
        preOrder(root.right);
    }
}