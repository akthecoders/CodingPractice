/**
 * BSTFromPreOrder
 */

class Node { 
  
    int data; 
    Node left, right; 
  
    Node(int d) { 
        data = d; 
        left = right = null; 
    } 
} 
class Index { 
  
    int index = 0; 
} 

public class BSTFromPreOrder {
    Index index = new Index();

    Node constructTree(int pre[], int size) { 
        return constructTreeUtil(pre, index, 0, size - 1, size); 
    } 

    Node constructTreeUtil(int[] pre, Index preIndex, int start, int end, int size) {
        if(preIndex.index >= size || start > end) {
            return null;
        }

        Node root = new Node(pre[preIndex.index]);
        preIndex.index = preIndex.index + 1;

        if(start == end) {
            return root;
        }

        int i;
        for (i = start; i <= end; ++i) { 
            if (pre[i] > root.data) { 
                break; 
            } 
        } 
        root.left = constructTreeUtil(pre, preIndex, preIndex.index, i - 1, size);
        root.right = constructTreeUtil(pre, preIndex, i, end, size);
        return root;
    }

    void printInorder(Node node) { 
        if (node == null) { 
            return; 
        } 
        printInorder(node.left); 
        System.out.print(node.data + " "); 
        printInorder(node.right); 
    } 
    public static void main(String[] args) {
        BSTFromPreOrder tree = new BSTFromPreOrder(); 
        int pre[] = new int[]{10, 5, 1, 7, 40, 50}; 
        int size = pre.length; 
        Node root = tree.constructTree(pre, size); 
        System.out.println("Inorder traversal of the constructed tree is "); 
        tree.printInorder(root); 
    }
}