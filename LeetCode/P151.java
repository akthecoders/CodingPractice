//Reverse Words in a String
public class P151 {
    public String reverseWords(String a) {
        String b = " ";
        String c[] = a.split("[ ]+");
        for (int i = c.length - 1; i >= 0; i--) {
            b = b + c[i] + " ";
        }
        return b.trim();
    }
}