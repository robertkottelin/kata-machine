package src;

public class DFSOnBinaryTree {

    public static class BinaryNode<T> {
        T value;
        BinaryNode<T> left;
        BinaryNode<T> right;

        public BinaryNode(T value, BinaryNode<T> left, BinaryNode<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private static boolean search(BinaryNode<Integer> curr, int needle) {
        if (curr == null) {
            return false;
        }

        if (curr.value == needle) {
            return true;
        }

        if (curr.value < needle) {
            return search(curr.right, needle);
        }

        if (curr.value > needle) {
            return search(curr.left, needle);
        }

        return search(curr.left, needle) || search(curr.right, needle);
    }

    public static boolean dfs(BinaryNode<Integer> head, int needle) {
        return search(head, needle);
    }
}
