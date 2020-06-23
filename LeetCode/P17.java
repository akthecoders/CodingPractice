import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Letter Combinations of a Phone Number
/**
 * P17
 */
public class P17 {

    Map<String, String> phone;
    List<String> output = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        phone = new HashMap<>() {
            /**
             *
             */
            private static final long serialVersionUID = -2723277185625607161L;

            {
                put("2", "abc");
                put("3", "def");
                put("4", "ghi");
                put("5", "jkl");
                put("6", "mno");
                put("7", "pqrs");
                put("8", "tuv");
                put("9", "wxyz");
            }
        };
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }

    public void backtrack(String comb, String digits) {
        if (digits.length() == 0) {
            output.add(comb);
            return;
        }

        String digit = digits.substring(0, 1);
        String letters = phone.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            String letter = letters.substring(i, i + 1);
            backtrack(comb + letter, digits.substring(1));
        }
    }
}