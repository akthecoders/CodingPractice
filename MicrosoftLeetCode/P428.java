import java.util.ArrayList;
import java.util.List;

//Serialize and Deserialize N-ary Tree
public class P428 {
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
    public String serialize(Node root) {
        String serialized = serializeHelper(root);
        return serialized;
    }

    private String serializeHelper(Node root) {
        if (root == null)
            return "";

        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        if (root.children.size() != 0) {
            sb.append('[');
            for (Node child : root.children) {
                sb.append(serializeHelper(child));
                sb.append(" ");
            }
            sb.setLength(sb.length() - 1);
            sb.append(']');
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.length() == 0)
            return null;

        List<Node> results = getChildren(data);
        return results.get(0);
    }

    private List<Node> getChildren(String s) {
        List<Node> children = new ArrayList<>();

        int i = 0;
        while (i < s.length()) {
            int noOfLeft = 0, noOfRight = 0, treeStart = -1;

            if (Character.isDigit(s.charAt(i))) {
                // collect all nums and create the child
                List<Node> subChildren = null;
                int num = s.charAt(i) - '0';
                i++;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num *= 10;
                    num += s.charAt(i) - '0';
                    i++;
                }

                // Check if there are children
                if (i < s.length() && s.charAt(i) == '[') {
                    noOfLeft++;
                    treeStart = i + 1;
                    i++;
                    while (i < s.length() && noOfLeft != noOfRight) {
                        if (s.charAt(i) == '[') {
                            noOfLeft++;
                        } else if (s.charAt(i) == ']') {
                            noOfRight++;
                        }
                        i++;
                    }
                    i--;
                    subChildren = getChildren(s.substring(treeStart, i));

                }
                Node child = new Node(num, subChildren);
                children.add(child);
            }
            i++;
        }
        return children;
    }
}