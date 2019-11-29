package trees;

/**
 * BinaryNode
 */
public class BinaryNode<T> {
  T data;
  BinaryNode<T> left , right;
  public BinaryNode(T data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}