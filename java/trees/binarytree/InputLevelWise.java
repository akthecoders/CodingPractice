package trees.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * InputLevelWise
 */
public class InputLevelWise {

    public static BinaryNode<Integer> inputLevelWise(Scanner scan) {
        Queue<BinaryNode<Integer>> pendingNode = new LinkedList<BinaryNode<Integer>>();
        int rootData = scan.nextInt();
        if(rootData == -1) {
            return null;
        }
        BinaryNode<Integer> rootNode = new BinaryNode<Integer>(rootData);
        pendingNode.add(rootNode);
        while(!pendingNode.isEmpty()) {
            try {
                BinaryNode<Integer> node = pendingNode.poll();
                rootData = scan.nextInt();
                if(rootData != -1) {
                    BinaryNode<Integer> child = new BinaryNode<Integer>(rootData);
                    node.left = child;
                    pendingNode.add(child);
                }
                rootData = scan.nextInt();
                if(rootData != -1) {
                    BinaryNode<Integer> child = new BinaryNode<Integer>(rootData);
                    node.right = child;
                    pendingNode.add(child);
                }
            } catch (Exception e) {
               System.out.println("InputLevelWise: Exception in extracting node from queue");
            }
        }
        return rootNode;
    }
}