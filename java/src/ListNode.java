package src;

public class ListNode<T> {
    T value;
    ListNode<T> next;

    public ListNode(T value) {
        this.value = value;
        this.next = null;
    }
}
