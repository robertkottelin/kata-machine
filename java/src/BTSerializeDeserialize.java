import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Codec {
    private static final String separator = ",";
    private static final String nullNode = "null";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(nullNode).append(separator);
        } else {
            sb.append(node.val).append(separator);
            serialize(node.left, sb);
            serialize(node.right, sb);
        }
    }

    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(separator)));
        return deserialize(nodes);
    }

    private TreeNode deserialize(Queue<String> nodes) {
        String value = nodes.poll();
        if (value.equals(nullNode)) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(value));
        node.left = deserialize(nodes);
        node.right = deserialize(nodes);

        return node;
    }
}
