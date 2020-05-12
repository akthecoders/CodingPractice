import java.util.HashSet;
import java.util.Set;

//Unique Email Addresses
public class P929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            String s = "";
            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == '.') {
                    continue;
                } else if (email.charAt(i) == '+') {
                    while (email.charAt(i) != '@') {
                        i++;
                    }
                    i--;
                } else if (email.charAt(i) == '@') {
                    s = s + email.substring(i);
                    break;
                } else {
                    s += email.charAt(i);
                }
            }
            set.add(s);
        }
        return set.size();
    }
}