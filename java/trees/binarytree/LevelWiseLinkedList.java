package trees.binarytree;

import java.io.*; 
import java.util.*; 
/**
 * LevelWiseLinkedList
 */

class Node<T> {
    T data;
    Node<T> next;
    Node(T data){
        this.data = data;
    }
}

public class LevelWiseLinkedList {

    public static ArrayList<Node<BinaryNode<Integer>>> getLevelWiseLinkedList(BinaryNode<Integer> root) {
        Queue<BinaryNode<Integer>> queue = new LinkedList<>();
        ArrayList<Node<BinaryNode<Integer>>> arrayList = new ArrayList<Node<BinaryNode<Integer>>>();
        Node<BinaryNode<Integer>> head = null;
        Node<BinaryNode<Integer>> tail = null;
        queue.add(root);
        queue.add(null);
        BinaryNode<Integer> currNode = null;
        BinaryNode<Integer> prevNode = null;
        while (!queue.isEmpty()) {
            prevNode = currNode;
            try {
                currNode = queue.poll();
            } catch (Exception e) {
                System.out.println("ExceptionCaught");
            }
            if (currNode == null && prevNode != null) {
                arrayList.add(head);
                head = null;
                tail = null;
                queue.enqueue(null);
            } else if (currNode != null) {
                Node<BinaryNode<Integer>> childNode = new Node<BinaryNode<Integer>>(currNode);
                if (head == null) {
                    head = childNode;
                    tail = childNode;
                } else {
                    tail.next = childNode;
                    tail = childNode;
                }
                if (currNode.left != null) {
                    queue.enqueue(currNode.left);
                }
                if (currNode.right != null) {
                    queue.enqueue(currNode.right);
                }
            }
        }
        return arrayList;
    }
}