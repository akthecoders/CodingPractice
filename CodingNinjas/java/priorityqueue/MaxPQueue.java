package priorityqueue;

import java.util.ArrayList;

/**
 * MaxPQueue
 */
public class MaxPQueue {
  
  public int size;
  public ArrayList<Integer> queue;

  public MaxPQueue() {
    this.queue = new ArrayList<Integer>();
    this.size = 0;
  }

  public Integer getMax() {
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
      if(parentData < childData) {
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
    int maxIndex = 0;
    int leftChild = (parentIndex * 2) + 1;
    int rightChild = (parentIndex * 2) + 2;
    
    while(maxIndex < size) {
      leftChild = (parentIndex * 2) + 1;
      rightChild = (parentIndex * 2) + 2;
      if(leftChild < size && queue.get(leftChild) > queue.get(parentIndex)) {
        maxIndex = leftChild;
      }
      if(rightChild < size && queue.get(rightChild) > queue.get(maxIndex)) {
        maxIndex = rightChild;
      }
      
      if(maxIndex == parentIndex) {
        break;
      }
      Integer temp = queue.get(parentIndex);
      queue.set(parentIndex, queue.get(maxIndex));
      queue.set(maxIndex, temp);
      parentIndex = maxIndex;
      maxIndex = parentIndex;
    }
  }

  public void printQueue() {
    for (Integer integer : this.queue) {
      System.out.print(integer + ", ");
    }
  }
}