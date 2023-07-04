package datastructures.linkedlist;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int length;

    public LinkedList(T value) {
        Node<T> newNode = new Node<>(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<T> curr = head;
        while (curr != null) {
            builder.append(curr.value + " -> ");
            curr = curr.next;
        }
        return builder.toString();
    }

    class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }
}