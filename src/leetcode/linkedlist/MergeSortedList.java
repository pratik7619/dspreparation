package leetcode.linkedlist;

public class MergeSortedList {

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(1);
        list1.append(3);
        list1.append(5);
        list1.append(7);

        LinkedList list2 = new LinkedList(2);
        list2.append(4);
        list2.append(6);
        list2.append(8);

        LinkedList mergedList = LinkedList.mergeSorted(list1, list2);
        mergedList.printList();

        System.out.println("==============================");

        LinkedList list = new LinkedList(4);
        list.append(2);
        list.append(1);
        list.append(5);
        list.append(3);

        list.sort();

        list.printList();
    }
}
