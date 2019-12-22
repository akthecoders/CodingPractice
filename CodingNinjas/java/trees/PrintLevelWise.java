package trees;
import java.util.LinkedList;
import java.util.Queue;

class PrintLevelWise {
  public static void printLevelWise(TreeNode<Integer> root) {
    Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
    queue.add(root);
    while(!queue.isEmpty()) {
      TreeNode<Integer> currentNode ;
      try {
        currentNode = queue.poll();
        String dP = currentNode.data + " : ";
        for(int i = 0; i < currentNode.children.size(); i ++) {
          dP += currentNode.children.get(i).data + ",";
          queue.add(currentNode.children.get(i));
        }
        System.out.println(dP);
      } catch (Exception e) {
        System.out.println("System Exception");
      }
    }
  }
}