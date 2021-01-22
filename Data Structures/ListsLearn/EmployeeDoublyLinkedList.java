public class EmployeeDoublyLinkedList extends EmployeeLinkedList {

    // private EmployeeDoublyNode head; // It contains head and size

    private EmployeeDoublyNode head; // Employee node doesn't have details of tail . So use DoublyNode
    private EmployeeDoublyNode tail; //
    // private int size;

    @Override
    public void addToFront(Employee employee) {
        EmployeeDoublyNode node = new EmployeeDoublyNode(employee, head, tail);
        node.previous = null;

        node.next = head;
        if (head == null) {
            tail = node;
        } else {
            head.previous = node;
        }
        head = node;
        EmployeeLinkedList.size++;
    }

    public void addToEnd(Employee employee) {

        EmployeeDoublyNode node = new EmployeeDoublyNode(employee, head, tail);
        node.next = null;

        if (tail == null) {
            head = node;

        } else {
            tail.next = node;
            node.previous = tail;
        }

        tail = node;
        EmployeeLinkedList.size++;
    }

    @Override
    public void printlist() {
        EmployeeNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current + " <=> ");
            current = current.next;
        }
        System.out.print("null\n");

    }
}
