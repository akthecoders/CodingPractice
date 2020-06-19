import java.util.HashMap;

//Alphabet Board Path
public class P1138 {
    class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public String alphabetBoardPath(String target) {
        HashMap<Character, Pair> map = new HashMap<>();
        int posx = 0;
        int posy = 0;
        int index = 0;
        for (int i = 0; i < 26; i++) {
            map.put((char) (i + 'a'), new Pair(i % 5, i / 5));
        }
        StringBuilder output = new StringBuilder();
        while (index < target.length()) {
            Pair p = map.get(target.charAt(index));

            while (p.y < posy) {
                posy--;
                output.append('U');
            }

            while (p.x < posx) {
                posx--;
                output.append('L');
            }

            while (p.y > posy) {
                posy++;
                output.append('D');
            }

            while (p.x > posx) {
                posx++;
                output.append('R');
            }
            index++;
            output.append('!');
        }
        return output.toString();
    }
}