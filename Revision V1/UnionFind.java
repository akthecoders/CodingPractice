public class UnionFind {
    private int size;
    private int sz [];
    private int id [];
    private int numOfComponents;

    public UnionFind(int size) {
        if(size < 0) throw new IllegalArgumentException("Size <= 0 is not allowed");
        this.size = numOfComponents = size;
        sz = new int[size];
        id = new int[size];
        for(int i = 0; i < size; i++) {
            sz[i] = 1;
            id[i] = i;
        }
    }

    public int find(int p) {
        int root = p;
        while(root != id[root]) {
            root = id[root];
        }

        while(p != root) {
            int next = id[p];
            id[p] = root;
            p = next;
        }
        return root;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int componentSize(int p) {
        return sz[find(p)];
    }

    public int size() {
        return size;
    }

    public int components() {
        return numOfComponents;
    }

    public void unify(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if(rootP == rootQ) return;

        if(sz[rootP] < sz[rootQ]) {
            sz[rootQ] += sz[rootP];
            id[rootP] = rootQ;
        }
        else {
            sz[rootP] += sz[rootQ];
            id[rootQ] = rootP;
        }
    }

    public void print() {
        System.out.println("--------------------------------------------");
        for(int i = 0; i < this.size; i++) {
            System.out.println(i + " -> " + id[i]);
        }
        System.out.println("--------------------------------------------");
    }

    public static void main(String[] args) {
        /**
         * Let us take example as
         * 0, 1, 2, 3, 4, 5 
         * Union(0, 1)
         * Union(2, 3)
         * Union(4, 5)
         * Union(0, 3)
         * Union(0, 2)
         * Union(1, 3)
         * Union(1, 5)
         */
        
        UnionFind worker = new UnionFind(6);

        worker.print();
        worker.unify(0, 1);
        worker.print();
        worker.unify(2, 3);
        worker.print();
        worker.unify(4, 5);
        worker.print();
        worker.unify(0, 3);
        worker.print();
        worker.unify(0, 2);
        worker.print();
        worker.unify(1, 3);
        worker.print();
        worker.unify(1, 5);
        worker.print();
    }
}

