
public class TwoWaterJugProblem {
    public static void main(String[] args) {
        int n = 5, m = 3;
        int d = 4;
        System.out.println(minSteps(n, m, d));
    }

    public static int minSteps(int m, int n, int d) {
        if(m > n) {
            int temp = n;
            n = m;
            m = temp;
        }

        if(d > n) {
            return -1;
        }

        if(d%gcd(n,m) != 0) {
            return -1;
        }

        return Math.min(pour(m, n , d), pour(n, m , d));
    }

    public static int pour(int sourceCap, int destCap, int d) {
        int from = sourceCap;
        int to = 0;
        int steps = 1;
        while(from != d || to != d) {
            int minPour = Math.min(from , destCap - to);
            from -= minPour;
            to += minPour;
            steps++;
            if(from == d || to == d) {
                break;
            }
            if(from  == 0) {
                from = sourceCap;
                steps++;
            }
            if(to == destCap) {
                to = 0;
                steps++;
            }
        }
        return steps;
    }

    public static int gcd(int a, int b) {
        if(a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }
}