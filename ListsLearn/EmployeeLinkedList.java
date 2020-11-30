public class EmployeeLinkedList {

    public EmployeeNode head;
    public static int size;

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee, head);
        node.next = head;
        head = node;
        size++;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void removeFromFront() {
        if (head == null)
            return;
        else {
            EmployeeNode removedNode = head;
            head = head.next;
            removedNode.next = null;

        }
    }

    public void printlist() {
        EmployeeNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current + " -> ");
            current = current.next;
        }
        System.out.print("null\n");

    }
}
