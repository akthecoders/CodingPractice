class Node 
{ 
	int data; 
	Node left, right; 

	public Node(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

public class LowestCommonAncestorRecursion { 
	Node root; 
	static boolean v1 = false, v2 = false; 
 
	Node findLCA(int n1, int n2) 
	{ 
		v1 = false; 
		v2 = false; 

		Node lca = findLCAUtil(root, n1, n2); 

		if (v1 && v2) 
			return lca; 

		return null; 
	} 

    public Node findLCAUtil(Node root, int n1, int n2) {

        if(root == null) {
            return null;
        }

        Node temp = null;
        if(root.data == n1) {
            temp = root;
            v1 = true;
        }
        if(root.data == n2) {
            temp = root;
            v2 = true;
        }

        Node lst = findLCAUtil(root.left, n1, n2);
        Node rst = findLCAUtil(root.right, n1, n2);

        if(temp != null) {
            return temp;
        }

        if(lst != null && rst != null) {
            return root;
        }
        return (lst!= null) ? lst : rst;
    }

	public static void main(String args[]) 
	{ 
		LowestCommonAncestorRecursion tree = new LowestCommonAncestorRecursion(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.root.right.left = new Node(6); 
		tree.root.right.right = new Node(7); 

		Node lca = tree.findLCA(4, 5); 
		if (lca != null) 
			System.out.println("LCA(4, 5) = " + lca.data); 
		else
			System.out.println("Keys are not present"); 

		lca = tree.findLCA(4, 10); 
		if (lca != null) 
			System.out.println("LCA(4, 10) = " + lca.data); 
		else
			System.out.println("Keys are not present"); 
	} 
} 
