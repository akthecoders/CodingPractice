import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Swap For Longest Repeated Character Substring
public class P1156 {
    public int maxRepOpt1(String text) {
        HashMap<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            List<Integer> list = map.get(c);
            if (list == null)
                list = new ArrayList<Integer>();
            list.add(i);
            map.put(c, list);
        }
        int res = 0;
        for (Map.Entry<Character, List<Integer>> itr : map.entrySet()) {
            List<Integer> value = itr.getValue();
            int prev = 0;
            int curr = 1;
            int SUM = 0;

            if (value.size() == 1) {
                SUM = prev + curr;
            } else {
                for (int i = 1; i < value.size(); i++) {
                    if (value.get(i) == value.get(i - 1) + 1) {
                        curr++;
                    } else if (value.get(i) == value.get(i - 1) + 2) {
                        prev = curr;
                        curr = 1;
                    } else {
                        prev = 0;
                        curr = 1;
                    }
                    SUM = Math.max(SUM, curr + prev);
                }
            }
            res = Math.max(res, SUM + (SUM < value.size() ? 1 : 0));
        }
        ;
        return res;
    }
}