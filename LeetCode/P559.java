import java.util.List;
// Maximum Depth of N-ary Tree
public class P559 {
    class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }
        return helper(root);
    }
    
    public int helper(Node root) {
        if(root == null) {
            return 1;
        }
        int maxHeight = 0;
        for(Node x: root.children) {
            int depth = helper(x);
            if(depth > maxHeight) {
                maxHeight = depth;
            }
        }
        
        return maxHeight + 1;
    }
}