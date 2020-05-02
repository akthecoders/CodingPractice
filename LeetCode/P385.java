
// Mini Parser
public class P385 {

    // public interface NestedInteger {
    //     // public NestedInteger();

    //     // public NestedInteger(int value);

    //     public boolean isInteger();

    //     public Integer getInteger();

    //     public void setInteger(int value);

    //     public void add(NestedInteger ni);

    //     public List<NestedInteger> getList();
    // }

    // public NestedInteger deserialize(String s) {
        // if (!s.startsWith("["))
        //     return new NestedInteger(Integer.valueOf(s));
        // Stack<NestedInteger> stack = new Stack<>();
        // NestedInteger res = new NestedInteger();
        // stack.push(res);
        // int num = 0;
        // int sign = 1;
        // for (int i = 1; i < s.length(); i++) {
        //     if (s.charAt(i) == '-') {
        //         sign = -1;
        //     } else if (Character.isDigit(s.charAt(i))) {
        //         num = s.charAt(i) - '0';
        //         while ((i + 1) < s.length() && Character.isDigit(s.charAt(i + 1))) {
        //             num = num * 10 + s.charAt(i + 1) - '0';
        //             i++;
        //         }
        //         stack.peek().add(new NestedInteger(num * sign));
        //         sign = 1;
        //     } else if (s.charAt(i) == '[') {
        //         NestedInteger tmp = new NestedInteger();
        //         stack.peek().add(tmp);
        //         stack.push(tmp);
        //     } else if (s.charAt(i) == ']') {
        //         stack.pop();
        //     }
        // }
        // return res;
    // }
}