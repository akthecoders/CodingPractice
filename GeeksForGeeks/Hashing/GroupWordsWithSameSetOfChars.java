import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * GroupWordsWithSameSetOfChars
 */
public class GroupWordsWithSameSetOfChars {
    static final int MAX_CHAR = 26; 

    public static String getKey(String str) {
        boolean[] visited = new boolean[MAX_CHAR]; 
        Arrays.fill(visited, false); 
        for (int j = 0; j < str.length(); j++) 
            visited[str.charAt(j) - 'a'] = true ; 
        String key = ""; 
        for (int j=0; j < MAX_CHAR; j++) 
            if (visited[j]) 
                key = key + (char)('a'+j); 
        return key; 
    }

    public static void wordsWithSameCharSet(String[] words, int n) {
        HashMap<String, ArrayList<Integer>> hash = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String key = getKey(words[i]);

            if(hash.containsKey(key)) {
                ArrayList<Integer> tmp = hash.get(key);
                tmp.add(i);
                hash.put(key, tmp);
            }
            else {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                hash.put(key, tmp);
            }
        }

        for(Entry<String, ArrayList<Integer>> it: hash.entrySet()) {
            ArrayList<Integer> get = it.getValue();
            for(Integer v:get) {
                System.out.print(words[v] + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String words[] = { "may", "student", "students", "dog", 
                     "studentssess", "god", "cat", "act", "tab", 
                     "bat", "flow", "wolf", "lambs", "amy", "yam", 
                     "balms", "looped", "poodle"}; 
        int n = words.length; 
        wordsWithSameCharSet(words, n);
    }
}