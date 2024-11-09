package datastructures.queues;

public class Main {

    public static void main(String[] args) {

        Queue queue = new Queue(5);
        System.out.println(queue.getFirst().value);
        System.out.println(queue.getLast().value);
        System.out.println(queue.getLength());
        queue.printStack();

        queue.enqueue(9);
        queue.enqueue(4);
        queue.printStack();
    }
}
