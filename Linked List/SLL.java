
public class SLL {

    public static Node head;
    public static Node tail;

    SLL() {
        head = null;
        tail = null;
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
            return;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addMid(int data, int idx) {
        Node newNode = new Node(data);
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        Node temp = head;
        int i = 1;
        while (temp != null && i < idx) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }

    public void delete() {
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
    }

    public void delFirst() {
        Node temp = head;
        head = temp.next;
        temp.next = null;
    }

    public void delMid(int idx) {
        if (head == null) {
            return;
        }
        Node prev = head;
        Node current = head;
        int count = 0;
        while (current != null && count <= idx - 1) {
            prev = current;
            current = current.next;
            count++;
        }
        prev.next = current.next;
        current.next = null;

    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SLL s = new SLL();
        s.add(4);
        s.add(3);
        s.add(2);
        s.addFirst(1);
        s.addMid(7, 2);
        s.display();
        s.delete();
        s.delFirst();
        s.delMid(2);
        s.display();
    }
}