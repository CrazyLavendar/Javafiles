import java.util.NoSuchElementException;

public class CircularArrayQueue extends ArrayQueue {

    public CircularArrayQueue(int capacity) {
        super(capacity);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void Enqueue(Employee employee) {

        if (size() == queue.length - 1) {

            int numItems = size(); // back - front
            Employee[] newQueue = new Employee[2 * queue.length];
            // resetting queue
            System.arraycopy(queue, front, newQueue, 0, queue.length - front);
            System.arraycopy(queue, 0, newQueue, queue.length - front, back);
            queue = newQueue;

            front = 0;
            back = numItems;
        }

        queue[back] = employee;

        if (back < queue.length - 1)
            back++;
        else {
            back = 0; // Reinitiating back.. This case back can be lesser count than front
            // Even Add one remove one repeat. In this case we might not come on doubling
            // the array
        }
    }

    @Override
    public Employee dequeue() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        Employee removedEmployee = queue[front];
        queue[front++] = null;
        if (size() == 0)
            front = back = 0; // Bit of optimization
        else if (front == queue.length) { // making it circular
            front = 0;
        }

        return removedEmployee;
    }

    @Override
    public int size() {
        if (front <= back)
            return back - front;
        else {
            return back - front + queue.length;
        }
    }

    @Override
    public void printQueue() {
        if (front <= back) {
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        } else {
            for (int i = front; i < queue.length; i++) {
                System.out.println(queue[i]);
            }
            for (int i = 0; i < back; i++) {
                System.out.println(queue[i]);
            }
        }
    }

}
