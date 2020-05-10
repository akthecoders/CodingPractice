import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// All Nodes Distance K in Binary Tree
public class P863 {
    List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        HashMap<Integer, TreeNode> parentMap = new HashMap<>();
        HashMap<Integer, Boolean> seenMap = new HashMap<>();
        mapTree(root, parentMap, seenMap, null);
        TreeNode targetNode = target;
        int currLevel = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(targetNode);
        seenMap.put(targetNode.val, true);
        while (!q.isEmpty() && currLevel != K) {
            int size = q.size();
            if (size == 0)
                break;
            for (int i = 0; i < size; i++) {
                System.out.println(" i " + i);
                TreeNode curr = q.poll();
                seenMap.put(curr.val, true);
                if (curr.left != null) {
                    if (seenMap.containsKey(curr.left.val) && !seenMap.get(curr.left.val)) {
                        q.add(curr.left);
                    } else if (!seenMap.containsKey(curr.left.val)) {
                        q.add(curr.left);
                    }
                }
                if (curr.right != null) {
                    if (seenMap.containsKey(curr.right.val) && !seenMap.get(curr.right.val)) {
                        q.add(curr.right);
                    } else if (!seenMap.containsKey(curr.right.val)) {
                        q.add(curr.right);
                    }
                }
                TreeNode parent = parentMap.get(curr.val);
                if (parent != null)
                    if (!seenMap.get(parent.val)) {
                        seenMap.put(parent.val, true);
                        q.add(parent);
                    }
            }
            currLevel++;
            if (currLevel >= K) {
                break;
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }
        return ans;
    }

    public void mapTree(TreeNode root, HashMap<Integer, TreeNode> parentMap, HashMap<Integer, Boolean> seenMap,
            TreeNode parent) {
        if (root == null)
            return;

        if (!parentMap.containsKey(root.val)) {
            parentMap.put(root.val, parent);
        }
        seenMap.put(root.val, false);
        mapTree(root.left, parentMap, seenMap, root);
        mapTree(root.right, parentMap, seenMap, root);
    }
}