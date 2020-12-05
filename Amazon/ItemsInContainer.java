public class ItemsInContainer {
    public static void main(String[] args) {
        String input = "|**|*|*";
                     // 0002233
        int[] startIndex = {1, 1};
        int[] endIndex = {5, 6};

        solve(input, startIndex, endIndex);
    }

    public static void solve(String input, int[] start, int[] end) {
        int sum[] = new int[input.length()];

        boolean first = false;

        int index = 0;
        int stars = 0;
        for(char c: input.toCharArray()) {
            if(!first) {
                if(c == '|') {
                    first = true;
                }
                sum[index++] = 0;
            }
            else {
                if (c == '|') {
                    sum[index] = stars + sum[index - 1];
                    stars = 0;
                    index++;
                } else if (c == '*') {
                    stars++;
                    sum[index] = sum[index - 1];
                    index++;
                }
            }

        }
        for(int i: sum) {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i = 0; i < start.length; i++) {
            int s = start[i] - 1;
            int e = end[i] - 1;
            System.out.println(sum[e] - sum[s]);
        }
    }
}
