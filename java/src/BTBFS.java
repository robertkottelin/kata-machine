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


//////////////////////////////////////////////////////////
// Implement a Binary Search Tree with insertion, deletion, and traversal methods.

class BinarySearchTree {
    class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    private int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
}

