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
        Node<T> pre, temp;
        pre = head;
        temp = head;
        if (this.length == 0) {
            // there is nothing to remove , fail safe instead of throwing an exception
            return Optional.empty();
        } else if (this.length == 1) {
            head = null;
            tail = null;
            this.length = 0;
        } else {
            while (temp.next != null) {
                pre = temp;
                temp = temp.next;
            }
            tail = pre;
            tail.next = null;
            this.length--;
        }
        return Optional.of(temp.value);
    }

    public void prepend(T value) {
        Node<T> newNode = new Node<T>(value);
        newNode.next = head;
        this.head = newNode;

        if (this.length == 0) {
            this.tail = newNode;
        }

        this.length++;
    }

    public Optional<T> removeFirst() {
        if (length == 0) {
            return Optional.empty();
        }

        Node<T> tmp = head;
        head = head.next;
        tmp.next = null;
        this.length--;
        if (this.length == 0) {
            tail = null;
        }
        return Optional.of(tmp.value);

    }
}