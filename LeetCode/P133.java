// Clone Graph

import java.util.*;
class P133 {
    Map<Node, Node> vis = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node clone = new Node(node.val);
        vis.put(node, clone);
        for (Node n : node.neighbors) {
            if (!vis.containsKey(n)) {
                clone.neighbors.add(cloneGraph(n));
            } else {
                clone.neighbors.add(vis.get(n));
            }
        }
        return clone;
    }
}
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}