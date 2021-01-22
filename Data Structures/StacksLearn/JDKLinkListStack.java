import java.util.LinkedList;
import java.util.ListIterator;

//Here we are limiting functions that are push , pop , peek from JDK 
public class JDKLinkListStack {

    private LinkedList<Employee> stack;

    public JDKLinkListStack() {
        stack = new LinkedList<Employee>();
    }

    public void push(Employee employee) {
        stack.push(employee);
    }

    public Employee pop() {
        return stack.pop();
    }

    public Employee peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void printstack() {
        ListIterator<Employee> iter = stack.listIterator();
        while (iter.hasNext())
            System.out.print(iter.next());
    }

}