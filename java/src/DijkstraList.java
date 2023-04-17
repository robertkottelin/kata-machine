package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DijkstraList {

    public static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private static boolean hasUnvisited(boolean[] seen, double[] dist) {
        for (int i = 0; i < seen.length; ++i) {
            if (!seen[i] && dist[i] < Double.POSITIVE_INFINITY) {
                return true;
            }
        }
        return false;
    }

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

    // Running time: O(V^2 + E)
    public static List<Integer> dijkstraLift(int source, int sink, List<List<Edge>> arr) {
        boolean[] seen = new boolean[arr.size()];
        Arrays.fill(seen, false);
        double[] dists = new double[arr.size()];
        Arrays.fill(dists, Double.POSITIVE_INFINITY);
        int[] prev = new int[arr.size()];
        Arrays.fill(prev, -1);

        dists[source] = 0;

        while (hasUnvisited(seen, dists)) {
            int curr = getLowestUnvisited(seen, dists);
            seen[curr] = true;

            List<Edge> adjs = arr.get(curr);

            for (int i = 0; i < adjs.size(); ++i) {
                Edge edge = adjs.get(i);
                if (seen[edge.to]) {
                    continue;
                }
                double dist = dists[curr] + edge.weight;
                if (dist < dists[edge.to]) {
                    dists[edge.to] = dist;
                    prev[edge.to] = curr;
                }
            }
        }

        List<Integer> out = new ArrayList<>();
        int curr = sink;

        while (prev[curr] != -1) {
            out.add(curr);
            curr = prev[curr];
        }

        out.add(source);
        List<Integer> reversedOut = new ArrayList<>(out);
        java.util.Collections.reverse(reversedOut);

        return reversedOut;
    }
}
