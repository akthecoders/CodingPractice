//Number of Subarrays with Bounded Maximum
public class P795 {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int result = 0;
        int start = -1;
        int end = -1;
        for (int i = 0; i < A.length; i++) {
            String valType = A[i] >= L && A[i] <= R ? "NEEDED" : A[i] > R ? "RESET" : "OK";
            switch (valType) {
                case "NEEDED":
                    end = i;
                    break;
                case "RESET":
                    start = i;
                    end = i;
                    break;
                case "OK":
                    break;
            }

            result += end - start;
        }
        return result;
    }
}