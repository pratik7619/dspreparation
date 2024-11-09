package leetcode.linkedlist;

import java.util.HashSet;

public class LinkedList {

    Node head;
    Node tail;
    int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        length++;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    Node findMiddleNode() {

        if (head == null) return null;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    boolean hasLoop() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
        return false;
    }

    Node findKthNode(int k) {
        Node first = head;
        Node second = head;

        for (int i = 0; i < k; i++) {
            if (first == null) return null;
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        return second;
    }

    Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    Node findKthNodeFromEnd(int k) {
        return get(length - k);
    }

    void partitionList(int x) {
        Node small = new Node(0);
        Node high = new Node(0);

        Node smallHead = small;
        Node highHead = high;

        Node head = this.head;

        while (head != null) {
            if (head.value < x) {
                smallHead.next = head;
                smallHead = smallHead.next;
            } else {
                highHead.next = head;
                highHead = highHead.next;
            }
            head = head.next;
        }
        highHead.next = null;
        smallHead.next = high.next;
    }

    void removeDuplicates() {
        if (length == 0) return;
        HashSet<Integer> set = new HashSet<>();
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (set.contains(current.value)) {
                prev.next = current.next;
                length--;
            } else {
                set.add(current.value);
                prev = current;
            }
            current = current.next;
        }
    }

    int binaryToDecimal() {
        Node current = head;
        int result = 0;
        while (current != null) {
            result = (result << 1) | current.value;
            current = current.next;
        }
        return result;
    }

    Node reverseBetween(int left, int right) {
        Node head = this.head;
        if (head == null || head.next == null || left == right) return head;

        Node current = head;
        Node prev = null;

        int i = 1;

        while (current != null && i != left) {
            prev = current;
            current = current.next;
            i++;
        }

        Node pointerToStart = prev;
        Node start = current;
        prev = null;

        while (current != null && i != right + 1) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        start.next = current;
        if (pointerToStart != null) {
            pointerToStart.next = prev;
        } else {
            return prev;
        }
        return head;
    }

    static LinkedList mergeSorted(LinkedList list1, LinkedList list2) {
        LinkedList mergedList = new LinkedList(0);

        Node mergedTail = mergedList.head;

        Node current1 = list1.head;
        Node current2 = list2.head;

        while (current1 != null && current2 != null) {
            if (current1.value < current2.value) {
                mergedTail.next = current1;
                current1 = current1.next;
            } else {
                mergedTail.next = current2;
                current2 = current2.next;
            }
            mergedTail = mergedTail.next;
        }

        if (current1 != null) mergedTail.next = current1;
        if (current2 != null) mergedTail.next = current2;

        mergedList.head = mergedList.head.next;
        mergedList.tail = mergedTail;

        mergedList.updateLength();

        return mergedList;
    }

    void updateLength() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        this.length = count;
    }

    Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;

        //Find middle node
        Node middleNode = getMiddleNode(head);
        Node nextToMiddle = middleNode.next;
        middleNode.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nextToMiddle);

        return merge(left, right);
    }

    Node merge(Node left, Node right) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (left != null && right != null) {
            if (left.value < right.value) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        if (left != null) {
            tail.next = left;
        } else {
            tail.next = right;
        }

        return dummy.next;
    }

    Node getMiddleNode(Node head) {
        if (head == null) return head;

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    void sort() {
        head = mergeSort(head);
        Node temp = head;
        while (temp != null && temp.next != null) {
            temp = temp.next;
        }
        tail = temp;
    }
}
