package trees.binarytree;

/**
 * HeightOfBTree
 */
public class HeightOfBTree {

    public static int height(BinaryNode<Integer> root) {
        if(root == null) {return 0;}
        int height = 0;
        int lHeight = 0;
        int rHeight = 0;
        lHeight = height(root.left);
        rHeight = height(root.right);
        if(lHeight > rHeight) {
            height = lHeight + 1;
        }
        else {
            height = rHeight + 1;
        }
        
        return height;
    }
}