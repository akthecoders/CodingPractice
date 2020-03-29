import java.util.LinkedList;
import java.util.Queue;

/**
 * CheckLevelOrderIsBST
 */
public class CheckLevelOrderIsBST {

    public static void main(String[] args) {
        int arr[] = { 7, 4, 12, 3, 6, 8, 1, 5, 10 };
        int n = arr.length;
        if (levelOrderIsOfBST(arr, n))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    static class Node {
        int data;
        int min;
        int max;
        public Node(int item, int mi, int mx) {
            data = item;
            min = mi;
            max = mx;
        }
    }

    public static boolean levelOrderIsOfBST(int[] arr, int n) {
        int i = 0;
        Queue<Node> q = new LinkedList<>();
        Node newNode = new Node(arr[i++], Integer.MIN_VALUE, Integer.MAX_VALUE);
        q.add(newNode);

        while(!q.isEmpty()) {
            Node temp = q.peek();
            q.remove();
            newNode = new Node(0, 0 ,0);
            if(i < n && temp.data > arr[i] && arr[i] > temp.min && arr[i] < temp.max ) {
                q.add(new Node(arr[i++], temp.min, temp.data));
            }
            if(i < n && temp.data < arr[i] && arr[i] > temp.min && arr[i] < temp.max) {
                q.add(new Node(arr[i++], temp.data, temp.max));
            }
        }

        if(i == n) {
            return true;
        }
        return false;
    }
}