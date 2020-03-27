/**
 * PrintAllNodesFromDistanceKFromLeaf
 */
public class PrintAllNodesFromDistanceKFromLeaf {
    static Node root;
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        System.out.println(" Nodes at distance 2 are :");
        printKDistantfromLeaf(root, 2);
    }

    public static void printKDistantfromLeaf(Node root, int level) {
        int path[] = new int[500];
        boolean visited[] = new boolean[500];
        kDistanceFromLeafUtil(root, level, path, visited, 0);
    }

    public static void kDistanceFromLeafUtil(Node root, int level, int[] path, boolean [] visited, int pathLen) {
        if(root == null) {
            return;
        }

        path[pathLen] = root.data;
        visited[pathLen] = false;
        pathLen++;

        if(root.left == null && root.right == null && pathLen - level - 1 >= 0 && visited[pathLen - level - 1] == false) {
            System.out.print(path[pathLen - level - 1] + ' ');
            visited[pathLen - level - 1] = true;
            return;
        }

        kDistanceFromLeafUtil(root.left, level, path, visited, pathLen);
        kDistanceFromLeafUtil(root.right, level, path, visited, pathLen);
    }
}