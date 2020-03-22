/**
 * Queue
 */
public class Q {

  int capacity;
  int[] q;
  int rear;
  int front;
  int size;

  public Q(int capacity) {
    this.capacity = capacity;
    this.q = new int[this.capacity];
    this.rear = this.capacity - 1;
    this.front = 0;
    this.size = 0;
  }

  boolean isFull() {
    return this.size == this.capacity;
  }

  boolean isEmpty() {
    return this.size == 0;
  }

  void print() {
    for (int i : q) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  void enqueue( int item) {
    if (isFull()) 
    return; 
    this.rear = (this.rear+1)%this.capacity;
    this.q[this.rear] = item;
    this.size++;
  }

  int dequeue() {
    if (isEmpty()) 
    return Integer.MIN_VALUE;
    
    int item = this.q[this.front];
    this.front = (this.front + 1)%this.capacity;
    this.size--;
    return item;
  }

  int front() {
    if(isEmpty()) {
      return Integer.MIN_VALUE;
    }
    return q[this.front];
  }

  int rear() {
    if(isEmpty()) {
      return Integer.MIN_VALUE;
    }
    return q[this.rear];
  }
}