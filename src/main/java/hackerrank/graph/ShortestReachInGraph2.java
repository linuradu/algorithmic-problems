package hackerrank.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ShortestReachInGraph2 {

    public static class NodeAndDistance {
        private int node;
        private int distance;

        public NodeAndDistance(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        public int getNode() {
            return node;
        }

        public void setNode(int node) {
            this.node = node;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }
    }

    public static class Graph {

        public static int EDGE_LENGTH = 6;
        private int size;
        private List<List<Integer>> edgesList = new ArrayList<>();

        public Graph(int size) {
            this.size = size;

            while (size-- > 0){
                edgesList.add(new ArrayList<>());
            }
        }

        public void addEdge(int first, int second) {
            edgesList.get(first).add(second);
            edgesList.get(second).add(first);
        }

        public int[] shortestReach(int startId) { // 0 indexed
            int[] distances = new int[size];
            Arrays.fill(distances, -1); // O(n) space.
            LinkedList<Integer> nextNodes = new LinkedList<>();

            nextNodes.add(startId);
            distances[startId] = 0;

            HashSet<Integer> seen = new HashSet<>();

            seen.add(startId);
            while (!nextNodes.isEmpty()) {
                Integer head = nextNodes.remove();

                List<Integer> newNodeDestinations = edgesList.get(head);
                if (newNodeDestinations!= null && newNodeDestinations.size() > 0) {
                    newNodeDestinations.forEach(node -> {
                        if(!seen.contains(node)){
                            nextNodes.add(node);
                            seen.add(node);

                            distances[node] = distances[head] + EDGE_LENGTH;
                        }
                    });
                }
            }

            return distances;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
