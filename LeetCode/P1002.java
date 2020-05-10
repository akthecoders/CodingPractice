import java.util.ArrayList;
import java.util.List;

//Find Common Characters
public class P1002 {
    public List<String> commonChars(String[] A) {
        List<String> rval = new ArrayList<String>();

        int[][] charFreqTable = new int[A.length][26];
        for (int wordIdx = 0; wordIdx < A.length; wordIdx++) {
            String aWord = A[wordIdx];
            for (char aChar : aWord.toCharArray()) {
                // Get char slot number.
                int slot = (int) aChar - 'a';
                charFreqTable[wordIdx][slot]++;
            }
        }

        // Determine fully filled cols.
        for (int cIdx = 0; cIdx < 26; cIdx++) {
            int charFreq = Integer.MAX_VALUE;
            String charStr = Character.toString((char) (cIdx + 'a'));
            boolean include = true;
            for (int rIdx = 0; rIdx < A.length; rIdx++) {
                // This word does not contain this char.
                // Ignore this character.
                if (charFreqTable[rIdx][cIdx] == 0) {
                    include = false;
                    break;
                } else {
                    charFreq = Math.min(charFreq, charFreqTable[rIdx][cIdx]);
                }
            }
            if (include) {
                for (int times = 0; times < charFreq; times++) {
                    rval.add(charStr);
                }
            }
        }
        return rval;
    }
}