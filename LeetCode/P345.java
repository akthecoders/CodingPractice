import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Reverse Vowels of a String
public class P345 {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] arr = s.toCharArray();
        int l = 0, r = arr.length - 1;
        while (l < r) {
            while (l < r && !set.contains(arr[r]))
                r--;
            while (l < r && !set.contains(arr[l]))
                l++;
            char tmp = arr[r];
            arr[r--] = arr[l];
            arr[l++] = tmp;
        }
        return String.valueOf(arr);
    }
}