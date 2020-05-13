package hackerrank.graph.bfs.cleancode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class GraphProcessingData {
    private final LinkedList<Node> nextToVisit = new LinkedList<>();
    private final HashSet<Integer> visitedNodes = new HashSet<>();
    private final int[] distances;

    public GraphProcessingData(int nodesSize) {
        this.distances = new int[nodesSize];
        Arrays.fill(distances, -1); // initially all distancesOne are -1
    }

    public void addNextToVisit(final Node node) {
        this.nextToVisit.add(node);
    }

    public void addVisited(final Node node) {
        this.visitedNodes.add(node.getId());
    }

    public void setDistance(final Node node, final int distance) {
        this.distances[node.getId() - 1] = distance;
    }

    public LinkedList<Node> getNextToVisit() {
        return nextToVisit;
    }

    public HashSet<Integer> getVisitedNodes() {
        return visitedNodes;
    }

    public int[] getDistances() {
        return distances;
    }

    public int getDistanceToNode(final Node node) {
        return distances[node.getId() - 1];
    }
}