// K-th Symbol in Grammar
public class P779 {
    public int kthGrammar(int N, int K) {
        if (N == 0) {
            return 0;
        }
        int parent = kthGrammar(N - 1, (K + 1) / 2);

        return parent == 0 ? (1 - K % 2) : (K % 2);
    }
}