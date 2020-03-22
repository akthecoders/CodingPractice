
/**
 * SortingQueue
 */
import java.util.Queue;
import java.util.LinkedList;

public class SortingQueue {

  public static void main(String[] args) {
    Queue<Integer> list = new LinkedList<Integer>();
    list.add(30);
    list.add(11);
    list.add(15);
    list.add(4);

    sortQueue(list);

    while (list.isEmpty() == false) {
      System.out.print(list.peek() + " ");
      list.poll();
    }
  }

  public static void sortQueue(Queue<Integer> list) {
    int s = list.size();
    for(int i = 1; i <= s; i++) {
      int minIndex = getMinIndex(list,list.size() - i);
      insertMinToEnd(list, minIndex);
    }
  }

  public static int getMinIndex(Queue<Integer> list, int sIndex) {
    int minValue = Integer.MAX_VALUE, currMin = -1, minIndex = -1;
    int s = list.size();
    for(int i = 0; i < s; i++) {
      currMin = list.peek();
      list.poll();
      if(currMin <= minValue && i <= sIndex ) {
        minValue = currMin;
        minIndex = i;
      }
      list.add(currMin);
    }
     return minIndex;
  }

  public static void insertMinToEnd(Queue<Integer> list, int minIndex) {
    int minVal = -1;
    int currVal = -1;
    int s = list.size();
    for(int i = 0; i < s; i++) {
      currVal = list.peek();
      list.poll();
      if(i == minIndex) {
        minVal = currVal;
      }
      else {
        list.add(currVal);
      }
    }
    list.add(minVal);
  }

}