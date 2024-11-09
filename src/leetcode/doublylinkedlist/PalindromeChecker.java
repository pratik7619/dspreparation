package leetcode.doublylinkedlist;

public class PalindromeChecker {

    public static void main(String[] args) {

        DoublyLinkedList linkedList = new DoublyLinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(2);
        linkedList.append(1);

        System.out.println(linkedList.isPalindrome());
    }
}
