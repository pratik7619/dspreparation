package leetcode.linkedlist;

public class PartitionList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(4);
        linkedList.append(3);
        linkedList.append(2);
        linkedList.append(5);
        linkedList.append(2);

        linkedList.printList();

        linkedList.partitionList(3);
        linkedList.printList();
    }
}
