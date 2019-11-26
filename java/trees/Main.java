package trees;

import java.util.Scanner;

/**
 * Main
 */
public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    TreeNode<Integer> root = InputLevelWise.takeInput(scanner);
    PrintLevelWise.printLevelWise(root);
    int n = scanner.nextInt();
    TreeNode<Integer> nextLargeElement = FindNextLargeElement.findNextLargerNode(root, n);
    if(nextLargeElement == null) {
      System.out.println("Null");
    }
    else {
      System.out.println("Node : " + nextLargeElement.data);
    }
  }  
}