//Hamming Distance
public class P461 {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}