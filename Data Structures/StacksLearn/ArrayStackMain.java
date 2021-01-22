public class ArrayStackMain {
    public static void main(String[] args) {
        Arraystack stack = new Arraystack(10);

        Employee e1 = new Employee("Jane", "Jones", 123);
        Employee e2 = new Employee("John", "Doe", 4567);
        Employee e3 = new Employee("Mary", "Smith", 22);
        Employee e4 = new Employee("Mike", "Wilson", 3245);

        stack.push(e1);
        stack.push(e2);
        stack.push(e3);
        stack.push(e4);

        stack.printStack();

        System.out.println("\n\n");

        System.out.println("Popped employee : " + stack.pop());

        System.out.println("\n\n");

        stack.push(new Employee("Vimal", "Kumar", 999));

        stack.printStack();

      System.out.println("Peeked employee : " + stack.peek());

    }
}
