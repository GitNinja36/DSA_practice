public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(8);
        list.insertFirst(17);
        list.insertLast(99);
        list.insert(100, 3);
        list.display();
        list.deleteFirst();
        list.display();
        System.out.println(list.deleteLast());
        list.display();
        System.err.println(list.delete(2));
        list.display();
        System.out.println(list.find(3));
        list.insertRec(88, 2);
        list.display();
    }
}
