package trees.binarytree;

/**
 * TreeFromIP
 */
public class TreeFromIP {
    static int preIndex = 0; 
    public static BinaryNode<Integer> generateTree(int[] inOrder, int[] preOrder) {
        return helper(inOrder,preOrder, 0, inOrder.length - 1);
    }

    private static BinaryNode<Integer> helper(int[] inOrder, int[] preOrder, int inStart, int inEnd) {
        if(inStart > inEnd) {
            return null;
        }
        BinaryNode<Integer> tNode = new BinaryNode<>(preOrder[preIndex++]);
        if(inStart == inEnd) {
            return tNode;
        }
        int rootIndex = searchIndex(inOrder, inStart, inEnd, tNode.data);
        tNode.left = helper(inOrder, preOrder, inStart, rootIndex - 1);
        tNode.right = helper(inOrder, preOrder, rootIndex + 1, inEnd);
        return tNode;
    }

    private static int searchIndex(int arr[], int strt, int end, int value) {
        int i;
        for(i = strt; i <= end; i++) {
            if(arr[i] == value) {
                return i;
            }
        }
        return i;
    }
}