/**
 * NextGreaterElement
 */
public class NextGreaterElement {

  public static void main(String[] args) {
    int arr[] = { 11, 13, 21, 3};
    int n = arr.length;
    printNGE(arr, n);
  }

  public static void printNGE(int[] arr, int n) {
    Stack stack = new Stack();
    stack.push(arr[0]);
    int node, element;
    for(int i = 1; i < n;i ++) {
      node = arr[i];
      if(stack.isEmpty() == false) {
        element = stack.pop();
        while(element < node) {
          System.out.println(element + "--->" + node);
          if(stack.isEmpty()) {
            break;
          }
          element = stack.pop();
        }
        if(element > node) {
          stack.push(element);
        }
      }
      stack.push(node);
    }
    while(!stack.isEmpty()) {
      element = stack.pop();
      node = -1;
      System.out.println(element + "--->" + node);
    }
  }
}