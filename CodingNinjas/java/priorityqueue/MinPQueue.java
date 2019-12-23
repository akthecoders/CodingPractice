package priorityqueue;

import java.util.ArrayList;

/**
 * MinPQueue
 */
public class MinPQueue {
  
  public int size;
  public ArrayList<Integer> queue;

  public MinPQueue() {
    this.queue = new ArrayList<Integer>();
    this.size = 0;
  }

  public Integer getMin() {
    if(size > 0) {
      return this.queue.get(0);
    }
    return 0;
  }

  public void insertData(Integer element) {
    int childIndex = 0;
    int parentIndex = 0;
    if(size > 0) {
      childIndex = size;
      parentIndex = (size - 1)/2;
    }
    queue.add(element);
    size++;
    while(childIndex > 0) {
      Integer childData = queue.get(childIndex);
      Integer parentData = queue.get(parentIndex);
      if(parentData > childData) {
        Integer temp = queue.get(childIndex);
        queue.set(childIndex, parentData);
        queue.set(parentIndex, temp);
        childIndex = parentIndex;
        parentIndex = ((parentIndex - 1) / 2);
      }
      else {
        break;
      }
    }
  }

  public void removeElement() {
    if(size <= 0) {
      return;
    }

    queue.set(0, queue.get(queue.size() - 1));
    queue.remove(queue.size() - 1);
    size--;

    int parentIndex = 0;
    int minIndex = 0;
    int leftChild = (parentIndex * 2) + 1;
    int rightChild = (parentIndex * 2) + 2;
    
    while(minIndex < size) {
      leftChild = (parentIndex * 2) + 1;
      rightChild = (parentIndex * 2) + 2;
      if(leftChild < size && queue.get(leftChild) < queue.get(parentIndex)) {
        minIndex = leftChild;
      }
      if(rightChild < size && queue.get(rightChild) < queue.get(minIndex)) {
        minIndex = rightChild;
      }
      
      if(minIndex == parentIndex) {
        break;
      }
      Integer temp = queue.get(parentIndex);
      queue.set(parentIndex, queue.get(minIndex));
      queue.set(minIndex, temp);
      parentIndex = minIndex;
      minIndex = parentIndex;
    }
  }

  public void printQueue() {
    for (Integer integer : this.queue) {
      System.out.print(integer + ", ");
    }
  }
}