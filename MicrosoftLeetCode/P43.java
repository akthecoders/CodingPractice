//Multiply Strings
public class P43 {

    public String multiply(String num1, String num2) {
        int i = num1.length() - 1;
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[num1.length() + num2.length()];
        while (i >= 0) {
            int a1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int j = num2.length() - 1;
            while (j >= 0) {
                int a2 = j >= 0 ? num2.charAt(j) - '0' : 0;
                int prod = (a1 * a2) + arr[i + j + 1];
                arr[i + j + 1] = prod % 10;
                arr[i + j] += prod / 10;

                j--;
            }
            i--;
        }
        boolean leadingZero = false;
        for (int k = 0; k < arr.length; k++) {
            if (k == 0 && arr[k] == 0)
                leadingZero = true;
            else if (arr[k] != 0)
                leadingZero = false;
            if (!leadingZero)
                sb.append(arr[k]);
        }
        return sb.toString().isEmpty() ? "0" : sb.toString();
    }
}