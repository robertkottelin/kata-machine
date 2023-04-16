package src;

import java.util.ArrayDeque;
import java.util.Deque;

public class BTBFS {
    public static class BinaryNode<T> {
        public T value;
        public BinaryNode<T> left;
        public BinaryNode<T> right;

        public BinaryNode(T value) {
            this.value = value;
        }
    }

    public static boolean bfs(BinaryNode<Integer> head, int needle) {
        Deque<BinaryNode<Integer>> q = new ArrayDeque<>();
        q.add(head);

        while (!q.isEmpty()) {
            BinaryNode<Integer> curr = q.removeFirst();

            if (curr == null) {
                continue;
            }

            if (curr.value == needle) {
                return true;
            }

            q.addLast(curr.left);
            q.addLast(curr.right);
        }

        return false;
    }
}