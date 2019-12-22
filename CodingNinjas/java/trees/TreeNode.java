package trees;
import java.util.*;

class TreeNode<T> {
    T data;
    ArrayList<TreeNode<T>> children;

    TreeNode(T data) {
        this.data = data;
        this.children = new ArrayList<TreeNode<T>>();
    }
}