/**
 * CompleteBinaryTreeArray
 */
public class CompleteBinaryTreeArray {
    static Node root;
    static class Node { 
        int data; 
        Node left, right; 
        Node(int data) 
        { 
            this.data = data; 
            this.left = null; 
            this.right = null; 
        } 
    } 
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 6, 6, 6 }; 
        root = insertLevelOrder(arr, root, 0); 
        inOrder(root); 
    }

    public static Node insertLevelOrder(int[] arr, Node root, int i) {
        if(i < arr.length) {
            Node tNode = new Node(arr[i]);
            root = tNode;

            root.left = insertLevelOrder(arr, root.left, 2 * i + 1);
            root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
        }
        return root;
    }

    public static void inOrder(Node root) 
    { 
        if (root != null) { 
            inOrder(root.left); 
            System.out.print(root.data + " "); 
            inOrder(root.right); 
        } 
    } 
}