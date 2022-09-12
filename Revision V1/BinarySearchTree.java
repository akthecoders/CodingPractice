import java.util.LinkedList;

public class BinarySearchTree <T extends Comparable<T>> {
    private int nodeCount = 0;
    private Node root = null;

    private class Node {
        T data;
        Node left, right;
        public Node(Node left, Node right, T data) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    } 
    
    public boolean isEmpty() {
        return size() == 0;
    }
    
    public int size() {
        return nodeCount;
    }

    public boolean add(T elem) {
        if(contains(elem)) return false;
        root = add(root, elem);
        nodeCount++;
        return true;
    }

    private Node add(Node root, T elem) {
        if(root == null) return new Node(null, null, elem);
        if(elem.compareTo(root.data) < 0) root.left = add(root.left, elem);
        else root.right = add(root.right, elem);
        return root;
    }

    public boolean remove(T elem) {
        if(!contains(elem)) return false;

        root = remove(root, elem);
        nodeCount--;
        return true;
    }

    public Node remove(Node root, T elem) {
        if(root == null) return null;
        if(elem.compareTo(root.data) < 0) {
            root.left = remove(root.left, elem);
        } 
        else if(elem.compareTo(root.data) > 0) {
            root.right = remove(root.right, elem);
        }
        else {
            if(root.left == null) {
                Node rightChild = root.right;
                root.data = null;
                root = null;
                return rightChild;
            }
            else if(root.right == null) {
                Node leftChild = root.left;
                root.data = null;
                root = null;
                return leftChild;
            }
            else {
                Node largestInLeftSubTree = digRight(root.left);
                root.data = largestInLeftSubTree.data;
                root.left = remove(root.left, root.data);
            }
        }
        return root;
    }

    private Node digRight(Node root) {
        while(root.right != null) root = root.right;
        return root;
    }

    public boolean contains(T elem) {
        return contains(root, elem);
    }

    private boolean contains(Node root, T elem) {
        if(root == null) return false;
        if(elem.compareTo(root.data) < 0) {
            return contains(root.left, elem);
        }
        else if(elem.compareTo(root.data) > 0) {
            return contains(root.right, elem);
        }
        else {
            return true;
        }
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
    
    public void traverse(TreeRaversalOrder order) {
        System.out.println();
        switch (order) {
            case PRE_ORDER: preOrderTraversal(root); break;
            case POST_ORDER: postOrderTraversal(root); break;
            case IN_ORDER: inOrderTraversal(root); break;
            case LEVEL_ORDER: levelOrderTraversal(root); break;       
            default: break;
        }
    }

    private void preOrderTraversal(Node root) {
        if(root == null) return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    
    private void postOrderTraversal(Node root) {
        if(root == null) return;
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        System.out.print(root.data + " ");
        
    }
    
    private void inOrderTraversal(Node root) {
        if(root == null) return;
        preOrderTraversal(root.left);
        System.out.print(root.data + " ");
        preOrderTraversal(root.right);
    }
    
    private void levelOrderTraversal(Node root) {
        if(root == null) return;
        LinkedList<BinarySearchTree<T>.Node> q = new LinkedList<Node>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node get = q.poll();
                System.out.print(get.data + " ");
                if(get.left != null) q.offer(get.left);
                if(get.right != null) q.offer(get.right);
            }
            System.out.println();
        }
    }

    public static void main(String args []) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(4);
        tree.add(3);
        tree.add(0);
        tree.add(33);
        tree.add(2);
        tree.add(1);
        tree.add(10);
        tree.traverse(TreeRaversalOrder.PRE_ORDER);
        tree.traverse(TreeRaversalOrder.IN_ORDER);
        tree.traverse(TreeRaversalOrder.POST_ORDER);
        tree.traverse(TreeRaversalOrder.LEVEL_ORDER);
    }
}
