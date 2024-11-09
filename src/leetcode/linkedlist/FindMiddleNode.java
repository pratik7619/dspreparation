package leetcode.linkedlist;

public class FindMiddleNode {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(40);
        linkedList.append(50);
        linkedList.append(60);
        linkedList.append(70);
        linkedList.append(80);
        linkedList.append(90);
        linkedList.append(100);
        linkedList.append(110);
        linkedList.append(120);

        linkedList.printList();

        System.out.println(linkedList.findMiddleNode().value);
    }
}
