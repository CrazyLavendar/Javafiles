public class EmployeeDoublyNode extends EmployeeNode {

    EmployeeNode previous;

    public EmployeeDoublyNode(Employee employee, EmployeeNode next, EmployeeNode previous) {
        super(employee, next); // call the constructor of superclass
        // TODO Auto-generated constructor stub
        this.previous = previous;
    }

    // use getter setter for encapsulation

}
