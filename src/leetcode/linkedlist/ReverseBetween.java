package leetcode.linkedlist;

public class ReverseBetween {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);


        linkedList.printList();
        linkedList.reverseBetween(2, 4);
        System.out.println("==================");
        linkedList.printList();
    }
}
