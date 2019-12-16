public class Solution {

	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr){
		return SortedArrayToBST(arr, 0, arr.length - 1);
	}
    
    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int sIndex, int eIndex) {
        if(sIndex > eIndex) {
            return null;
        }
        int diff = eIndex - sIndex;
        int middle = (diff / 2);
        int n = sIndex + middle;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[n]);
        root.left = SortedArrayToBST(arr, sIndex, n - 1);
        root.right = SortedArrayToBST(arr, n + 1, eIndex);
        return root;
    }
}	
