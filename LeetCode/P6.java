//ZigZag Conversion
public class P6 {
    public String convert(String s, int numRows) {
        int n = s.length() - 1;
        if (numRows == 1)
            return s;
        String memory[] = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            memory[i] = "";
        }

        int flag = 1;
        int index = 0;
        int start = 0;

        while (start <= n) {
            if (index == 0) {
                flag = 1;
            } else if (index == numRows - 1) {
                flag = -1;
            }

            memory[index] += s.charAt(start++);
            index += flag;
        }

        String result = "";
        for (int i = 0; i < numRows; i++) {
            result += memory[i];
        }
        return result;
    }
}