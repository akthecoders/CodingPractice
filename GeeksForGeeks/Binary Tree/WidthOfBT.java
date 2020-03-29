/**
 * WidthOfBT
 */
public class WidthOfBT {
    static int maximum;
    static int minimum;
    static Node root;
    static class Node {
        int data;
        Node left = null, right = null;
    }
    static Node newNode(int data) 
{ 
    Node curr = new Node(); 
    curr.data = data; 
    curr.left = curr.right = null; 
    return curr; 
} 
static int getLength(Node root) 
{ 
    maximum = 0; minimum = 0; 
    lengthUtil(root, 0);   
    return (Math.abs(minimum) + maximum) + 1; 
} 

public static void lengthUtil(Node root, int dist) {
    if(root == null) {
        return;
    }

    if(maximum < dist) {
        maximum = dist;
    }
    if(minimum > dist) {
        minimum = dist;
    }

    lengthUtil(root.left, dist - 1);
    lengthUtil(root.right, dist + 1);
}
    public static void main(String[] args) {
        Node root = newNode(7);
        root.left = newNode(6);
        root.right = newNode(5);
        root.left.left = newNode(4);
        root.left.right = newNode(3);
        root.right.left = newNode(2);
        root.right.right = newNode(1);

        System.out.println(getLength(root));
    }
}