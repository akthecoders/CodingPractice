package trees.binarytree;

public class createBTreeFromSortedArray {

	public static BinaryNode<Integer> SortedArrayToBST(int[] arr){
		return SortedArrayToBST(arr, 0, arr.length - 1);
	}
    
    public static BinaryNode<Integer> SortedArrayToBST(int[] arr, int sIndex, int eIndex) {
        if(sIndex > eIndex) {
            return null;
        }
        int diff = eIndex - sIndex;
        int middle = (diff / 2);
        int n = sIndex + middle;
        BinaryNode<Integer> root = new BinaryNode<>(arr[n]);
        root.left = SortedArrayToBST(arr, sIndex, n - 1);
        root.right = SortedArrayToBST(arr, n + 1, eIndex);
        return root;
    }
}	
