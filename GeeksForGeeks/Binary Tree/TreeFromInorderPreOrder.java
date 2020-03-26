/**
 * TreeFromInorderPreOrder
 */
public class TreeFromInorderPreOrder {
    Node root; 
    static int preIndex = 0;

    static class Node {
        char data;
        Node left, right;

        public Node(char key) {
            data = key;
            left = null;
            right = null;
        }
    }

    public static Node constructTree(char [] pre, char [] in, int start, int end) {
        
        if(start > end) {
            return null;
        }
        Node tNode = new Node(pre[preIndex++]);
        if(start == end) {
            return tNode;
        }

        int inIndex = search(in, start, end, tNode.data);

        tNode.left = constructTree(pre, in, start, inIndex - 1);
        tNode.right = constructTree(pre, in, inIndex + 1, end);

        return tNode;

    }

    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static int search(char [] in, int start, int end, char key) {
        int i;
        for(i = start; i <= end; i++) {
            if(in[i] == key) {
                return i;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' }; 
        char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' }; 
        int len = in.length; 
        Node root = constructTree(pre, in, 0, len - 1); 
  
        System.out.println("Inorder traversal of constructed tree is : "); 
        inOrder(root); 
    }
}