// Maximum Level Sum of a Binary Tree
import java.util.*;

public class P1161 {
    class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        PriorityQueue<LevelSum> pQ = new PriorityQueue<>();
        pQ.add(new LevelSum(1, root.val));
        
        int level = 1;
        while(!q.isEmpty()) {
            int sum = 0;
            Queue<TreeNode> tQueue = new LinkedList<>();
            while(!q.isEmpty()) {
                tQueue.add(q.poll());
            }
            
            while(!tQueue.isEmpty()) {
                TreeNode t = tQueue.poll();
                sum += t.val;
                if(t.left != null) {
                    q.add(t.left);
                }
                if(t.right != null) {
                    q.add(t.right);
                }
            }
            
            pQ.add(new LevelSum(level, sum));
            level++;
        }
        
        return pQ.peek().level;
    }
    
    class LevelSum implements Comparable<LevelSum> {
        int level;
        int sum;
        
        LevelSum(int l, int s) {
            this.level = l;
            this.sum = s;
        }
        
        public int compareTo(LevelSum other) {
            if(this.sum == other.sum) {
                return this.level - other.level;
            }
            return other.sum - this.sum;
            
        }
    }
}