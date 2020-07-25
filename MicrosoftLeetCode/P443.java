//String Compression
public class P443 {
    public int compress(char[] chars) {
        if (chars.length == 0)
            return 0;
        int count = 0;

        char prev = chars[0];
        int index = 0;
        int curr = 1;
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c == prev) {
                curr++;
            } else {
                chars[index] = prev;
                count++;
                index++;
                if (curr > 1) {
                    if (curr > 9) {
                        String str = "";
                        while (curr > 0) {
                            int t = curr % 10;
                            str += t;
                            curr = curr / 10;
                        }
                        char cs[] = str.toCharArray();
                        for (int m = cs.length - 1; m >= 0; m--) {
                            char css = cs[m];
                            chars[index++] = css;
                            count++;
                        }
                    } else {
                        chars[index] = (char) (curr + '0');
                        index++;
                        count++;
                    }
                }
                prev = c;
                curr = 1;
            }
        }
        chars[index] = prev;
        count++;
        index++;
        if (curr > 1) {
            if (curr > 9) {
                String str = "";
                while (curr > 0) {
                    int t = curr % 10;
                    str += t;
                    curr = curr / 10;
                }
                char cs[] = str.toCharArray();
                for (int m = cs.length - 1; m >= 0; m--) {
                    char css = cs[m];
                    System.out.println("css " + css);

                    chars[index++] = css;
                    count++;
                }
            } else {
                count++;
                chars[index] = (char) (curr + '0');
                index++;
            }
        }

        return count;
    }
}