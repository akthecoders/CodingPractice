// Design a Stack With Increment Operation
public class P1381 {
    int[] stack = null;
    int currentIndex = -1;
    int maxSizeNew = 0;

    public P1381(int maxSize) {
        stack = new int[maxSize];
        maxSizeNew = maxSize;
    }

    public void push(int x) {
        if ((currentIndex < maxSizeNew - 1)) {
            currentIndex++;
            stack[currentIndex] = x;
        }

    }

    public int pop() {
        if (currentIndex >= 0) {
            int result = stack[currentIndex];
            currentIndex--;
            return result;
        }
        return -1;

    }

    public void increment(int k, int val) {

        if (stack != null) {
            for (int i = 0; i < k && i < maxSizeNew; i++) {
                stack[i] = stack[i] + val;
            }
        }

    }
}