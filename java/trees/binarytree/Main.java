package trees.binarytree;

import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BinaryNode<Integer> root = InputLevelWise.inputLevelWise(scan);
<<<<<<< HEAD
        PrintLevelWise.printLevelWise(root);
        // System.out.println("No of nodes : " + CountNoOfNodes.countNoOfNodes(root));
        System.out.println("Diameter of tree : " + DiameterBTree.getDiameter(root));
=======
        // PrintLevelWise.printLevelWise(root);
        // System.out.println("No of nodes : " + CountNoOfNodes.countNoOfNodes(root));
        String str = SerializeDeserialize.serialize(root);
        System.out.println("String : " + str);
        BinaryNode<Integer> tree = SerializeDeserialize.deserialize(str);
        if(tree == null) {
          System.out.println("Null Tree");
        }
        else {
          PrintLevelWise.printLevelWise(tree);
        }
>>>>>>> f1005a9... SerializeDeserialize
    }
}