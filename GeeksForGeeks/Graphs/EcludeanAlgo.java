
public class EcludeanAlgo {
    public static void main(String[] args) {
        int a = 10, b = 25;
        System.out.println("GCD  " + gcd(a, b) );
    }

    public static int gcd(int a, int b) {
        if(a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }
}