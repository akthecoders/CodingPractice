package RangeQueries;

/**
 * MinRangeQueriesSegmentTree
 */
public class MinRangeQueriesSegmentTree {

    static class Query { 
        int L, R; 
    
        public Query(int L, int R) 
        { 
            this.L = L; 
            this.R = R; 
        } 
    };

    public static void main(String[] args) {
        int a[] = {7, 2, 3, 0, 5, 10, 3, 12, 18}; 
        int n = a.length; 
        Query q[] = {new Query(0, 4),  
                    new Query(4, 7),  
                    new Query(7, 8)}; 
        int tree[] = new int[20];
        buildTree(a, tree, 0, n - 1, 1);
        for (int i : tree) {
            System.out.print( i + " ");
        }
        System.out.println();
        System.out.println("Min : " + query(1, 0, n - 1, 7, 8, tree));
    }

    public static void buildTree(int[] arr, int[] tree, int start, int end, int node) {
        if(start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end ) / 2;

        buildTree(arr, tree, start, mid, 2 * node);
        buildTree(arr, tree, mid + 1, end, 2 * node + 1);
        int leftMin = tree[2 * node];
        int rightMin = tree[2 * node + 1];
        tree[node] = leftMin < rightMin ? leftMin : rightMin;
    }

    public static int query(int node, int start, int end, int l , int r, int[] tree) {
        if(end < l || start > r) {
            return 1;
        }
        if( l <= start && r >= end) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        int leftMin = query(2 * node, start, mid, l, r, tree);
        int rightMin = query(2 * node + 1 , mid + 1, end, l, r, tree);
        return leftMin < rightMin ? leftMin : rightMin;
    }
}