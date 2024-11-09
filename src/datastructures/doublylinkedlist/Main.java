package datastructures.doublylinkedlist;

public class Main {

    public static void main(String[] args) {
        DoubleLinkedList dl = new DoubleLinkedList(7);

//        System.out.println(dl.getHead().value); // 7
//        System.out.println(dl.getTail().value); // 7
//        System.out.println(dl.getLength()); // 1

        dl.append(5);
        dl.append(9);
        dl.printList(); //5 7 9

        dl.append(10);
        dl.append(8);
        dl.printList(); //7 5 9 10 8

        dl.removeLast();
        dl.removeLast();
        dl.removeLast();
        dl.printList(); //7 5

        dl.prepend(40);
        dl.prepend(46);
        dl.printList(); //46 40 7 5

        dl.removeFirst();
        dl.printList(); // 40 7 5

        System.out.println(dl.get(2).value); //5

        dl.set(2, 16);
        dl.printList(); //40 7 16

        dl.removeAt(1);
        dl.printList(); //40 16

        dl.insert(2, 60);
        dl.printList();
    }
}
