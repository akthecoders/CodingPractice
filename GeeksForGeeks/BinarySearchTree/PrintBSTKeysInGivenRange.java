/**
 * PrintBSTKeysInGivenRange
 */
public class PrintBSTKeysInGivenRange {
    static class Node {
        int data;
        Node left, right;

        // constructor
        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void printInRange(Node root, int min, int max) {
        if(root == null) {
            return;
        }
        Node curr = root;
        while(curr != null) {
            if(curr.left == null) {
                if(curr.data > min && curr.data < max) {
                    System.out.println(curr.data + " ");
                }
                curr = curr.right;
            }
            else {
                Node pre = curr.left;
                while(pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }
                if(pre.right == null) {
                 pre.right = curr;
                 curr = curr.left;   
                }
                else {
                    pre.right = null;
                    if(curr.data > min && curr.data < max) {
                        System.out.println(curr.data + " ");
                    }
                    curr = curr.right;
                }
            }
        }
    }
    public static void main(String[] args) {
        Node root1 = new Node(5); /* 5 */
        root1.left = new Node(3); /* / \ */
        root1.right = new Node(7); /* 3 7 */
        root1.left.left = new Node(2); /* / \ / \ */
        root1.left.right = new Node(4); /* 2 4 6 8 */
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);
        
        printInRange(root1, 3, 7);

    }
}