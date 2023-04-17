package src;

public class StackNode<T> {
    T value;
    StackNode<T> prev;

    public StackNode(T value) {
        this.value = value;
        this.prev = null;
    }
}