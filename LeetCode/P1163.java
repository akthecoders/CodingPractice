// Last Substring in Lexicographical Order
public class P1163 {
    public String lastSubstring(String str) {
        String mx = ""; 
        char cur = 'a';
        for (int i = 0; i < str.length(); i++) { 
            if (str.charAt(i) >= cur && mx.compareTo(str.substring(i)) <= 0) { 
                cur = str.charAt(i);
                mx = str.substring(i);  
            } 
            while(i != str.length() -1 && str.charAt(i) == str.charAt(i+1)) i++;
        } 
        return mx;
    }
}