public class StringSubset {
    public static void main(String args[]) {
        String input = "abc";
        String output = "";

        solve(input, output);
    }

    public static void solve(String input, String output) {
        if(input.length() == 0) {
            System.out.println(output);
            return;
        }

        solve(input.substring(1), output);
        solve(input.substring(1), output + input.charAt(0));
    }


}