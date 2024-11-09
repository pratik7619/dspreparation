package leetcode.doublylinkedlist;


public class ReverseLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);

        linkedList.printList();
        System.out.println("======================");
        linkedList.reverse();
        linkedList.printList();
    }
}
