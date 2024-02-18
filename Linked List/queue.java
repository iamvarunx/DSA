public class queue {

    public class Node {

        int data;
        Node next;

        public Node(int n) {
            data = n;
            next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    // enqueue
    public void enqueue(int n) {
        Node newnode = new Node(n);
        if (head == null) {
            head = newnode;
            tail = newnode;
        } else {
            tail.next = newnode;
            tail = newnode;
        }
    }

    // dequeue
    public void dequeue() {
        if (head == null) {
            return;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
    }

    // display
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        queue q = new queue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.dequeue();
        q.display();
    }
}