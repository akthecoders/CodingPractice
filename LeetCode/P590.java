// N-ary Tree Postorder Traversal
import java.util.*;
public class P590 {
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
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null ) return list;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node curr = stack.pop();
            list.add(0, curr.val);
            for(Node n: curr.children) {
                stack.push(n);
            }
        }
        return list;
    }
}