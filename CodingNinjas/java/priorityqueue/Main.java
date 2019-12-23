package priorityqueue;

/**
 * Main
 */
public class Main {

  public static void main(String args[]) {
    MinPQueue minQueue = new MinPQueue();
    minQueue.insertData(6);
    minQueue.insertData(5);
    minQueue.insertData(8);
    minQueue.insertData(50);
    minQueue.insertData(20);
    minQueue.insertData(9);
    minQueue.insertData(1);
    System.out.println();
    minQueue.printQueue();

    minQueue.removeElement();
    System.out.println();
    minQueue.printQueue();
    minQueue.removeElement();
    System.out.println();
    minQueue.printQueue();
  }
}
