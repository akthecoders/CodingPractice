package trees.binarytree;

/**
 * SerializeDeserialize
 */
public class SerializeDeserialize {

 public static String serialize(BinaryNode<Integer> root) {
  String result = "";
  result +=  root.data + "[" + root.left.data + "|" + root.right.data + "],";
  result += serialize(root.left);
  result += serialize(root.right);
  return result;
 } 

 public static void deserialize(BinaryNode<Integer> root) {
   
 }
}