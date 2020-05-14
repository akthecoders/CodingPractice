//Long Pressed Name
public class P925 {
    public boolean isLongPressedName(String name, String typed) {
        if(name.length() > typed.length()) return false;
        if(name.charAt(0) != typed.charAt(0)) return false;
        
        int i = 0;
        int j = 0;
        while( j < typed.length() ) {
            if(i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
            }
            else if(typed.charAt(j) != typed.charAt(j-1)){
                return false;
            }
            j++;
        }
        return i == name.length();
    }
}