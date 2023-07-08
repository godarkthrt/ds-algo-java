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

        public V getValue() {
            return value;
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

    public Optional<T> get(int index) {
        Optional<Node<T>> node = getNode(index);
        return node.isPresent() ? Optional.of(node.get().value) : Optional.empty();
    }

    private Optional<Node<T>> getNode(int index) {
        if (index < 0 || index >= this.length) {
            // either throw an exception or use optional rather than throwing error
            return Optional.empty();
        }
        Node<T> curr = head;
        for (int j = 0; j < index; j++) {
            curr = curr.next;
        }
        return Optional.of(curr);
    }

    public boolean set(int index, T value) {
        Optional<Node<T>> targetNode = getNode(index);
        Node<T> curr = targetNode.isPresent() ? targetNode.get() : null;
        if (curr == null) {
            return false;
        }
        curr.value = value;
        return true;
    }

    public boolean insert(int index, T value) {
        if (index < 0 || index > length) {
            return false;
        }
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node<T> newNode = new Node<T>(value);
        Node<T> pre = getNode(index - 1).get();
        newNode.next = pre.next;
        pre.next = newNode;
        this.length++;
        return true;
    }

    public Optional<T> remove(int index) {
        // takes care of empty list scenario as well
        if (index < 0 || index >= length) {
            return Optional.empty();
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == length - 1) {
            return removeLast();
        }
        Node<T> pre = getNode(index - 1).get();
        Node<T> temp = pre.next;
        pre.next = temp.next;
        temp.next = null;
        this.length--;
        return Optional.of(temp.value);
    }

    public void reverse() {
        if (this.length <= 1) {
            return;
        }
        Node<T> curr = head;
        head = tail;
        tail = curr;

        // 3 pointer will be required, pre,curr,next
        // pre-> null, curr -> head , post -> curr.next
        Node<T> pre = null;
        Node<T> post = head.next;
        while (curr != null) {
            post = curr.next;
            curr.next = pre;
            pre = curr;
            curr = post;
        }
    }

    // for even number of nodes find 2nd of the 2 middle nodes
    public Node<T> findMiddleNode() {
        Node<T> slow = head;
        Node<T> fast = head;
        // point fast and slow moving pointers to head
        // until fast is not null and fast.next is not null
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node<T> findMiddleNode_firstMiddleNodeForEvenNumberOfNodes() {
        Node<T> slow = head;
        Node<T> fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}