// Next Greater Node In Linked List
import java.util.*;
public class P1019 {
    class SNode {
        int val;
        int index;

        SNode(int v, int i) {
            this.val = v;
            this.index = i;
        }
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public int[] nextLargerNodes(ListNode head) {
        Stack<SNode> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int size = 0;
        ListNode myNode = head;
        while (head != null) {

            while (!st.isEmpty() && st.peek().val < head.val) {
                map.put(st.pop().index, head.val);
            }
            st.push(new SNode(head.val, size));
            head = head.next;
            size++;
        }

        int res[] = new int[size];
        int index = 0;
        while (myNode != null) {
            if (map.containsKey(index)) {
                res[index] = map.get(index);
            }
            index++;
            myNode = myNode.next;
        }
        return res;
    }
}