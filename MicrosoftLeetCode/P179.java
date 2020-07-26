import java.util.Arrays;
import java.util.Comparator;

//Largest Number
public class P179 {
    public class CompareLargest implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        String[] temp = new String[nums.length];
        int i = 0;
        for (int x : nums) {
            temp[i++] = String.valueOf(x);
        }
        Arrays.sort(temp, new CompareLargest());
        if (temp[0].equals("0")) {
            return "0";
        }
        String result = "";
        for (String t : temp) {
            result += t;
        }

        return result;
    }
}