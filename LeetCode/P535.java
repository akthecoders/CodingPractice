import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//Encode and Decode TinyURL
public class P535 {
    String string = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    String key;
    Map<String, String> map = new HashMap<>();

    Random rand = new Random();

    private String getKey() {

        StringBuilder s = new StringBuilder();
        for (int ind = 0; ind < 6; ind++) {
            s.append(string.charAt(rand.nextInt(62)));
        }

        return s.toString();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {

        key = getKey();
        while (map.containsKey(key)) {
            key = getKey();
        }
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {

        int ind = shortUrl.length() - 1;

        while (ind >= 0) {
            if (shortUrl.charAt(ind) == '/')
                break;
            ind--;
        }

        return map.get(shortUrl.substring(ind + 1, shortUrl.length()));
    }
}