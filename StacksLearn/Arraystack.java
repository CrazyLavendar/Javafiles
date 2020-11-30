import java.util.EmptyStackException;

public class Arraystack {

    private Employee[] stack;
    private int top;

    public Arraystack(int capacity) {
        stack = new Employee[capacity];
    }

    public void push(Employee employee) {
        if (top == stack.length) {
            // need to resize thr backing array
            Employee[] newStack = new Employee[2 * stack.length];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        stack[top++] = employee;
    }

    public Employee pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        Employee employee = stack[--top];
        stack[top] = null;
        return employee;

        // Note: If we are considering resizing array after too many poping.
        // Then for popping O(1) => O(n)
    }

    public Employee peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int Size() {
        return top;
    }

    public void printStack() {
        int i = top - 1;
        while (i >= 0)
            System.out.println(stack[i--]);
    }
}
