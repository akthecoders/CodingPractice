/**
 * AncestorMatrix
 */
import java.util.*;
public class AncestorMatrix {

    static class Node {
        int key;
        Node left = null, right = null;
        public Node(int data) {
            key = data;
        }
    }

    public static void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public static void insertIntoMultiMap(Map<Integer,List<Integer>> map, Integer key, Integer value) {
		if (!map.containsKey(key)) {
			map.put(key, new ArrayList<>());
		}
		map.get(key).add(value);
	}

    public static Node constructBT(int[][] mat) {
        int N = mat.length;
        Map<Integer, List<Integer>> multimap = new TreeMap<>();
        for(int i = 0; i < N; i++) {
            int sum = Arrays.stream(mat[i]).sum();
            insertIntoMultiMap(multimap, sum, i);
        }

        Node[] node = new Node[N];
        int last = 0;
        boolean[] parent = new boolean[N];

        for(Map.Entry<Integer, List<Integer>> entry: multimap.entrySet()) {
            for(int row : entry.getValue()) {
                last = row;
                node[row] = new Node(row);
                if(entry.getKey() == 0) {
                    continue;
                }

                for(int i = 0; i < N; i++) {
                    if(parent[i] == false && mat[row][i] == 1) {
                        if(node[row].left == null) {
                            node[row].left = node[i];
                        }
                        else {
                            node[row].right = node[i];
                        }
                        parent[i] = true;
                    }
                }
            }
        }
        return node[last];
    }

    public static void main(String[] args) {
        int[][] mat =
		{
			{ 0, 0, 0, 0, 0 },
			{ 1, 0, 0, 0, 0 },
			{ 0, 0, 0, 1, 0 },
			{ 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 1, 0 }
		};

		Node root = constructBT(mat);
		inorder(root);
    }
}