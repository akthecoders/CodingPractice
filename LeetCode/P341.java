// Flatten Nested List Iterator
import java.util.*;
public class P341 implements Iterator<Integer> {

    public interface NestedInteger {
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
    }

    private Stack<Iterator<NestedInteger>> stack = new Stack<>();
    private NestedInteger curr = null;

    public P341(List<NestedInteger> nestedList) {
        stack.push(nestedList.iterator());
        moveToNext();
    }

    @Override
    public Integer next() {
        NestedInteger pre = curr;
        moveToNext();
        return pre.getInteger();
    }

    @Override
    public boolean hasNext() {
        return curr != null;
    }

    private void moveToNext() {
        while (!stack.isEmpty()) {
            if (stack.peek().hasNext()) {
                NestedInteger item = stack.peek().next();
                if (item.isInteger()) {
                    curr = item;
                    break;
                } else {
                    stack.push(item.getList().iterator());
                }
            } else {
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            curr = null;
        }
    }
}