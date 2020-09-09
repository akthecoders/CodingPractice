import java.util.Stack;

//Decode String
public class P394 {
    public String decodeString(String s) {
        if (s.length() == 0)
            return "";
        if (s.length() == 1)
            return s;

        Stack<Integer> iS = new Stack<>();
        Stack<String> sS = new Stack<>();
        String res = "";
        for (int i = 0; i < s.length(); i++) {

            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
                System.out.println("num " + num);
                iS.push(num);
            } else if (s.charAt(i) == '[') {
                System.out.println("[" + res);
                sS.push(res);
                res = "";
            } else if (s.charAt(i) == ']') {
                System.out.println("] stack " + sS.peek());
                StringBuilder sb = new StringBuilder(sS.pop());
                int itr = iS.pop();
                for (int j = 0; j < itr; j++) {
                    sb.append(res);
                }
                System.out.println("] res " + sb.toString());
                res = sb.toString();
            } else {
                res += s.charAt(i);
                System.out.println("res " + res);
            }
        }
        return res;
    }
}
