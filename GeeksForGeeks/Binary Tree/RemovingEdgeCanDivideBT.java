/**
 * RemovingEdgeCanDivideBT
 */
public class RemovingEdgeCanDivideBT {
    static Node root;
    static class Res {
        boolean res = false;
    }


    static class Node {
        int key;
        Node left = null, right = null;
        public Node(int data) {
            this.key = data;
        }
    }

    public static int count(Node root) {
        if(root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }

    public static boolean check() {
        int n = count(root); 
        Res res = new Res(); 
        checkRec(root, n, res);   
        return res.res; 
    }

    public static int checkRec(Node root, int n , Res res) {
        if(root == null) {
            return 0;
        }
        int c = 1 + checkRec(root.left, n, res) + checkRec(root.right, n, res);
        if(c == n - c) {
            res.res = true;
        } 
        return c;

    }

    public static void main(String[] args) {
        root = new Node(5); 
        root.left = new Node(1); 
        root.right = new Node(6); 
        root.left.left = new Node(3); 
        root.right.left = new Node(7); 
        root.right.right = new Node(4); 
        if(check() ==true) 
            System.out.println("YES"); 
        else
            System.out.println("NO");     
    }
}