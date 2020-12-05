public class BSTDistNode {
    static class Node {
        int value;
        Node left;
        Node right;
        public Node(int v) {
            this.value = v;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3};
        int f1 =1;
        int f2 = 3;

        Node root = buildTree(nums);
        printTree(root);

        Node lca = findLCA(root, f1, f2);
        System.out.println("LCA : " + lca.value);
        int df1 = findDist(lca, f1);
        int df2 = findDist(lca, f2);

        System.out.println("df1 : " + df1);
        System.out.println("df2 : " + df2);
        System.out.println("Dist : " + (df1 + df2));
    }

    public static void  printTree(Node root) {
        if(root == null) return;

        printTree(root.left);
        System.out.print(root.value + " ");
        printTree(root.right);
    }

    public static int findDist(Node root, int node) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;
        if(root.value == node) return 0;
        else if(root.value < node) {
            return findDist(root.right, node) + 1;
        }
        else {
            return findDist(root.right, node) + 1;
        }
    }

    public static Node findLCA(Node root, int f1, int f2) {
        if(root == null) return root;
        if(root.value < f1 && root.value < f2) return findLCA(root.right, f1, f2);
        else if(root.value > f1 && root.value > f2) return findLCA(root.left, f1, f2);
        else return root;
    }
    public static Node buildTree(int[] nums) {
        Node root = null;
        for(int i = 0; i < nums.length; i++) {
            Node newNode = new Node(nums[i]);
            if(root == null) {
                root = newNode;
                continue;
            }
            addToBST(root, newNode);
        }
        return root;
    }

    public static Node addToBST(Node root, Node newNode) {
        if(root == null) return newNode;
        if(root.value > newNode.value) {
            root.left = addToBST(root.left , newNode);
        }
        else if(root.value < newNode.value) {
            root.right = addToBST(root.right, newNode);
        }
        return root;
    }
}
