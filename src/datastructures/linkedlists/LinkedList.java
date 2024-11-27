package datastructures.linkedlists;

public class LinkedList {

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

    public LinkedList(int value) {
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
        System.out.println("----------------------------");
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
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

    public Node removeLast() {
        if (length == 0) return null;
        Node temp = head;
        Node pre = head;
        while(temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
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

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
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
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    Node remove(int index) {
        if (index < 0 || index > length) return null;
        if (index == 0) {
            return removeFirst();
        }
        if (index == length) {
            return removeLast();
        }
        Node pre = get(index - 1);
        Node temp = pre.next;

        pre.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;

        Node after = temp.next;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    void bubbleSort() {
        // If list length is less than 2, no need to sort
        if (this.length < 2)
            return;

        // Initialize sortedUntil as null (nothing is sorted initially)
        Node sortedUntil = null;

        // Outer loop continues until sorted part reaches the second node
        while (sortedUntil != this.head.next) {

            // Start with the head node
            Node current = this.head;

            // Inner loop for each pass
            while (current.next != sortedUntil) {

                // Compare current node with next node
                Node nextNode = current.next;

                // If current node is greater, swap values
                if (current.value > nextNode.value) {
                    int temp = current.value;
                    current.value = nextNode.value;
                    nextNode.value = temp;
                }

                // Move to the next node
                current = current.next;
            }

            // After each pass, the largest element is bubbled to the end
            // Thus, update sortedUntil to point to the last sorted element
            sortedUntil = current;
        }
    }

    void selectionSort() {
        // If list length is less than 2, no need to sort
        if (this.length < 2)
            return;

        // Initialize current node as head
        Node current = this.head;

        // Iterate over the list until the second last element
        while (current.next != null) {

            // Assume current node is the smallest
            Node smallest = current;

            // Start checking from the next node
            Node innerCurrent = current.next;

            // Inner loop to find smallest node in unsorted part
            while (innerCurrent != null) {
                // If a smaller node is found, update smallest
                if (innerCurrent.value < smallest.value) {
                    smallest = innerCurrent;
                }
                // Move to the next node
                innerCurrent = innerCurrent.next;
            }

            // Swap current node and smallest node if they're not the same
            if (smallest != current) {
                int temp = current.value;
                current.value = smallest.value;
                smallest.value = temp;
            }

            // Move to next node in the list
            current = current.next;
        }

    }

    public void insertionSort() {
        // If the list has less than 2 elements, it is already sorted
        if (length < 2) {
            return;
        }

        // Start with a sorted list containing only the first element
        Node sortedListHead = head;

        // Start with the second element in the unsorted list
        Node unsortedListHead = head.next;

        // Mark the end of the sorted list
        sortedListHead.next = null;

        // Iterate over the unsorted list
        while (unsortedListHead != null) {

            // Take the first element in the unsorted list
            Node current = unsortedListHead;

            // Move to the next element in the unsorted list
            unsortedListHead = unsortedListHead.next;

            // If the current element is smaller than the first element of the sorted list
            if (current.value < sortedListHead.value) {
                // Insert the current element at the beginning of the sorted list
                current.next = sortedListHead;
                // Update the sorted list head
                sortedListHead = current;
            } else {
                // Start at the beginning of the sorted list
                Node searchPointer = sortedListHead;

                // Search for the correct insertion point
                while (searchPointer.next != null && current.value > searchPointer.next.value) {
                    // Move to the next element in the sorted list
                    searchPointer = searchPointer.next;
                }

                // Insert the current element after searchPointer
                current.next = searchPointer.next;
                searchPointer.next = current;
            }
        }

        // Update the head of the sorted list
        head = sortedListHead;

        // Update the tail of the sorted list
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        tail = temp;
    }

    public void merge(LinkedList otherList) {
        // get the head node of the other linked list
        Node otherHead = otherList.getHead();
        // create a dummy node to serve as the head of the merged linked list
        Node dummy = new Node(0);
        // create a current node to keep track of the last node in the merged list
        Node current = dummy;

        // iterate through both input linked lists as long as they are not null
        while (head != null && otherHead != null) {
            // compare the values of the head nodes of the two lists
            if (head.value < otherHead.value) {
                // append the smaller node to the merged list and
                //update the head of that list to its next node
                current.next = head;
                head = head.next;
            } else {
                // append the smaller node to the merged list and
                //update the head of that list to its next node
                current.next = otherHead;
                otherHead = otherHead.next;
            }
            // update the "current" node to be the last node in the merged list
            current = current.next;
        }

        // if either of the input lists still has nodes,
        // append them to the end of the merged list
        if (head != null) {
            current.next = head;
        } else {
            current.next = otherHead;
            // If current list is empty, update tail to last node of other list
            // Otherwise, tail remains the last node of the current list
            tail = otherList.getTail();
        }

        // update the head of the current list to be the second node
        // in the merged list (since the first node is the dummy node)
        head = dummy.next;
        // update the length of the current list to reflect the merged list
        length += otherList.getLength();
    }
}
