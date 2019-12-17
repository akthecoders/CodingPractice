    class HTNode {
        LinkedListNode<Integer> head = null;
        LinkedListNode<Integer> tail = null;
    }

public class Solution {

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
	public static LinkedListNode<Integer> BSTToSortedLL(BinaryTreeNode<Integer> root){
		HTNode result = helper(root);
        return result.head;
	}
    
    public static HTNode helper(BinaryTreeNode<Integer> root) {
        if(root == null) {
            HTNode result = new HTNode();
            result.head = null;
            result.tail = null;
            return result;
        }
        LinkedListNode<Integer> nn = new LinkedListNode<Integer>(root.data);
        HTNode left = helper(root.left);
        HTNode right = helper(root.right);
        HTNode pair = new HTNode();
        if(left.head != null) {
            pair.head = left.head;
            pair.tail = left.tail;
            pair.tail.next = nn;
            pair.tail = nn;
            if(right.head == null) {
                return pair;
            }
        }
        if(left.head != null && right.head != null){
            pair.tail.next = right.head;
            pair.tail = right.tail;
            return pair;
        }
        if(left.head == null && right.head != null ) {
            pair.head = nn;
            pair.head.next = right.head;
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
