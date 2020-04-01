import java.util.TreeMap;
import java.util.Vector;
import java.util.Map.Entry;

/**
 * VerticalBST
 */
public class VerticalBST {
    static class Node 
    { 
        int key; 
        Node left; 
        Node right; 
          
        // Constructor 
        Node(int data) 
        { 
            key = data; 
            left = null; 
            right = null; 
        } 
    } 
    public static void main(String[] args) {
        Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.right.left = new Node(6); 
        root.right.right = new Node(7); 
        root.right.left.right = new Node(8); 
        root.right.right.right = new Node(9); 
        System.out.println("Vertical Order traversal is"); 
        printVerticalOrder(root); 
    }
    
    public static void printVerticalOrder(Node root) {

        TreeMap<Integer, Vector<Integer>> m = new TreeMap<>();
        int hd = 0;
        getVerticleOrder(root, hd, m);

        for(Entry<Integer, Vector<Integer>> ent: m.entrySet()) {
            System.out.println(ent.getValue());
        }
    }

    public static void getVerticleOrder(Node root, int hd, TreeMap<Integer, Vector<Integer>> m) {

        if(root == null) {
            return;
        }

        Vector<Integer> list = m.get(hd);
        if(list == null) {
            list = new Vector<>();
            list.add(root.key);
        }
        else {
            list.add(root.key);
        }
        m.put(hd, list);

        getVerticleOrder(root.left, hd - 1, m);
        getVerticleOrder(root.right, hd + 1, m);
    }
}