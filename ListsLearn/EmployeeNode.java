public class EmployeeNode {

    public Employee employee;
    public EmployeeNode next;

    public EmployeeNode(Employee employee, EmployeeNode next) {
        this.employee = employee;
        this.next = next;
    }

    // use getter setter for encapsulation
    @Override
    public String toString() {
        return employee.toString();
    }
}
