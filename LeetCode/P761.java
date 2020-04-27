// Special Binary String

import java.util.*;
public class P761 {
    public String makeLargestSpecial(String S) {
        int count = 0;
        int i = 0;
        
        List<String> lst = new ArrayList<>();
        for(int j = 0; i < S.length(); j++) {
            if(S.charAt(j) == '1') count++;
            else count--;
            
            if(count == 0) {
                lst.add('1' + makeLargestSpecial(S.substring(i+1, j)) +'0');
                i = j + 1;
            }
        }
        
        Collections.sort(lst, Collections.reverseOrder());
        return String.join("", lst);
    }
}