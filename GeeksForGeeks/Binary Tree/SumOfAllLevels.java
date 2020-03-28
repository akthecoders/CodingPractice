/**
 * SumOfAllLevels
 */
public class SumOfAllLevels {

    static class Node {
        int data;
        Node left = null, right = null;
    }

    static Node newNode(int data) {
        Node Node = new Node();
        Node.data = data;
        Node.left = null;
        Node.right = null;

        return (Node);
    }

    static class Res {
        int res = 0;
        int level = 0;
    }

    public static Res getTotalHeight(Node root) {
        if(root == null) {
            return new Res();
        }

        if(root.left == null && root.right == null) {
            Res ret = new Res();
            ret.res = 1;
            ret.level = 1;
            return ret;
        }

        Res left = getTotalHeight(root.left);
        Res right = getTotalHeight(root.right);
        int currLevel = 1 + Math.max(left.level, right.level);
        int nextSum = currLevel + left.res + right.res;

        Res ret = new Res();
        ret.level = currLevel;
        ret.res = nextSum;
        return ret;
    }

    public static void main(String[] args) {
        Node root = newNode(1);

        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        Res data = getTotalHeight(root);
        System.out.println("Sum of heights of all Nodes = " + data.res);
    }
}