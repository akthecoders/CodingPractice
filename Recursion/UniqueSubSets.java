import java.util.HashSet;
import java.util.Iterator;

public class UniqueSubSets {
    public static void main(String args[]) {
        String input = "ab";
        HashSet<String> set = new HashSet<>();
        solve(input, set, "");

        Iterator<String> itr = set.iterator();
        while(itr.hasNext()) {
            System.out.print(itr.next() + ", ");
        }
        System.out.println();
        String input1 = "aab";
        HashSet<String> set1 = new HashSet<>();
        solve(input1, set1, "");
        Iterator<String> itr1 = set1.iterator();
        while(itr1.hasNext()) {
            System.out.print(itr1.next() + ", ");
        }
    }

    public static void solve(String input, HashSet<String> set, String output) {
        if(input.length() == 0) {
            set.add(output);
            return;
        }

        solve(input.substring(1), set, output);
        solve(input.substring(1), set, output + input.charAt(0));
    }
}