import java.util.Vector;

/**
 * AllPossibleBinaryTrees
 */
public class AllPossibleBinaryTrees {

    public static void main(String[] args) {
        int in[] = {4, 5, 7}; 
        int n = in.length; 
        Vector<Node> trees = getTrees(in, 0, n - 1); 
        System.out.println("Preorder traversal of different "+ 
                           " binary trees are:"); 
        for (int i = 0; i < trees.size(); i++) { 
            preOrder(trees.get(i)); 
            System.out.println(""); 
        }
    }

    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.key + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Vector<Node> getTrees(int[] in, int start, int end) {
        Vector<Node> trees = new Vector<>();
        if(start > end) {
            trees.add(null);
            return trees;
        }

        for(int i = start; i <= end; i++) {
           Vector<Node> ltree = getTrees(in, start, i - 1);
           Vector<Node> rtree = getTrees(in, i + 1, end);

            for (int j = 0; j < ltree.size(); j++) { 
                for (int k = 0; k < rtree.size(); k++) { 
                    Node node = new Node(in[i]);
                    node.left = ltree.get(j);
                    node.right = rtree.get(k);
                    trees.add(node);
                }
            }
        }
        return trees;
    }


}