package src;

// last in, first out

public class Node<T> {
    T value;
    Node<T> prev;

    public Node(T value) {
        this.value = value;
        this.prev = null;
    }
}

public class Stack<T> {
    public int length;
    private Node<T> head;

    public Stack() {
        this.head = null;
        this.length = 0;
    }

    public void push(T item) {
        Node<T> node = new Node<>(item);

        this.length++;
        if (this.head == null) {
            this.head = node;
            return;
        }
        node.prev = this.head;
        this.head = node;
    }

    public T pop() {
        this.length = Math.max(0, this.length - 1);
        if (this.length == 0) {
            Node<T> head = this.head;
            this.head = null;
            return head != null ? head.value : null;
        }

        Node<T> head = this.head;
        this.head = head.prev;

        return head.value;
    }

    public T peek() {
        return this.head != null ? this.head.value : null;
    }
}
