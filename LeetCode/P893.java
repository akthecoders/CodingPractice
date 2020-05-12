import java.util.HashSet;

//Groups of Special-Equivalent Strings
public class P893 {
    public int numSpecialEquivGroups(String[] A) {
        HashSet<String> hs = new HashSet<>();
        String sTemp;
        int even, odd;
        for (String x : A) {
            even = 1;
            odd = 1;
            for (int i = 0; i < x.length(); i++) {
                if (i % 2 == 0)
                    even *= (int) x.charAt(i);
                else
                    odd *= (int) x.charAt(i);
            }

            sTemp = odd + " " + even;
            hs.add(sTemp);
        }
        return hs.size();
    }
}