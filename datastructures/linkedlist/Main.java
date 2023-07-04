package datastructures.linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>(10);

        ll.getHead();
        ll.getTail();
        ll.getLength();
        ll.printList();

        // --------------
        System.out.println("====================================================");
        ll.append(20);
        ll.getHead();
        ll.getTail();
        ll.getLength();
        ll.printList();

        System.out.println("====================================================");
        ll.append(30);
        ll.printList();
        ll.removeLast().ifPresent(i -> System.out.println("removed item : " + i));
        ll.printList();

        System.out.println("====================================================");
        ll.prepend(2);
        ll.printList();

        System.out.println("====================================================");
        System.out.println(ll.removeFirst());
        ll.printList();

        System.out.println("====================================================");
        ll.append(30);
        ll.printList();
        System.out.println(ll.get(2));
    }
}
