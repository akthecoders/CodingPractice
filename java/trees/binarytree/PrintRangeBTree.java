package trees.binarytree;

/**
 * PrintRangeBTree
 */
public class PrintRangeBTree {

    public static void printRange(BinaryNode<Integer> root, int min, int max) {
        if(root == null) {return;}
        if(root.data > min) {
            printRange(root.left, min, max);
        }
        if(root.data >= min && root.data <= max) {
            System.out.println(root.data);
        }
        if(root.data < max) {
            printRange(root.right, min, max);
        }
    }
}