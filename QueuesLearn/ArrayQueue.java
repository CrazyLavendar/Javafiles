import java.util.NoSuchElementException;

public class ArrayQueue {
    public Employee[] queue;
    public int front;
    public int back;

    public ArrayQueue(int capacity) {
        queue = new Employee[capacity];
    }

    public void Enqueue(Employee employee) {
        // Add one remove one repeat. In this case two elemments makes
        // back == queue.length
        // Circular queue removes this limitation
        if (back == queue.length) {
            Employee[] newQueue = new Employee[2 * queue.length];
            System.arraycopy(queue, 0, newQueue, 0, queue.length);
            queue = newQueue;
        }
        queue[back++] = employee;
    }

    public Employee dequeue() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        Employee removedEmployee = queue[front];
        queue[front++] = null;
        if (size() == 0)
            front = back = 0; // Bit of optimization

        return removedEmployee;
    }

    public Employee peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        return queue[front];
    }

    public int size() {
        return back - front;
    }

    public void printQueue() {
        for (int i = front; i < back; i++) {
            System.out.println(queue[i]);
        }
    }

}