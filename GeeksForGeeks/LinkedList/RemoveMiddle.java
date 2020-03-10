public class RemoveMiddle 
{ 
	Node head; 

	class Node 
	{ 
		int x,y; 
		Node next; 
		Node(int x, int y) 
		{ 
			this.x = x; 
			this.y = y; 
			next = null; 
		} 
	} 

	public Node deleteMiddle() {
    if(head == null || head.next == null || head.next.next == null ) {
      return head;
    }

    Node next = head.next;
    Node nextnext = next.next;

    if(head.x == next.x) {
      while(nextnext != null && next.x == nextnext.x) {
        head.next = next.next;
        next.next = null;

        next = nextnext;
        nextnext = next.next;
      }
    }
    else if(head.y == next.y) {
      while(nextnext != null && next.y == nextnext.y) {
        head.next = next.next;
        next.next = null;
        next = nextnext;
        nextnext = next.next;
      }
    }
    else
    { 
        System.out.println("Given list is not valid"); 
        return null; 
    } 

    Node temp = head;
    head = head.next;
    this.deleteMiddle();
    head = temp;
    return head;
  } 

	/* Given a reference (pointer to pointer) to the head 
		of a list and an int, push a new node on the front 
		of the list. */
	void push(int x, int y) 
	{ 
		/* 1 & 2: Allocate the Node & 
				Put in the data*/
		Node new_node = new Node(x,y); 

		/* 3. Make next of new Node as head */
		new_node.next = head; 

		/* 4. Move the head to point to new Node */
		head = new_node; 
	} 


	void printList() 
	{ 
		Node temp = head; 
		while (temp != null) 
		{ 
			System.out.print("("+temp.x+","+temp.y+")->"); 
			temp = temp.next; 
		} 
		System.out.println(); 
	} 


	/* Driver program to test above functions */
	public static void main(String args[]) 
	{ 
		RemoveMiddle llist = new RemoveMiddle(); 

		llist.push(40,5); 
		llist.push(20,5); 
		llist.push(10,5); 
		llist.push(10,8); 
		llist.push(10,10); 
		llist.push(3,10); 
		llist.push(1,10); 
		llist.push(0,10); 

		System.out.println("Given list"); 
		llist.printList(); 

		if (llist.deleteMiddle() != null) 
		{ 
			System.out.println("Modified Linked List is"); 
			llist.printList(); 
		} 
	} 
}
