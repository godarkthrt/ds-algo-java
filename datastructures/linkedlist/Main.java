package datastructures.linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>(10);

        ll.getHead();
        ll.getTail();
        ll.getLength();
        ll.printList();

        // --------------
        System.out.println("==============================");
        ll.append(20);
        ll.getHead();
        ll.getTail();
        ll.getLength();
        ll.printList();

    }
}
