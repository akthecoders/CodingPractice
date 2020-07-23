import java.util.Stack;

// Add Two Numbers II
public class P445 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> one = new Stack<>();
        Stack<ListNode> two = new Stack<>();
        Stack<ListNode> result = new Stack<>();
        ListNode curr = l1;
        ListNode ans = new ListNode(-1); // serve as a head;
        int sum = 0;
        int carry = 0;
        // push all node from l1 into the stack one
        while (curr != null) {
            one.push(curr);
            curr = curr.next;
        }
        // push all node from l2 into the stack two
        curr = l2;
        while (curr != null) {
            two.push(curr);
            curr = curr.next;
        }
        // adding and push into result stack;
        while (!one.empty() && !two.empty()) {
            sum = one.pop().val + two.pop().val + carry;

            if (sum > 9) {
                sum %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            System.out.println("sum= " + sum + "carry= " + carry);
            result.push(new ListNode(sum));
        }
        while (!one.empty()) {
            System.out.println("one not empty");
            sum = one.pop().val + carry;
            if (sum > 9) {
                sum %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            result.push(new ListNode(sum));
        }
        while (!two.empty()) {
            System.out.println("one not empty");
            sum = two.pop().val + carry;
            if (sum > 9) {
                sum %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            result.push(new ListNode(sum));
        }
        // adding the remaining carry if 1;
        if (carry == 1) {
            result.push(new ListNode(carry));
        }
        // building the result list;
        curr = ans;
        while (!result.empty()) {
            curr.next = result.pop();
            curr = curr.next;
        }

        return ans.next;
    }
}