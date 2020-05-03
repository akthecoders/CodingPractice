// Intersection of two Linked List
public class P160 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tA=headA;
        ListNode tB=headB;
        int sizeA=0; int sizeB=0;
        while(tA!=null)
        {
            sizeA++; tA=tA.next;
        }
        while(tB!=null)
        {
            sizeB++; tB=tB.next;
        }
        tA=headA; tB=headB;
        if(sizeB>sizeA)
        {
            while((sizeB-sizeA)>0)
            {
                tB=tB.next;
                sizeB--;
            }
        }
        else
        {
            while((sizeA-sizeB)>0)
            {
                tA=tA.next;
                sizeA--;
            }
        }
        while(tA!=null && tB!=null)
        {
            if(tA==tB) return tA;
            tA=tA.next;
            tB=tB.next;
        }
        return null;
    }    
}