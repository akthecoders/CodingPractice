package trees.binarytree;

/**
 * IsNodePresent
 */
public class IsNodePresent {

    public static boolean isNodePreset(BinaryNode<Integer> root, int x) {
        if(root == null) { return false; }
        if(root.data == x) { return true; }
        boolean lRes = false;
        boolean rRes = false;
        
        lRes = isNodePreset(root.left, x);
        rRes = isNodePreset(root.right, x);
        
        return lRes || rRes;
    }
}