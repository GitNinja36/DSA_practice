import java.util.*;

public class dequePR {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.addLast(2);
        deque.removeFirst();
        System.out.println(deque);
    }
}
