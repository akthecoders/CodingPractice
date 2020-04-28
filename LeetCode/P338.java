// Counting Bits
public class P338 {
    public int[] countBits(int num) {
        if (num == 0) return new int[]{0};
    
        int bits[] = new int[num+1];
        bits[0] = 0;
        bits[1] = 1;
        for(int i = 2; i <= num; i++) {
            bits[i] = (i&1) + bits[i>>1];
        }
        
        return bits;
    }
}