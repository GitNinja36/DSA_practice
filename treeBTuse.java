import java.util.Scanner;

public class treeBTuse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        treeBT tree = new treeBT(); 
        tree.populate(scanner);
        tree.display();
    }
}