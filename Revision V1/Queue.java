import java.util.Iterator;
import java.util.LinkedList;

public class Queue <T> implements Iterable <T> {

    LinkedList <T> list = new LinkedList<T>();
    
    public Queue() {}
    public Queue(T data) {
        offer(data);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return size() == 0 ? true : false;
    }

    public void offer(T data) {
        list.addLast(data);
    }

    public T poll() {
        if(isEmpty()) throw new RuntimeException("Queue Empty");
        return list.removeFirst();
    }

    public T peek() {
        if(isEmpty()) throw new RuntimeException("Queue Empty");
        return list.peekFirst();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
    
}
