// Basic Calculator
import java.util.*;
public class P224 {
    public int calculate(String s) {
        return eval(convertInfixToRPN(s));
    }

    public static int eval(Queue<String> Q) {
        Stack<Integer> stack = new Stack<Integer>();
        while (!Q.isEmpty()) {
            String symbol = Q.remove();

            if (symbol.equals("+")) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x + y);

            } else if (symbol.equals("-")) {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x - y);
            } else { // symbol is a number.
                stack.push(Integer.parseInt(symbol));
            }
        }
        return stack.pop();
    }

    Queue<String> convertInfixToRPN(String infixNotation) {
        Queue<String> Q = new LinkedList<>();
        Stack<String> S = new Stack<>();

        for (int i = 0; i < infixNotation.length(); i++) {
            char token = infixNotation.charAt(i);
            if (token == ' ')
                continue;
            else if ('(' == token) {
                S.push("(");
            }

            else if (')' == token) {
                while (S.peek() != "(") {
                    Q.add(S.pop());
                }
                S.pop();
            }
            // an operator
            else if (token == '+' || token == '-') {
                while (!S.empty() && (S.peek().equals("+") || S.peek().equals("-"))) {
                    Q.add(S.pop());
                }
                S.push(token + "");
            }

            else if (token >= '0' && token <= '9') {
                int result = token - '0';
                while (i + 1 < infixNotation.length()
                        && (infixNotation.charAt(i + 1) >= '0' && infixNotation.charAt(i + 1) <= '9')) {
                    result = result * 10 + (infixNotation.charAt(i + 1) - '0');
                    i++;
                }
                Q.add(result + "");
            }
        }
        while (!S.isEmpty()) {
            Q.add(S.pop());
        }
        return Q;
    }
}