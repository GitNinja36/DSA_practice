import java.util.Scanner;

public class treeBT {

    public treeBT() {
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void populate(Scanner scanner) {
        System.out.print("Enter the root node: ");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.print("Do you want to enter the left of " + node.value + "? (true/false): ");
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.print("Enter the value of the left of " + node.value + ": ");
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }

        System.out.print("Do you want to enter the right of " + node.value + "? (true/false): ");
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.print("Enter the value of the right of " + node.value + ": ");
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    public void display() {
    System.out.println("Your Binary Tree:");
    display(root, 0);
}

private void display(Node node, int level) {
    if (node == null) {
        return;
    }
    display(node.right, level + 1);

    System.out.println("    ".repeat(level) + node.value);

    display(node.left, level + 1);
}
}