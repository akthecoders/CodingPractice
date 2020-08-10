//Fibonacci Number
public class P509 {
    public int fib(int N) {
        int first = 0;
        int second = 1;

        if (N == 0)
            return first;
        if (N == 1)
            return second;

        return fib(N - 2, first, second);
    }

    public int fib(int N, int first, int second) {
        if (N == 0) {
            return first + second;
        }

        return fib(N - 1, second, first + second);
    }
}