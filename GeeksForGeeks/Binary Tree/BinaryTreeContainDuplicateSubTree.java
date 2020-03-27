import java.util.HashSet;

/**
 * BinaryTreeContainDuplicateSubTree
 */
public class BinaryTreeContainDuplicateSubTree {
    static String MARKER = "$";
    public static void main(String[] args) {
        Node root = new Node('A');  
        root.left = new Node('B');  
        root.right = new Node('C');  
        root.left.left = new Node('D');  
        root.left.right = new Node('E');  
        root.right.right = new Node('B');  
        root.right.right.right = new Node('E');  
        root.right.right.left= new Node('D');  
        String str = dupSub(root);  
        if(str.equals("")) 
            System.out.print(" Yes "); 
        else    
            System.out.print(" No ");  
    }

    public static String dupSub(Node root) {
        HashSet<String> subtrees=new HashSet<>(); 
        return dupSubUtil(root,subtrees); 
    }
    public static String dupSubUtil(Node root, HashSet<String> subtrees) {
        String s = "";
        if(root == null) {
            return s + MARKER;
        }

        String lSt = dupSubUtil(root.left, subtrees);
        if(lSt.equals(s)) {
            return s;
        }
        String rSt = dupSubUtil(root.right, subtrees);
        if(rSt.equals(s)) {
            return s;
        }
        s = s + root.data + lSt + rSt;

        if(s.length() > 3 && subtrees.contains(s)) {
            return "";
        }
        subtrees.add(s);
        return s;
    }
}
class Node {  
    int data;  
    Node left,right;  
    Node(int data) 
    { 
        this.data=data; 
    } 
}