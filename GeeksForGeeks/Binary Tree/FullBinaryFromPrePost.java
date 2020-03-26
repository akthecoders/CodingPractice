/**
 * FullBinaryFromPrePost
 */
public class FullBinaryFromPrePost {
    static int preindex;

    static class node {
        int data;
        node left, right;

        public node(int data) {
            this.data = data;
        }
    }

    public static node constructTreeUtil(int[] pre, int[] post, int l , int r, int size) {
        if(l > r || preindex > size) {
            return null;
        }

        node root = new node(pre[preindex++]);

        if(l == r || preindex >= size) {
            return root;
        }
        int i;
        for (i = l; i <= r; i++)  
        { 
            if (post[i] == pre[preindex]) 
                break; 
        } 

        if (i <= r) {
            root.left = constructTreeUtil(pre, post, l , i , size);
            root.right = constructTreeUtil(pre, post, i, r, size);
        }
        return root;
    }


    static node constructTree(int pre[], int post[], int size) {
        preindex = 0;
        return constructTreeUtil(pre, post, 0, size - 1, size);
    }

    static void printInorder(node root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {

        int pre[] = { 1, 2, 4, 8, 9, 5, 3, 6, 7 };
        int post[] = { 8, 9, 4, 5, 2, 6, 7, 3, 1 };

        int size = pre.length;
        node root = constructTree(pre, post, size);

        System.out.println("Inorder traversal of the constructed tree:");
        printInorder(root);
    }
}