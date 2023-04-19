package src;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstGraphListSearch {

    // Define an Edge class to represent directed edges with weights
    public static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // Recursive helper function to perform the Depth-First Search
    public static boolean walk(List<List<Edge>> graph, int curr, int needle, boolean[] seen, List<Integer> path) {
        // Base case 1: if the current node is the target node, return true
        if (curr == needle) {
            return true;
        }

        // Base case 2: if the current node has already been visited, return false
        if (seen[curr]) {
            return false;
        }

        // Mark the current node as visited
        seen[curr] = true;

        // Add the current node to the path
        path.add(curr);

        // Iterate through the edges of the current node
        List<Edge> list = graph.get(curr);
        for (int i = 0; i < list.size(); ++i) {
            Edge edge = list.get(i);
            // Recursively call the walk function on the adjacent node (edge.to)
            if (walk(graph, edge.to, needle, seen, path)) {
                return true;
            }
        }

        // If the target node was not found in the current subtree, remove the current node from the path
        path.remove(path.size() - 1);

        return false;
    }

    // Main function to perform Depth-First Search on a graph represented as an adjacency list
    // Running time: O(V + E)
    public static List<Integer> dfs(List<List<Edge>> graph, int source, int needle) {
        // Create an array to keep track of visited nodes
        boolean[] seen = new boolean[graph.size()];

        // Create a list to store the path from the source node to the target node
        List<Integer> path = new ArrayList<>();

        // Call the walk function to perform the Depth-First Search and update the path
        if (walk(graph, source, needle, seen, path)) {
            return path;
        }

        // If the target node was not found, return an empty path
        return path;
    }
}
