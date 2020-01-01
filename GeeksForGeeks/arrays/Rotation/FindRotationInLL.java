package Rotation;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * FindRotationInLL
 */
public class FindRotationInLL {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(12);
        ll.add(11);
        ll.add(8);
        ll.add(5);
        ll.add(18);
        ll.add(15);

        printList(ll);
        countRotation(ll);
    }

    public static void countRotation(LinkedList<Integer> ll) {
        int count  = 0;
        for(int i = 0; i < ll.size() - 1; i++) {
            if(ll.get(i) < ll.get(i + 1)) {
                count = i + 1;
                break;
            }
        }
        System.out.println("Rotations" + (ll.size() - count));
    }

    public static void printList(LinkedList<Integer> ll) {
        Iterator<Integer> iterator = ll.iterator();
        while(iterator.hasNext()){
        System.out.println(iterator.next());
        }
    }
}