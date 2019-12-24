package trees.binarytree;

import java.util.LinkedList;

class HTNode {
    LinkedList<Integer> head = null;
    LinkedList<Integer> tail = null;
}

public class BSTToSortedLL {

/*	Binary Tree Node class 
 * 
 * 	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		
		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}
	*/

/* LinkedList Node Class
*
*	
class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;
	
	public LinkedListNode(T data) {
		this.data = data;
	}
}
*/
	public static LinkedList<Integer> getBSTToSortedLL(BinaryNode<Integer> root){
		HTNode result = helper(root);
        return result.head;
	}
    
    public static HTNode helper(BinaryNode<Integer> root) {
        if(root == null) {
            HTNode result = new HTNode();
            result.head = null;
            result.tail = null;
            return result;
        }
        LinkedList<Integer> nn = new LinkedList<Integer>();
        HTNode left = helper(root.left);
        HTNode right = helper(root.right);
        HTNode pair = new HTNode();
        if(left.head != null) {
            pair.head = left.head;
            pair.tail = left.tail;
            pair.tail = nn;
            pair.tail = nn;
            if(right.head == null) {
                return pair;
            }
        }
        if(left.head != null && right.head != null){
            pair.tail = right.head;
            pair.tail = right.tail;
            return pair;
        }
        if(left.head == null && right.head != null ) {
            pair.head = nn;
            pair.head = right.head;
            pair.tail = right.tail;
            return pair;
        }
        else {
            pair.head = nn;
            pair.tail = nn;
        }
        
        return pair;
        
    }
}	
