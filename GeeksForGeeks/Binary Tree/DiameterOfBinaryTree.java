/**
 * DiameterOfBinaryTree
 */
class Node 
{ 
    int data; 
    Node left, right; 
  
    public Node(int item) 
    { 
        data = item; 
        left = right = null; 
    } 
} 
public class DiameterOfBinaryTree {
    Node root;
    public int diameter() {
        return diameter(root);
    }

    public int diameter(Node node) {
        if(node == null) {
            return 0;
        }
        int lHeight = height(node.left);
        int rHeight = height(node.right);

        int lD = diameter(node.left);
        int rD = diameter(node.right);
        return Math.max(lHeight + 1 + rHeight, Math.max(lD, rD));
    }

    public int height(Node root) {
        if(root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree tree = new DiameterOfBinaryTree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
  
        System.out.println("The diameter of given binary tree is : "
                           + tree.diameter()); 
    }
}