package hackerrank.graph.bfs.cleancode2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GraphProcessingData {
    private final Queue<Node> nextToVisit = new LinkedList<>();
    private final Set<Integer> visitedNodes = new HashSet<>();

    public void addNextToVisit(final Node node) {
        this.nextToVisit.add(node);
    }

    public void addVisited(final Node node) {
        this.visitedNodes.add(node.getId());
    }

    public Queue<Node> getNextToVisit() {
        return nextToVisit;
    }

    public Set<Integer> getVisitedNodes() {
        return visitedNodes;
    }
}