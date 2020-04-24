
import java.util.*;
public class P1361 {
    public static void main(String[] args) {
        int n = 4;
        int[] leftChild = {1,-1,3,-1};
        int[] rightChild = {2,-1,-1,-1};
        P1361 p = new P1361();
        System.out.println(p.validateBinaryTreeNodes(n, leftChild, rightChild));
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();

        for(int i = 0; i < leftChild.length; i++) {
            List<Integer> lt = map.get(i);
           if(lt == null) {
               lt = new ArrayList<Integer>();
           }
           if(leftChild[i]!= -1)
                lt.add(leftChild[i]);
            if(rightChild[i]!= -1)
                lt.add(rightChild[i]);
            map.put(i,lt);
        }

        UnionFind union = new UnionFind(n);

        for(Map.Entry<Integer, List<Integer>> mp: map.entrySet()) {
            int key = mp.getKey();
            List<Integer> list = mp.getValue();
            int k = union.find(key);
            for(int i = 0; i < list.size(); i++) {
                int v = union.find(list.get(i));
                if(k == v) {
                    return false;
                }
                else {
                    union.unionInit(k, v);
                }
            }
        }

        if(union.getCount() > 1) {
            return false;
        }
        return true;
    }

    class UnionFind {
        int count;
        int [] parent;
        public UnionFind(int n) {
            this.count = n;
            this.parent = new int[n];
            for(int i=0;i<n;i++)
                parent[i]=i;
        }

        public int getCount(){
            return count;
        }

        public void unionInit(int x, int y) {
            int i = find(x);
            int j = find(y);
            if(i != j) {
                parent[i] = j;
                count--;
            }
        }

        public int find(int i) {
            if(parent[i] == i) {
                return i;
            }
            return find(parent[i]);
        }
    }
}