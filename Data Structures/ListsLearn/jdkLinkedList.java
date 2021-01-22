import java.util.Iterator;
import java.util.LinkedList;

public class jdkLinkedList {
    public static void main(String[] args) {

        Employee e1 = new Employee("Jane", "Jones", 123);
        Employee e2 = new Employee("John", "Doe", 4567);
        Employee e3 = new Employee("Mary", "Smith", 22);
        Employee e4 = new Employee("Mike", "Wilson", 3245);

        LinkedList list = new LinkedList<>();

        list.addFirst(e1);
        list.addFirst(e2);
        list.addFirst(e3);

        list.add(e4); // add end
        list.removeFirst();
        Iterator iter = list.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        // for (Employee employee: list) {
        // System.out.println(employee);
        // }
    }

}
