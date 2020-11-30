public class ArrayQueueMain {
    public static void main(String[] args) {
        Employee e1 = new Employee("Jane", "Jones", 123);
        Employee e2 = new Employee("John", "Doe", 4567);
        Employee e3 = new Employee("Mary", "Smith", 22);
        Employee e4 = new Employee("Mike", "Wilson", 3245);

        ArrayQueue queue = new ArrayQueue(5);

        queue.Enqueue(e1);
        queue.Enqueue(e2);
        queue.Enqueue(e3);
        queue.Enqueue(e4);

        System.out.println("Peeked element " + queue.peek());

        queue.dequeue();
        queue.Enqueue(e1);
        queue.dequeue();
        queue.Enqueue(e3);
        queue.dequeue();
        queue.Enqueue(e2);
        queue.dequeue();
        queue.Enqueue(e4);

        queue.printQueue();

        System.out.println("Dequeued element " + queue.dequeue());
        System.out.println("Queue front position " + queue.front);
        System.out.println("Queue back position " + queue.back); // Exceeds initial queue length
    }
}
