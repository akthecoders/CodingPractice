import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//All Elements in Two Binary Search Trees
public class P1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<Integer>();
        inorder(list, root1);
        inorder(list, root2);
        Collections.sort(list);
        return list;
    }

    void inorder(List<Integer> list, TreeNode node) {
        if (node == null)
            return;
        inorder(list, node.left);
        list.add(node.val);
        inorder(list, node.right);
    }
}