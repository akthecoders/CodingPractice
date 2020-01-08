package OrderStatistics;

import java.util.ArrayList;

/**
 * MaxPriorityQueue
 */
public class MaxPriorityQueue {

    int size;
    ArrayList<Integer> queue;

    public MaxPriorityQueue() {
        this.size = 0;
        this.queue = new ArrayList<>();
    }

    public Integer getMax() {
        if(size > 0) {
            return this.queue.get(0);
        }
        return 0;
    }

    public void insertElement(Integer element) {
        int parentIndex = 0;
        int childIndex = 0;
        if(size > 0) {
            childIndex = size;
            parentIndex = (size - 1)/2;
        }
        this.queue.add(element);
        size++;
        while(childIndex > 0) {
            Integer parentData = this.queue.get(parentIndex);
            Integer childData = this.queue.get(childIndex);
            if(parentData < childData) {
                this.queue.set(childIndex, parentData);
                this.queue.set(parentIndex, childData);
                childIndex = parentIndex;
                parentIndex = (childIndex - 1)/2;
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
        this.queue.set(0, this.queue.get(this.queue.size() - 1));
        queue.remove(this.queue.size() - 1);
        size--;
        int parentIndex = 0;
        int maxIndex = 0;
        int leftChild = (parentIndex * 2 + 1);
        int rightChild = (parentIndex * 2) + 2;

        if(leftChild < size && this.queue.get(leftChild) > this.queue.get(parentIndex)) {
            maxIndex = leftChild;
        }
        if(rightChild < size && this.queue.get(rightChild) > this.queue.get(maxIndex)) {
            maxIndex = rightChild;
        }

        Integer temp = queue.get(parentIndex);
        queue.set(parentIndex, queue.get(maxIndex));
        queue.set(maxIndex, temp);
        parentIndex = maxIndex;
        maxIndex = parentIndex;
    }

    public void printQueue() {
        for (Integer integer : this.queue) {
            System.out.print(integer + ", ");
        }
    }

}