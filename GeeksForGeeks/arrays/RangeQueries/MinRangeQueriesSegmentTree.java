package RangeQueries;

/**
 * MinRangeQueriesSegmentTree
 */
public class MinRangeQueriesSegmentTree {
    public static void main(String[] args) {
        int a[] = {1, 0, 2, 5, 12, 3}; 
        int n = a.length; 
        int tree[] = new int[30];
        buildTree(a, tree, 0, n - 1, 0);
        for (int i : tree) {
            System.out.print( i + " ");
        }
        System.out.println();
        System.out.println("Min : " + query(0, 0, n - 1, 3, 5, tree));
    }

    public static void buildTree(int[] arr, int[] tree, int start, int end, int node) {
        System.out.println(start + "-" + end + "-" + node);
        if(start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end ) / 2;

        buildTree(arr, tree, start, mid, 2 * node + 1);
        buildTree(arr, tree, mid + 1, end, 2 * node + 2);
        int leftMin = tree[2 * node + 1];
        int rightMin = tree[2 * node + 2];
        tree[node] = leftMin < rightMin ? leftMin : rightMin;
        return;
    }

    public static int query(int node, int start, int end, int l , int r, int[] tree) {
        if(r < start || l > end) {
            return Integer.MAX_VALUE;
        }
        if( l <= start && r >= end) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        int leftMin = query(2 * node + 1, start, mid, l, r, tree);
        int rightMin = query(2 * node + 2 , mid + 1, end, l, r, tree);
        return leftMin < rightMin ? leftMin : rightMin;
    }
}