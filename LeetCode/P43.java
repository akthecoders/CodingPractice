//Multiply Strings
public class P43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        StringBuilder multiplier;
        StringBuilder multiplicant;
        if (num1.length() < num2.length()) {
            multiplier = new StringBuilder(num1);
            multiplicant = new StringBuilder(num2);
        } else {
            multiplier = new StringBuilder(num2);
            multiplicant = new StringBuilder(num1);
        }
        // reverse string so that 0th character is last digit.
        multiplier.reverse();
        multiplicant.reverse();

        StringBuilder result = new StringBuilder(num1.length() + num2.length() + 1);

        for (int i = 0; i < multiplier.length(); i++) {
            multiplyAdd(result, multiplicant, multiplier, i);
        }

        result.reverse();
        return result.toString();
    }

    public void multiplyAdd(StringBuilder accumulator, StringBuilder num1, StringBuilder num2, int exponentNum2) {
        int carry = 0;
        int digit = 0;

        int multiplierDigit = num2.charAt(exponentNum2) - '0';

        if (multiplierDigit == 0) {
            return;
        }

        int accumulatorIndex = exponentNum2;
        for (int i = 0; i < num1.length(); i++, accumulatorIndex++) {
            int num1Digit = num1.charAt(i) - '0';
            int product = num1Digit * multiplierDigit + carry;
            digit = product % 10;
            carry = product / 10;

            if (digit == 0) {
                continue;
            }

            if (accumulator.length() <= accumulatorIndex) {
                while (accumulator.length() <= accumulatorIndex) {
                    accumulator.append('0');
                }
                accumulator.setCharAt(accumulatorIndex, (char) (digit + '0'));
            } else {
                int accumulatorDigit = accumulator.charAt(accumulatorIndex) - '0';
                digit += accumulatorDigit;
                carry += digit / 10;
                digit %= 10;
                accumulator.setCharAt(accumulatorIndex, (char) (digit + '0'));
            }
        }

        if (carry > 0) {
            if (accumulator.length() <= accumulatorIndex) {
                while (accumulator.length() <= accumulatorIndex) {
                    accumulator.append('0');
                }
                accumulator.setCharAt(accumulatorIndex, (char) (carry + '0'));
            } else {
                int accumulatorDigit = accumulator.charAt(accumulatorIndex) - '0';
                digit += accumulatorDigit;
                carry += digit / 10;
                digit %= 10;
                accumulator.setCharAt(accumulatorIndex, (char) (carry + '0'));
            }
        }
    }
}