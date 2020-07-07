// Print 1 to ns
public class Print1ton {
    public void print(int n) {
        if(n == 0) {
            return;
        }
        System.out.println(n);
        print(n-1);
    }
}