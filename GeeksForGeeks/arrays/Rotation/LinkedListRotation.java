package Rotation;
public class LinkedListRotation {

    static class ListNode {
        int data;
        ListNode next;
    }

    static void rotateSubList(ListNode A, int m, int n, int k) {
        int size = n - m + 1;

        if (k > size) {
            k = k % size;
        }

        if (k == 0 || k == size) {
            ListNode head = A;
            while (head != null) {
                System.out.print(head.data);
                head = head.next;
            }
            return;
        }

        ListNode link = null; // m-th node
        if (m == 1) {
            link = A;
        }

        ListNode c = A; // Current traversed node
        int count = 0; // Count of traversed nodes
        ListNode end = null;
        ListNode pre = null; // Previous of m-th node
        while (c != null) {
            count++;

            if (count == m - 1) {
                pre = c;
                link = c.next;
            }
            if (count == n - k) {
                if (m == 1) {
                    end = c;
                    A = c.next;
                } else {
                    end = c;

                    pre.next = c.next;
                }
            }

            if (count == n) {
                ListNode d = c.next;
                c.next = link;
                end.next = d;
                ListNode head = A;
                while (head != null) {
                    System.out.print(head.data + " ");
                    head = head.next;
                }
                return;
            }
            c = c.next;
        }
    }

    static ListNode push(ListNode head, int val) {
        ListNode new_node = new ListNode();
        new_node.data = val;
        new_node.next = (head);
        (head) = new_node;
        return head;
    }

    public static void main(String args[]) {
        ListNode head = null;
        head = push(head, 70);
        head = push(head, 60);
        head = push(head, 50);
        head = push(head, 40);
        head = push(head, 30);
        head = push(head, 20);
        head = push(head, 10);
        ListNode tmp = head;
        System.out.print("Given List: ");
        while (tmp != null) {
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();

        int m = 3, n = 6, k = 2;
        System.out.print("After rotation of sublist: ");
        rotateSubList(head, m, n, k);

    }
}