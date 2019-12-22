package trees.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * PrintLevelWise
 */
public class PrintLevelWise {

    public static void printLevelWise(BinaryNode<Integer> root) {
        Queue<BinaryNode<Integer>> pendingNodes = new LinkedList<BinaryNode<Integer>>();
        pendingNodes.add(root);
        if(root == null) {
            return;
        }
        String printString = "";
        while(!pendingNodes.isEmpty()) {
            try {
                BinaryNode<Integer> node = pendingNodes.poll();
                printString = node.data + ": ";
                if(node.left != null) {
                    printString += node.left.data + ", ";
                    pendingNodes.add(node.left);
                }
                if(node.right != null) {
                    printString += node.right.data + ", ";
                    pendingNodes.add(node.right);
                }
            } catch (Exception e) {
                System.out.println("PrintLevelWise: Exception in extracting node from queue");
            }
            System.out.println(printString);
        }
    }
}