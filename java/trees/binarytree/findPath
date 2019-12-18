import java.util.ArrayList;

public class Solution {

/*	Binary Tree Node class
 * 
 * class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		
		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}
	*/

	public static ArrayList<Integer> findPath(BinaryTreeNode<Integer> root, int data){
		if(root == null) {
            return null;
        }
        
        if(root.data == data) {
            ArrayList<Integer> output = new ArrayList<Integer>();
            output.add(root.data);
            return output;
        }
        
        if(root.data > data) {
            ArrayList<Integer> output = findPath(root.left, data);
            if(output != null) {
                output.add(root.data);
            }
            return output;
        }
        
        if(root.data < data) {
            ArrayList<Integer> output = findPath(root.right, data);
            if(output != null) {
                output.add(root.data);
            }
            return output;
        }
        
        return null;
	}
}
