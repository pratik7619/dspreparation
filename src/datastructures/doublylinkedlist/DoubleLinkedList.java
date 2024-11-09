package datastructures.doublylinkedlist;

public class DoubleLinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    DoubleLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    Node getHead() {
        return head;
    }

    Node getTail() {
        return tail;
    }

    int getLength() {
        return length;
    }

    void printList() {
        System.out.println("===========================");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        length++;
    }

    void removeLast() {
        if (length == 0) return;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        length--;
    }

    void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    void removeFirst() {
        if (length == 0) return;
        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
    }

    Node get(int index) {
        if (index < 0 || index > length) return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    void removeAt(int index) {
        if (index < 0 || index > length) return;
        if (index == 0) {
            removeFirst();
        } else if (index == length) {
            removeLast();
        } else {
            Node pre = get(index - 1);
            Node temp = pre.next;
            pre.next = temp.next;
            temp.next = null;
        }
        length--;
    }

    boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node before = get(index - 1);
        Node after = before.next;
        newNode.prev = before;
        newNode.next = after;
        after.prev = newNode;
        before.next = newNode;
        length++;
        return true;
    }

    void swapFirstAndLast() {
        if (head == null || head == tail) return;

        Node first = head;
        Node last = tail;

        if (first.next == last) {
            last.next = first;
            last.prev = null;
            first.prev = last;
            first.next = null;
            head = last;
            tail = first;
            return;
        }

        head = last;
        tail = first;

        Node temp = first.next;
        first.next = last.next;
        last.next = temp;

        temp = first.prev;
        first.prev = last.prev;
        last.prev = temp;
    }
}
