package programs.medium;

import java.util.Stack;

public class SortStack {

    public static void sortStack(Stack<Integer> stack) {

        Stack<Integer> additionalStack = new Stack<>();

        while (!stack.isEmpty()) {

            int temp = stack.pop();

            while (!additionalStack.isEmpty() && additionalStack.peek() > temp) {
                stack.push(additionalStack.pop());
            }

            additionalStack.push(temp);
        }

        while (!additionalStack.isEmpty()) {
            stack.push(additionalStack.pop());
        }
    }
}
