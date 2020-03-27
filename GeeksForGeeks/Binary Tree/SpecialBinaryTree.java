/**
 * SpecialBinaryTree
 */
public class SpecialBinaryTree {
    static Node root;
    static class Node {
        int key;
        Node left = null, right = null;
        public Node(int data) {
            key = data;
        }
    }

    public static void main(String[] args) {
        int inorder[] = new int[]{5, 10, 40, 30, 28}; 
        int len = inorder.length; 
        Node mynode = buildTree(inorder, 0, len - 1, root);
        System.out.println("Inorder traversal of the constructed tree is "); 
        printInorder(mynode); 
    }

    public static Node buildTree(int[] in, int start, int end, Node root) {
        if(start > end) {
            return null;
        }
        int i = max(in, start, end);
        root = new Node(in[i]);

        root.left = buildTree(in, start, i - 1, root.left);
        root.right = buildTree(in, i + 1, end, root.right);
        return root;
    }

    public static int max(int arr[], int strt, int end)  { 
        int i, max = arr[strt], maxind = strt; 
        for (i = strt + 1; i <= end; i++)  
        { 
            if (arr[i] > max)  
            { 
                max = arr[i]; 
                maxind = i; 
            } 
        } 
        return maxind; 
    } 
   

    public static void printInorder(Node root) {
        if(root != null) {
            printInorder(root.left);
            System.out.print(root.key + " ");
            printInorder(root.right);
        }
    }
}