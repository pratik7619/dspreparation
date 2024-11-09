package leetcode.linkedlist;

public class RemoveDuplicates {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(2);
        linkedList.append(2);
        linkedList.append(4);
        linkedList.append(1);
        linkedList.append(5);
        System.out.println("=======Before Removing========");
        linkedList.printList();

        System.out.println("=======After Removing=======");
        linkedList.removeDuplicates();
        linkedList.printList();
    }
}
