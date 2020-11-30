public class JDKLinkListStackMain {
    public static void main(String[] args) {
        Employee e1 = new Employee("Jane", "Jones", 123);
        Employee e2 = new Employee("John", "Doe", 4567);
        Employee e3 = new Employee("Mary", "Smith", 22);
        Employee e4 = new Employee("Mike", "Wilson", 3245);

        JDKLinkListStack customstack = new JDKLinkListStack();

        customstack.push(e1);
        customstack.push(e2);
        customstack.push(e3);
        customstack.push(e4);

        customstack.printstack();

        System.out.print("\n\n");
        System.out.println("Popped element " + customstack.pop());

        System.out.print("\n\n");
        customstack.printstack();

        System.out.println("peeked element " + customstack.peek());

    }
}