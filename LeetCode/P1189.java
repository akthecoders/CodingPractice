import java.util.HashMap;

//Maximum Number of Balloons
public class P1189 {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : text.toCharArray()) {
            switch (c) {
                case 'b':
                case 'a':
                case 'l':
                case 'o':
                case 'n':
                    map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        int ans = 0;
        for (int i = 0; i < text.length() / "balloon".length(); i++) {
            boolean flag = true;
            if (map.containsKey('b')) {
                map.put('b', map.get('b') - 1);
                if (map.get('b') == 0) {
                    map.remove('b');
                }
            } else {
                flag = false;
            }
            if (map.containsKey('a')) {
                map.put('a', map.get('a') - 1);
                if (map.get('a') == 0) {
                    map.remove('a');
                }
            } else {
                flag = false;
            }
            if (map.containsKey('l')) {
                map.put('l', map.get('l') - 1);
                if (map.get('l') == 0) {
                    map.remove('l');
                }
            } else {
                flag = false;
            }
            if (map.containsKey('l')) {
                map.put('l', map.get('l') - 1);
                if (map.get('l') == 0) {
                    map.remove('l');
                }
            } else {
                flag = false;
            }
            if (map.containsKey('o')) {
                map.put('o', map.get('o') - 1);
                if (map.get('o') == 0) {
                    map.remove('o');
                }
            } else {
                flag = false;
            }
            if (map.containsKey('o')) {
                map.put('o', map.get('o') - 1);
                if (map.get('o') == 0) {
                    map.remove('o');
                }
            } else {
                flag = false;
            }
            if (map.containsKey('n')) {
                map.put('n', map.get('n') - 1);
                if (map.get('n') == 0) {
                    map.remove('n');
                }
            } else {
                flag = false;
            }
            if (flag) {
                ans++;
            }
        }
        return ans;
    }
}