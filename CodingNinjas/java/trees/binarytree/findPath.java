package trees.binarytree;
import java.util.ArrayList;

public class findPath {

	public static ArrayList<Integer> findPathBTree(BinaryNode<Integer> root, int data){
		if(root == null) {
            return null;
        }
        
        if(root.data == data) {
            ArrayList<Integer> output = new ArrayList<Integer>();
            output.add(root.data);
            return output;
        }
        
        if(root.data > data) {
            ArrayList<Integer> output = findPathBTree(root.left, data);
            if(output != null) {
                output.add(root.data);
            }
            return output;
        }
        
        if(root.data < data) {
            ArrayList<Integer> output = findPathBTree(root.right, data);
            if(output != null) {
                output.add(root.data);
            }
            return output;
        }
        
        return null;
	}
}
