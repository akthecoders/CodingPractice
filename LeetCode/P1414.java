//Find the Minimum Number of Fibonacci Numbers Whose Sum Is K
import java.util.ArrayList;

public class P1414 {
    public int findMinFibonacciNumbers(int k) {
        ArrayList<Integer> fiboterms = new ArrayList<Integer>();
        calcFiboTerms(fiboterms, k);
        int count = 0, j = fiboterms.size() - 1;
        while (k > 0) {
            count += (k / fiboterms.get(j));
            k = k % fiboterms.get(j);
            j--;
        }
        return count;
    }

    public static void calcFiboTerms(ArrayList<Integer> fiboterms, int k) {
        int i = 3, nextTerm = 0;
        fiboterms.add(0);
        fiboterms.add(1);
        fiboterms.add(1);
        while (true) {
            nextTerm = fiboterms.get(i - 1) + fiboterms.get(i - 2);
            if (nextTerm > k)
                return;
            fiboterms.add(nextTerm);
            i++;
        }
    }
}