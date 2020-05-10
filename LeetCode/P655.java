//Print Binary Tree
import java.util.*;
public class P655 {
    public List<List<String>> printTree(TreeNode root) {
        int height = height(root);
        int width = (1 << height) - 1;
        
        List<String> row = new ArrayList<>();
        for(int i = 0; i < width; i++){
            row.add("");
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i < height; i++) {
            ans.add(new ArrayList<>(row));
        }
        helper(root, ans, 0 , 0 ,width - 1);
        return ans;
    }
    
    public void helper(TreeNode root, List<List<String>> ans, int level, int left, int right) {
        if(root == null) return;
        List<String> row = ans.get(level);
        int mid = (right + left)/2;
        row.set(mid, Integer.toString(root.val));
        helper(root.left, ans, level + 1, left, mid - 1);
        helper(root.right, ans, level + 1, mid + 1, right);
    }
    
    public int height(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(height(root.left) , height(root.right));
    }
}