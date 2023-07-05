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

        System.out.println("==================GET==================================");
        ll.append(30);
        ll.printList();
        System.out.println(ll.get(2));

        System.out.println("===================SET=================================");
        ll.append(40);
        System.out.println(ll.set(2, 35));
        ll.printList();

        System.out.println("====================INSERT================================");
        System.out.println(ll.insert(2, 32));
        ll.printList();

        System.out.println("====================REMOVE================================");
        System.out.println(ll.remove(2));
        ll.printList();

        System.out.println("====================REVERSE================================");
        ll.reverse();
        ll.printList();
    }
}
