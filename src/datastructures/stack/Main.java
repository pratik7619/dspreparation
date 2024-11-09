package datastructures.stack;

public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack(4);
        System.out.println(stack.getHeight());
        System.out.println(stack.getTop().value);
        stack.printStack();

        stack.push(1);
        stack.push(8);
        stack.printStack(); //8 1 4

        stack.pop();
        stack.printStack(); // 1 4
    }
}
