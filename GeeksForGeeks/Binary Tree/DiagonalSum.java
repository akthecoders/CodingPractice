import java.util.*;
import java.util.Map.Entry;
/**
 * DiagonalSum
 */
public class DiagonalSum {
    static TreeNode root;
    public static void main(String[] args) {
        root = new TreeNode(1); 
        root.left = new TreeNode(2); 
        root.right = new TreeNode(3); 
        root.left.left = new TreeNode(9); 
        root.left.right = new TreeNode(6); 
        root.right.left = new TreeNode(4); 
        root.right.right = new TreeNode(5); 
        root.right.left.left = new TreeNode(12); 
        root.right.left.right = new TreeNode(7); 
        root.left.right.left = new TreeNode(11); 
        root.left.left.right = new TreeNode(10); 
        diagonalSum(); 
    }

    public static void diagonalSum() {
        if(root == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        root.vd  = 0;
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode curr = q.remove();
            int vd = curr.vd;
            while(curr!=null) {
                int prevSum = map.get(vd) == null ? 0 : map.get(vd);
                map.put(vd, prevSum + curr.data);

                if(curr.left != null) {
                    curr.left.vd = vd + 1;
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    curr.right.vd = vd + 1;
                    q.add(curr.right);
                }
            }
        }
        Set<Entry<Integer, Integer>> set = map.entrySet(); 
  
        // Make an iterator 
        Iterator<Entry<Integer, Integer>> iterator = set.iterator(); 
  
        // Traverse the map elements using the iterator. 
         System.out.print("Diagonal sum in a binary tree is - "); 
        while (iterator.hasNext()) 
        { 
            Map.Entry<Integer, Integer> me = iterator.next(); 
  
            System.out.print(me.getValue()+" "); 
        } 
    }
}

class TreeNode 
{ 
    int data; //node data 
    int vd; //vertical distance diagonally 
    TreeNode left, right; //left and right child's reference 
  
    // Tree node constructor 
    public TreeNode(int data) 
    { 
        this.data = data; 
        vd = Integer.MAX_VALUE; 
        left = right = null; 
    } 
} 