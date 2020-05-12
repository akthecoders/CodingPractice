import java.util.ArrayList;

// Reformat The String
public class P1417 {
    public String reformat(String s) {
        if (s.length() <= 1)
            return s;
        ArrayList<Integer> digits = new ArrayList<>();
        ArrayList<Character> letters = new ArrayList<>();

        for (Character c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                letters.add(c);
            } else {
                digits.add(Integer.parseInt(Character.toString(c)));
            }
        }
        if (digits.size() == 0)
            return "";
        if (letters.size() == 0)
            return "";
        if (Math.abs(digits.size() - letters.size()) > 1)
            return "";

        String str = "";
        if (digits.size() >= letters.size()) {
            for (int i = 0, j = 0; i < digits.size(); i++) {
                str += digits.get(i);
                if (j < letters.size()) {
                    str += letters.get(j);
                    j++;
                }
            }
        } else {
            for (int i = 0, j = 0; i < letters.size(); i++) {
                str += letters.get(i);
                if (j < digits.size()) {
                    str += digits.get(j);
                    j++;
                }
            }
        }

        return str;
    }
}