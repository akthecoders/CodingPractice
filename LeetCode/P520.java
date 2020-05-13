//Detect Capital
public class P520 {
    public boolean detectCapitalUse(String word) {
        int caps = 0;
        for (Character c : word.toCharArray()) {
            if (Character.isUpperCase(c))
                caps++;
        }

        if (caps == word.length())
            return true;
        if (caps == 0)
            return true;
        return caps == 1 && Character.isUpperCase(word.charAt(0));
    }
}