import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Palindrome Pairs
public class P336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (isPalindrome(words[i] + words[j])) {
                    list.add(Arrays.asList(i, j));
                }
                if (isPalindrome(words[j] + words[i])) {
                    list.add(Arrays.asList(j, i));
                }
            }
        }

        return list;
    }

    boolean isPalindrome(String str) {

        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}