package datastructures.linkedlists;

public class Main {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList(4);
        //linkedList.printList();
//        System.out.println(linkedList.getHead());
//        System.out.println(linkedList.getTail());
//        System.out.println(linkedList.getLength());

        linkedList.append(8);
        linkedList.printList();

        linkedList.removeLastNode();
        System.out.println("After remove");
        linkedList.printList();

        linkedList.prepend(6);
        linkedList.prepend(0);
        linkedList.printList();

        System.out.println("After remove first");
        linkedList.removeFirst();
        linkedList.printList();

        linkedList.append(7);
        System.out.println(linkedList.get(0).value);
        linkedList.set(0, 20);
        linkedList.insert(2, 8);
        linkedList.printList();
    }
}
