package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DijkstraList {

    // Class representing an edge in a graph with a destination and a weight
    public static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // Helper function to check if there are unvisited nodes with finite distances
    private static boolean hasUnvisited(boolean[] seen, double[] dist) {
        for (int i = 0; i < seen.length; ++i) {
            if (!seen[i] && dist[i] < Double.POSITIVE_INFINITY) {
                return true;
            }
        }
        return false;
    }

    // Helper function to find the index of the unvisited node with the lowest distance
    private static int getLowestUnvisited(boolean[] seen, double[] dist) {
        int idx = -1;
        double lowestDistance = Double.POSITIVE_INFINITY;
        for (int i = 0; i < seen.length; ++i) {
            if (seen[i]) {
                continue;
            }

            if (dist[i] < lowestDistance) {
                lowestDistance = dist[i];
                idx = i;
            }
        }

        return idx;
    }

    // Dijkstra's algorithm to find the shortest path between two nodes in a graph
    // Running time: O(V^2 + E)
    public static List<Integer> dijkstraLift(int source, int sink, List<List<Edge>> arr) {
        // Initialize seen (visited) and dist (distance) arrays
        boolean[] seen = new boolean[arr.size()];
        Arrays.fill(seen, false);
        double[] dists = new double[arr.size()];
        Arrays.fill(dists, Double.POSITIVE_INFINITY);
        int[] prev = new int[arr.size()];
        Arrays.fill(prev, -1);

        // Set the distance of the source node to zero
        dists[source] = 0;

        // Continue while there are unvisited nodes with finite distances
        while (hasUnvisited(seen, dists)) {
            // Get the index of the unvisited node with the lowest distance
            int curr = getLowestUnvisited(seen, dists);
            // Mark the current node as visited
            seen[curr] = true;

            // Iterate through the current node's adjacent edges
            List<Edge> adjs = arr.get(curr);
            for (int i = 0; i < adjs.size(); ++i) {
                Edge edge = adjs.get(i);
                // Skip if the adjacent node is already visited
                if (seen[edge.to]) {
                    continue;
                }
                // Calculate the new distance to the adjacent node
                double dist = dists[curr] + edge.weight;
                // Update the distance and previous node if the new distance is shorter
                if (dist < dists[edge.to]) {
                    dists[edge.to] = dist;
                    prev[edge.to] = curr;
                }
            }
        }

        // Construct the shortest path by traversing the previous nodes array
        List<Integer> out = new ArrayList<>();
        int curr = sink;
        while (prev[curr] != -1) {
            out.add(curr);
            curr = prev[curr];
        }

        // Add the source node and reverse the path to get the correct order
        out.add(source);
        List<Integer> reversedOut = new ArrayList<>(out);
        java.util.Collections.reverse(reversedOut);

        // Return the shortest path from source to sink as a list of node indices
        return reversedOut;
    }
}

