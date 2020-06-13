import java.util.ArrayList;
import java.util.List;

//Keyboard Row
public class P500 {
    String first = "qwertyuiopQWERTYUIOP";
    String second = "asdfghjklASDFGHJKL";
    String third = "zxcvbnmZXCVBNM";

    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (oneRow(word))
                list.add(word);
        }
        return list.toArray(new String[0]);
    }

    public boolean oneRow(String word) {
        boolean f = false, s = false, t = false;
        for (char c : word.toCharArray()) {
            if (first.indexOf(c) > -1)
                f = true;
            else if (second.indexOf(c) > -1)
                s = true;
            else if (third.indexOf(c) > -1)
                t = true;
            if (f && s || s && t || t && f)
                return false;
        }
        return true;
    }
}