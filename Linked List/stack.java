public class stack {

    public class Node {
        int data;
        Node next;

        public Node(int n) {
            data = n;
            next = null;
        }
    }

    public Node head = null;
    public Node top = null;

    // push
    public void push(int n) {
        Node newnode = new Node(n);
        if (head == null) {
            head = newnode;
            top = newnode;
        }
        else{
        top.next = newnode;
        top = newnode;
        }
    }

    // pop
    public int pop() {
        int pop = 0;
        if (top == null) {
            System.out.println("Stack Underflow");
            return -1;
        }
        Node temp = head;
        while (temp.next != top) {
            temp = temp.next;
        }
        pop = top.data;
        top = temp;
        top.next = null;
        return pop;
    }

    // peek
    public int peek() {
        return top.data;
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

        stack s = new stack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        System.out.println(s.pop());
        System.out.println(s.peek());
        s.display();
    }
}