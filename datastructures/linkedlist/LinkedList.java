package datastructures.linkedlist;

import java.util.Optional;

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

    public Optional<T> removeLast() {
        // if ll is empty, return null or throw an exception
        // if ll has 1 item
        // else
        Node<T> temp = head;
        Node<T> removeNode;
        if (this.length == 0) {
            // there is nothing to remove , fail safe instead of throwing an exception
            return Optional.empty();
        } else if (this.length == 1) {
            removeNode = head;
            head = null;
            tail = null;
            this.length = 0;
        } else {
            while (temp.next != tail) {
                temp = temp.next;
            }
            removeNode = tail;
            tail = temp;
            tail.next = null;
            this.length--;
        }
        return Optional.of(removeNode.value);
    }
}