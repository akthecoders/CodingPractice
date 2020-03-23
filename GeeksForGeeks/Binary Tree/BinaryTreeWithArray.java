/**
 * BinaryTreeWithArray
 */
public class BinaryTreeWithArray {
    static int tree[] = new int[20];
    static int pointer = -1;

    public static void insert(int data) {
        tree[++pointer] = data;
    }

    public static void traverse() {
        for (int i : tree) {
            if(i != 0) System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        insert(1);
        insert(2);
        insert(3);
        insert(4);
        insert(5);
        insert(6);
        insert(7);
        insert(8);
        insert(9);
        insert(10);
        traverse();
    }
}