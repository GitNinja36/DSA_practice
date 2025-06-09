public class main2 {
    public static void main(String[] args) {
        DLL list = new DLL();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(8);
        list.insertFirst(17);
        list.insertLast(99);
        list.insert(8, 7);
        // list.insert(100, 3);
        // list.display();
        // list.deleteFirst();
        // list.display();
        // System.out.println(list.deleteLast());
        list.display();
        // System.err.println(list.delete(2));
        // list.display();
        // System.out.println(list.find(3));
    }
}
