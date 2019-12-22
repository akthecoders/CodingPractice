import java.util.Scanner;

class LinkedListNode<T> {
	public T data;
	public LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.setData(data);
		this.next = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}

class MidPoint {
  private static Scanner s = new Scanner(System.in);
  public static void main(String args[]) {
    LinkedListNode<Integer> input = input();
    LinkedListNode<Integer> ptr2 = input;
    LinkedListNode<Integer> ptr = input;
    int midPoint = -1;
    while(ptr != null || ptr2 != null ) {
      if(ptr2.next == null) {
        midPoint = ptr.getData();
        break;
      }
      else {
        ptr2 = ptr2.next.next;
        if(ptr2 == null || ptr2.getData() == -1) {
          midPoint = ptr.getData();
          break;
        }
        ptr = ptr.next;
        
      }
    }
    System.out.println(midPoint);

  }
  public static LinkedListNode<Integer> input() {
		int data = s.nextInt();
		
		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> tail = null;
		while (data!=-1) {
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = newNode;
			}
			data = s.nextInt();
		}
		return head;
	}
}