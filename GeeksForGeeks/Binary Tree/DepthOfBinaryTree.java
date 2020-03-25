/**
 * DepthOfBinaryTree
 */
public class DepthOfBinaryTree {

    public static void main(String[] args) {
        String tree = "nlnnlll"; 
        int n = tree.length(); 
        System.out.println(findDepth(tree, n)); 
    }

    public static int findDepth(String tree, int n) {
        int index = 0; 
        return (findDepthRec(tree,  
                             n, index)); 
    }

    public static int findDepthRec(String tree, int n, int index) {
        if(index >= n || tree.charAt(index) == 'l') {
            return 0;
        }
        index++;
        int left = findDepthRec(tree, n, index);
        index++;
        int right = findDepthRec(tree, n, index);

        return left > right ? left + 1 : right + 1;
    }
}