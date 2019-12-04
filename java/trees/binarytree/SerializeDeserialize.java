package trees.binarytree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * SerializeDeserialize
 */
public class SerializeDeserialize {
  private static String inOrderString = "";
  private static String preOrderString = "";
  private static int preIndex = 0;

  public static String serialize(BinaryNode<Integer> root) {
    inOrderString = "";
    preOrderString = "";
    inOrder(root);
    preOrder(root);
    String serializedString = inOrderString + ":" + preOrderString;
    return serializedString;
  }

  private static void inOrder(BinaryNode<Integer> root) {
    if (root == null) {
      return;
    }
    inOrder(root.left);
    inOrderString += root.data + " ";
    inOrder(root.right);
  }

  private static void preOrder(BinaryNode<Integer> root) {
    if(root == null) {return;}
    preOrderString += root.data + " ";
    preOrder(root.left);
    preOrder(root.right);
}

  public static BinaryNode<Integer> deserialize(String inputString) {
    System.out.println(inputString);
    String[] arrOfString = inputString.split(":");
    String inOrderString = arrOfString[1];
    String preOrderString = arrOfString[1];
    int[] inOrder = convertStringToInt(inOrderString.split(" "));
    int[] preOrder = convertStringToInt(preOrderString.split(" "));
    preIndex = 0;
    // return null;
    return buildTree(inOrder, preOrder, 0, inOrder.length - 1);
  }

  private static int[] convertStringToInt(String[] input) {
    int [] arr = new int [input.length];
      for(int i=0; i < input.length; i++) {
         arr[i] = Integer.parseInt(input[i]);
      }
    return arr;
  }

  private static BinaryNode<Integer> buildTree(int[] inOrder, int[] preOrder, int inStart, int inEnd) {
    if(inStart > inEnd) {
        return null;
    }
    BinaryNode<Integer> tNode = new BinaryNode<>(preOrder[preIndex++]);
    if(inStart == inEnd) {
        return tNode;
    }
    int rootIndex = searchIndex(inOrder, inStart, inEnd, tNode.data);
    tNode.left = buildTree(inOrder, preOrder, inStart, rootIndex - 1);
    tNode.right = buildTree(inOrder, preOrder, rootIndex + 1, inEnd);
    return tNode;
}

private static int searchIndex(int arr[], int strt, int end, int value) {
    int i;
    for(i = strt; i <= end; i++) {
        if(arr[i] == value) {
            return i;
        }
    }
    return i;
}
}