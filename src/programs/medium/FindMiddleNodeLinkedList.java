package programs.medium;

class LinkedList {
    private Node head;
    private Node tail;
    private int length;

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

    int getLength() {
        return length;
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

    void printList() {
        System.out.println("----------------------------");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    Node findMiddleNode() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }

    Node findkthNodeFromEnd(int k) {
        if (k > length) return null;
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

    Node partitionListEfficient(int x) {
        Node beforeHead = new Node(0);
        Node before = beforeHead;
        Node afterHead = new Node(0);
        Node after = afterHead;

        while (head != null) {
            if (head.value < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        after.next = null;
        before.next = afterHead.next;
        return beforeHead.next;
    }

    void partitionList(int x) {
        if (head == null) return;

        Node beforeHead = null;
        Node beforeTail = null;
        Node afterHead = null;
        Node afterTail = null;

        Node current = head;

        while (current != null) {
            if (current.value < x) {
                if (beforeHead == null) {
                    beforeHead = current;
                    beforeTail = beforeHead;
                } else {
                    beforeTail.next = current;
                    beforeTail = beforeTail.next;
                }
            } else {
                if (afterHead == null) {
                    afterHead = current;
                    afterTail = afterHead;
                } else {
                    afterTail.next = current;
                    afterTail = afterTail.next;
                }
            }
            current = current.next;
        }
        if (beforeHead == null) {
            head = afterHead;
        } else {
            head = beforeHead;
            beforeTail.next = afterHead;
        }

        if (afterTail != null) {
            afterTail.next = null;
        }
    }

    void reverseBetween(int startIndex, int endIndex) {
        if (head == null || startIndex == endIndex || endIndex >= length) return;

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        for (int i = 0; i < startIndex; i++) {
            prev = prev.next;
        }

        Node start = prev.next;
        Node then = start.next;

        for (int i = 0; i < endIndex - startIndex; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        head = dummy.next;
    }
}

public class FindMiddleNodeLinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(11);
        linkedList.append(3);
        linkedList.append(2);
        linkedList.append(7);
        linkedList.append(10);

//        linkedList.printList();
//
//        int middleIndex = linkedList.getLength() / 2;
//        System.out.println(linkedList.get(middleIndex).value);
//
//        System.out.println(linkedList.findMiddleNode().value);

        linkedList.partitionList(7);
        linkedList.printList();

        linkedList.reverseBetween(1, 5);
        linkedList.printList();

    }
}
