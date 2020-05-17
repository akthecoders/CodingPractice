import java.util.HashSet;
import java.util.Set;

//Check If N and Its Double Exist
public class P1346 {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int noOfZeros = 0;
        for (int x : arr) {
            if (x == 0)
                noOfZeros++;
            set.add(x);
        }
        for (int x : arr) {
            if (x != 0 && set.contains(2 * x)) {
                return true;
            } else if (x == 0) {
                if (noOfZeros % 2 == 0)
                    return true;
            }
        }
        return false;
    }
}