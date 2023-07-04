package datastructures.linkedlist;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int length;

    class Node<V> {
        V value;
        Node<V> next;

        Node(V value) {
            this.value = value;
        }
    }

    public LinkedList(T value) {
        Node<T> newNode = new Node<>(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public void printList() {
        Node<T> curr = head;
        StringBuilder builder = new StringBuilder();
        while (curr != null) {
            builder.append(curr.value);
            builder.append(" -> ");
            curr = curr.next;
        }
        builder.append(" null");
        System.out.println(builder.toString());
    }

    public void getHead() {
        System.out.println("Head : " + head.value);
    }

    public void getTail() {
        System.out.println("Tail : " + tail.value);
    }

    public void getLength() {
        System.out.println("Length : " + length);
    }

    public void append(T value) {
        Node<T> newNode = new Node<>(value);
        // if ll is empty
        if (length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        this.length++;
    }
}