// N-ary Tree Preorder Traversal
import java.util.*;
public class P589 {
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
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null)
            return list;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            list.add(curr.val);
            List<Node> childrens = curr.children;
            if (childrens == null) {
                continue;
            }

            for (int i = childrens.size() - 1; i >= 0; i--) {
                stack.push(childrens.get(i));
            }
        }
        return list;
    }
}