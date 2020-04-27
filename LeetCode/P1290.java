// Convert Binary Number in a Linked List to Integer
public class P1290 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    int multiplicativeFactor = 0;

    public int getDecimalValue(ListNode head) {
        if (head.next == null) {
            int res = (head.val * (int) Math.pow(2, multiplicativeFactor));
            multiplicativeFactor++;
            return res;
        }
        int add = getDecimalValue(head.next);
        int res = (head.val * (int) Math.pow(2, multiplicativeFactor)) + add;
        multiplicativeFactor++;
        return res;
    }
}