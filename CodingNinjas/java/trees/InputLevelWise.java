package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * InputLevelWise
 */
public class InputLevelWise {
  public static TreeNode<Integer> takeInput(Scanner scanner) {
    Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
    int rootData = scanner.nextInt();
    TreeNode<Integer> root = new TreeNode<Integer>(rootData);
    queue.add(root);
    while(!queue.isEmpty()) {
      TreeNode<Integer> currentNode;
      try {
        currentNode = queue.poll();
        int numChild = scanner.nextInt();
        for(int i = 0; i < numChild; i++) {
          int child = scanner.nextInt();
          TreeNode<Integer> childNode = new TreeNode<Integer>(child);
          queue.add(childNode);
          currentNode.children.add(childNode);
        }
      } catch (Exception e) {
        System.out.println("Exception occured");
      }
    }
    return root;
  }
}