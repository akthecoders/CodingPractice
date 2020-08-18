// Design a Stack With Increment Operation

class P1381 {
    int[] stack;
    int cap;
    int curr;
    int index;
    public P1381(int maxSize) {
        stack = new int[1001];
        cap = maxSize;
        curr = 0;
        index = 0;
    }
    
    public void push(int x) {
        if(curr < cap) {
            stack[index++] = x;
            curr++;
        }
    }
    
    public int pop() {
        if(curr > 0) {
            curr--;
            return stack[--index];
        }
        return -1;
    }
    
    public void increment(int k, int val) {
        for(int i = 0; i < Math.min(k, index); i++) {
            stack[i] += val;
        }
    }
}