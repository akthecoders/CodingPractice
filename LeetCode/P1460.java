import java.util.Arrays;

///Make Two Arrays Equal by Reversing Sub-arrays
public class P1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }
}