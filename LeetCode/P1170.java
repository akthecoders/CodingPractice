import java.util.Arrays;

///Compare Strings by Frequency of the Smallest Character
public class P1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int fQuery[] = new int[queries.length];
        int fWords[] = new int[words.length];

        int alph[] = new int[26];
        for (int i = 0; i < queries.length; i++) {
            Arrays.fill(alph, 0);
            for (Character x : queries[i].toCharArray()) {
                alph[x - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (alph[j] != 0) {
                    fQuery[i] = alph[j];
                    break;
                }
            }
        }
        for (int i = 0; i < words.length; i++) {
            Arrays.fill(alph, 0);
            for (Character x : words[i].toCharArray()) {
                alph[x - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (alph[j] != 0) {
                    fWords[i] = alph[j];
                    break;
                }
            }
        }
        int result[] = new int[fQuery.length];
        for (int i = 0; i < fQuery.length; i++) {
            int num = fQuery[i];
            int ans = 0;
            for (int j = 0; j < words.length; j++) {
                if (num < fWords[j])
                    ans++;
            }
            result[i] = ans;
        }
        return result;
    }
}