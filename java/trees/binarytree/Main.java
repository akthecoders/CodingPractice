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
        System.out.println("No of nodes : " + CountNoOfNodes.countNoOfNodes(root));
    }
}