//Partition Array Into Three Parts With Equal Sum
public class P1013 {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int x : A)
            sum += x;
        if (sum % 3 != 0)
            return false;

        int subSum = sum / 3;
        int curr = 0;
        int count = 0;
        int i = 0;
        for (int x : A) {
            curr += x;
            if (curr == subSum) {
                curr = 0;
                count++;
            }
            i++;
        }
        if (count > 3 && curr == 0)
            return true;

        return count == 3 && i == A.length;
    }
}