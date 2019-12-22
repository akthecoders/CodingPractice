package trees.binarytree;

/**
 * PostOrder
 */
public class PostOrder {

    public static void postOrder(BinaryNode<Integer> root) {
        if(root == null) {return;}
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data + ", ");
    }
}