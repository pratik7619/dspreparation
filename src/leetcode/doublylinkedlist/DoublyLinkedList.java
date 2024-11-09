package leetcode.doublylinkedlist;

public class DoublyLinkedList {

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

    DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    void printList() {
        System.out.println("==========================");
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

    void swapFirstAndLast() {
        if (head == null || head == tail) return;

        int temp = head.value;
        head.value = tail.value;
        tail.value = temp;
    }

    void reverse() {
       Node current = head;
       Node temp = null;

       while (current != null) {
           temp = current.prev;
           current.prev = current.next;
           current.next = temp;
           current = current.prev;
       }

       if (temp != null) head = temp.prev;
    }

    boolean isPalindrome() {
        if (head == null) return true;

        Node start = head;
        Node end = tail;

        while (start != end && start.prev != end) {
            if (start.value != end.value) return false;
            start = start.next;
            end = end.prev;
        }

        return true;
    }
}
