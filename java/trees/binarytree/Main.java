package trees.binarytree;

import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BinaryNode<Integer> root = InputLevelWise.inputLevelWise(scan);
        PrintLevelWise.printLevelWise(root);
        // PrintLevelWise.printLevelWise(root);
        // System.out.println("No of nodes : " + CountNoOfNodes.countNoOfNodes(root));
        // System.out.println("Diameter of tree : " + DiameterBTree.getDiameter(root));
        // PrintLevelWise.printLevelWise(root);
        // System.out.println("No of nodes : " + CountNoOfNodes.countNoOfNodes(root));
        // String str = SerializeDeserialize.serialize(root);
        // System.out.println("String : " + str);
        // BinaryNode<Integer> tree = SerializeDeserialize.deserialize(str);
        // if(tree == null) {
        //   System.out.println("Null Tree");
        // }
        // else {
        //   PrintLevelWise.printLevelWise(tree);
        // }
        // int[] preOrder = new int[]{1,2,3,4,15,5,6,7,8,10,9,12};
        // int[] inOrder  = new int[]{4,15,3,2,5,1,6,10,8,7,9,12};
        // BinaryNode<Integer> root = TreeFromIP.generateTree(inOrder, preOrder);
        // PrintLevelWise.printLevelWise(root);
        // String serializedString = SerializeDeserialize.serialize(root);
        // System.out.println("SerializedString : " + serializedString);
        // BinaryNode<Integer> reconstructedTree = SerializeDeserialize.deserialize(serializedString);
        // PrintLevelWise.printLevelWise(reconstructedTree);
    }
}