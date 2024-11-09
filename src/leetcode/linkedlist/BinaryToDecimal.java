package leetcode.linkedlist;

public class BinaryToDecimal {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList(1);
        linkedList.append(0);
        linkedList.append(1);

        System.out.println(linkedList.binaryToDecimal());
    }
}
