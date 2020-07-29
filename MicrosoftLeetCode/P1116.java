import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

// Print Zero Even Odd
public class P1116 {
    private int n;

    private Semaphore zero;
    private Semaphore odd;
    private Semaphore even;

    public P1116(int n) {
        this.n = n;
        this.zero = new Semaphore(1);
        this.odd = new Semaphore(0);
        this.even = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        for (int i = 1; i <= n; i++) {
            zero.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                even.release();
            } else {
                odd.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }
}