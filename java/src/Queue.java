package src;

public class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }
}

public class Queue<T> {
    public int length;
    private Node<T> head;
    private Node<T> tail;

    public Queue() {
        this.head = this.tail = null;
        this.length = 0;
    }

    public void enqueue(T item) {
        Node<T> node = new Node<>(item);
        this.length++;
        if (this.tail == null) {
            this.tail = this.head = node;
            return;
        }

        this.tail.next = node;
        this.tail = node;
    }

    public T dequeue() {
        if (this.head == null) {
            return null;
        }

        this.length--;

        Node<T> head = this.head;
        this.head = this.head.next;

        head.next = null;

        return head.value;
    }

    public T peek() {
        return this.head != null ? this.head.value : null;
    }
}
