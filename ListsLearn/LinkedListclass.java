public class LinkedListclass {
    public static void main(String[] args) {

        Employee e1 = new Employee("Jane", "Jones", 123);
        Employee e2 = new Employee("John", "Doe", 4567);
        Employee e3 = new Employee("Mary", "Smith", 22);
        Employee e4 = new Employee("Mike", "Wilson", 3245);

        EmployeeLinkedList list = new EmployeeLinkedList();

        System.out.println(list.isEmpty());

        list.addToFront(e1);
        list.addToFront(e2);
        list.addToFront(e3);
        list.addToFront(e4);

        list.removeFromFront();

        list.printlist();

        System.out.println(list.getSize());

    }
}
