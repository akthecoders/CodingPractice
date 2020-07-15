import java.util.ArrayList;
import java.util.List;
//Restore IP Addresses
public class P93 {
    public List<String> restoreIpAddresses(String s) {
        List<Integer> dots = new ArrayList<>();
        List<String> result = new ArrayList<>();
        dots.add(0);

        backtrack(dots, s, result);
        return result;
    }

    public void backtrack(List<Integer> dots, String s, List<String> res) {
        if (dots.size() == 4) {
            if (!isValid(dots.get(3), s.length(), s))
                return;
            res.add(insert(dots, s));
            return;
        }

        int prevPos = dots.get(dots.size() - 1);
        for (int i = prevPos + 1; i < s.length(); i++) {
            if (!isValid(prevPos, i, s))
                break;
            dots.add(i);
            backtrack(dots, s, res);
            dots.remove(dots.size() - 1);
        }
        return;
    }

    public String insert(List<Integer> dots, String s) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = dots.size() - 1; i >= 1; i--) {
            sb.insert(dots.get(i).intValue(), ".");
        }
        return sb.toString();
    }

    public boolean isValid(int start, int end, String s) {
        if (end - start > 3)
            return false;

        return ((end - start == 1) || s.charAt(start) != '0') && (Integer.parseInt(s.substring(start, end)) <= 255);
    }
}