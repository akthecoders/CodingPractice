package trees.binarytree;

/**
 * DiameterBTree
 */
public class DiameterBTree {

    public static int getDiameter(BinaryNode<Integer> root) {
        return helper(root).diameter;
    }

    private static Pair<Integer, Integer> helper(BinaryNode<Integer> root) {
        if(root == null) {
            Pair<Integer, Integer> output = new Pair<>();
            output.diameter = 0;
            output.height = 0;
            return output;
        }

        Pair<Integer, Integer> lo = helper(root.left);
        Pair<Integer, Integer> ro = helper(root.right);
        int height = 1 + Math.max(lo.height, ro.height);
        int d1 = lo.height + ro.height;
        int d2 = lo.diameter;
        int d3 = ro.diameter;
        int diameter = Math.max(d1, Math.max(d2, d3));
        Pair<Integer, Integer> result = new Pair<>();
        result.height = height;
        result.diameter = diameter;
        return result;

    }
}