import java.util.List;
import java.util.Vector;

//similar to array list : but Vectorlist  is synchronized , thread safe , slower
public class VectorListclass {
    public static void main(String[] args) {

        // List declaration
        List<Employee> employeeList = new Vector<>();

        // add employee list
        employeeList.add(new Employee("Jane", "Jones", 123));
        employeeList.add(new Employee("John", "Doe", 4567));
        employeeList.add(new Employee("Mary", "Smith", 22));
        employeeList.add(new Employee("Mike", "Wilson", 3245));

        // employeeList.forEach(employee -> System.out.println(employee));

        // Get the element
        var x = employeeList.get(1);
        // System.out.println(x);

        // check empty
        var y = employeeList.isEmpty();
        // System.out.println(y);

        // update employee list
        employeeList.set(1, new Employee("Vimal", "Kumar", 001));
        // employeeList.forEach(employee -> System.out.println(employee));

        // Size of arrayListx
        var size = employeeList.size();
        // System.out.println(size);

        // adding element on speciied place
        employeeList.add(3, new Employee("Prakrati", "Gupta", 890));
        // employeeList.forEach(employee -> System.out.println(employee));

        // creating object array
        Object[] employeeArray = employeeList.toArray();

        // if compiler error occurs then use below line
        // Object[] employeeArray = employeeList.toArray(new
        // Object[employeeList.size()]);

        for (Object employee : employeeArray) {
            System.out.println(employee);
        }

        // contains method - boolean
        var contain = employeeList.contains(new Employee("Mary", "Smith", 22));
        // System.out.println(contain); // It's false .. Since acts are different
        // instance unless we overwrite equals
        // method
        // Get employee index
        // This also works since we have to override equal.
        var employeeIndex = employeeList.indexOf(new Employee("Mike", "Wilson", 3245));
        // System.out.println(employeeIndex);

        // Remove
        employeeList.remove(2);
        // employeeList.forEach(employee -> System.out.println(employee));

    }
}
