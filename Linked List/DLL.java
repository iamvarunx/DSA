public class DLL {

    class Node {
        int data;
        Node next;
        Node prev;

        public Node(int n) {
            data = n;
            next = null;
            prev = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    // insertion at last
    public void add(int n) {
        Node newnode = new Node(n);
        if (head == null) {
            head = newnode;
            tail = newnode;
        } else {
            tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;
        }
    }

    // inserion at first
    public void addfirst(int n) {
        Node newnode = new Node(n);
        if (head == null) {
            head = newnode;
            tail = newnode;
        } else {
            newnode.next = head;
            head.next.prev = newnode;
            head = newnode;
        }
    }

    // insertion at middle
    public void addmid(int n, int pos) {
        Node newnode = new Node(n);
        Node pre = head;
        Node current = head;
        int count = 0;
        while (current != null && count <= pos - 1) {
            pre = current;
            current = current.next;
            count++;
        }
        pre.next = newnode;
        newnode.prev = pre;
        newnode.next = current;
        current.prev = newnode;
    }

    // deletion at last
    public void delete() {
        if (head == null)
            return;
        else {
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
        }
    }

    // deletion at middle
    public void deletemid(int pos) {
        if (head == null) {
            return;
        }
        int count = 0;
        Node pre = head;
        Node current = head;
        while (current != null && count <= pos) {
            pre = current;
            current = current.next;
            count++;
        }
        current.prev = pre.prev;
        pre.prev.next = current;
        pre.prev = null;
        pre.next = null;
    }

    // deletion at last
    public void deletelast() {
        if (head == null) {
            return;
        }
        Node temp = tail;
        tail.prev.next = null;
        tail = tail.prev;
        temp.prev = null;
    }

    // display
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        DLL d = new DLL();
        d.add(10);
        d.add(20);
        d.add(30);
        d.add(50);
        d.addmid(40, 3);
        d.deletemid(3);
        d.display();
    }
}