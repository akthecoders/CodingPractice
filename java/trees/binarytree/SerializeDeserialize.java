package trees.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * SerializeDeserialize
 */
public class SerializeDeserialize {

 public static String serialize(BinaryNode<Integer> root) {
   if(root == null) {
     return "";
   }
  String result = "";
  result +=  root.data + ":";
  if(root.left != null) {
    result += root.left.data;
  }
  else {
    result += "0";
  } 
  result += "|";
  if(root.right != null) {
    result += root.right.data;
  }
  else {
    result += "0";
  } 
  result += ",";
  result += serialize(root.left);
  result += serialize(root.right);
  return result;
 } 

 public static BinaryNode<Integer> deserialize(String inputString) {
  String[] arrOfString = inputString.split(",");
  Map<Integer, BinaryNode<Integer>> map = new HashMap<Integer,BinaryNode<Integer>>();
  BinaryNode<Integer> mNode = null;
  for(String node : arrOfString) {
    String[] arrNode = node.split(":");
    Integer pNode = Integer.parseInt(arrNode[0]);
    String childNodeArray[] = arrNode[1].split("|");
    Integer leftChild = Integer.parseInt(childNodeArray[0]);
    Integer rightChild = Integer.parseInt(childNodeArray[1]);
   
    if(map.containsKey(pNode)) {
      mNode = map.get(pNode);
    }
    else {
      mNode = new BinaryNode<Integer>(pNode);
    }
    if(leftChild > 0) {
      BinaryNode<Integer> leftChildNode = new BinaryNode<Integer>(leftChild);
      map.put(leftChild, leftChildNode);
      mNode.left = leftChildNode;
    }
    if(rightChild > 0) {
      BinaryNode<Integer> rightChildNode = new BinaryNode<Integer>(rightChild);
      map.put(rightChild, rightChildNode);
      mNode.right = rightChildNode;
    }
  }
  return mNode;
 }
}