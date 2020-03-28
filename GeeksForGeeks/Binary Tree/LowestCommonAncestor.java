/**
 * LowestCommonAncestor
 */
import java.util.*;

class Node { 
    int data; 
    Node left, right; 
  
    Node(int value) { 
        data = value; 
        left = right = null; 
    } 
} 

public class LowestCommonAncestor {
    static Node root;
    static private List<Integer> path1 = new ArrayList<>(); 
    static private List<Integer> path2 = new ArrayList<>(); 

    public static void main(String[] args) {
        root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.right.left = new Node(6); 
        root.right.right = new Node(7); 
  
        System.out.println("LCA(4, 5): " + findLCA(4,5)); 
        System.out.println("LCA(4, 6): " + findLCA(4,6)); 
        System.out.println("LCA(3, 4): " + findLCA(3,4)); 
        System.out.println("LCA(2, 4): " + findLCA(2,4)); 
    }

    public static int findLCA(int a, int b) {
        path1.clear();
        path2.clear();
        return findLCAInternalNode(root, a, b);
    }

    public static int findLCAInternalNode(Node root, int n1, int n2) {

        if(!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
            System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing"); 
            System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing"); 
            return -1; 
        }

        int i;
        for(i = 0; i < path1.size() && i < path2.size(); i++) {
            if(!path1.get(i).equals(path2.get(i))) {
                break;
            }
        }
        return path1.get(i - 1);
    }

    public static boolean findPath(Node root, int n, List<Integer> path) {
        if(root == null) {
            return false;
        }

        path.add(root.data);
        if(root.data == n) {
            return true;
        }

        if (root.left != null && findPath(root.left, n, path)) { 
            return true; 
        } 
  
        if (root.right != null && findPath(root.right, n, path)) { 
            return true; 
        } 
  
        path.remove(path.size()-1); 
  
        return false; 
    }

}