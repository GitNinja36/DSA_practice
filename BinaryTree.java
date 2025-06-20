import java.util.Scanner;

public class BinaryTree {

    public BinaryTree(){

    }

    private static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }

    private Node root;

    public void populate(Scanner scanner){
        System.out.println("Enter the root Node : ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }
    private void populate(Scanner scanner, Node node){
        System.out.println("left : "+ node.value);
        // boolean left = scanner.nextInt();
        // node.left = new Node(value);
        populate(scanner, node.left);
    }
}
