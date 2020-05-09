// N-ary Tree Level Order Traversal
import java.util.*;
public class P429 {
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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> tList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                tList.add(curr.val);
                for (int j = 0; j < curr.children.size(); j++) {
                    q.add(curr.children.get(j));
                }
            }
            list.add(tList);
        }
        return list;
    }
}