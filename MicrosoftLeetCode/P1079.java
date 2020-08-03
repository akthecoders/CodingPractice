import java.util.HashSet;

//Letter Tile Possibilities
public class P1079 {
    static HashSet<String> letters;

    public int numTilePossibilities(String tiles) {
        letters = new HashSet<>();
        if (tiles.length() == 0)
            return 0;
        if (tiles.length() == 1)
            return 1;

        solver(tiles, "");
        return letters.size();
    }

    public static void solver(String input, String output) {
        if (input.length() == 0 && output.length() != 0) {
            letters.add(output);
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            String newString = input.substring(0, i) + input.substring(i + 1, input.length());
            char cut = input.charAt(i);

            solver(newString, output);
            solver(newString, output + cut);
        }
        return;
    }
}