import java.util.HashMap;

public class ScrambledString {
    static HashMap<String,Boolean> hm = new HashMap<>();
    public static void main(String[] args) {
        String a = "great";
        String b = "eatgr";

        if(a.length() != b.length()) { System.out.println(false); return;}
        if(a.compareTo(b) == 0) {System.out.println(true); return;}
        if(a.length() <= 1 || b.length() <= 1) { System.out.println(false); return;}

        System.out.println(solve(a, b));
    }

    public static boolean solve(String a, String b) {
        if(a.compareTo(b) == 0) return true;
        if(a.length() <= 1) return false;

        int n = a.length();
        String key = a+" "+b;
        if(hm.containsKey(key)){
            return (boolean)hm.get(key);
        }
        boolean flag=false;
        for(int i = 1; i < n; i++) {
            if(solve(a.substring(0, i), b.substring(n - i, n)) == true && solve(a.substring(i, n), b.substring(0, n - i))  == true) {
                flag =  true;
                break;
            }
            else if(solve(a.substring(0, i), b.substring(0, i)) == true && solve(a.substring(i), b.substring(i))  == true) {
                flag =  true;
                break;
            }
        }
        hm.put(key, flag);
        return flag;

    }
}