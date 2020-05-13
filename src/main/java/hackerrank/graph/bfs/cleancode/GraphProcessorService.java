package hackerrank.graph.bfs.cleancode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class GraphProcessorService {
    private final static int NODE_DISTANCE = 1;

    public boolean hasPathBFS(final Graph graph, int sourceId, int destinationId) {
        final Node source = graph.getNodesHeap().get(sourceId);
        final Node destination = graph.getNodesHeap().get(destinationId);

        final LinkedList<Node> nextToVisit = new LinkedList<>();
        final HashSet<Integer> visited = new HashSet<>();

        nextToVisit.add(source);
        while (!nextToVisit.isEmpty()) {

            Node headNode = nextToVisit.remove();
            if (headNode.equals(destination)) {
                return true;
            }

            if (visited.contains(headNode.getId())) {
                continue;
            }
            visited.add(headNode.getId());

            // adding the next nodes
            nextToVisit.addAll(headNode.getAncestors());
        }

        return false;
    }

    int[] shortestReach(final Graph graph, int startNodeId) {
        final int NODE_DISTANCE = 1;
        final Node startNode = graph.getNodesHeap().get(startNodeId);
        final HashSet<Integer> visited = new HashSet<>();
        final int[] distances = new int[graph.getNodesHeap().size()];
        Arrays.fill(distances, -1); // initially all distances are -1

        final LinkedList<Node> nextToVisit = new LinkedList<>();
        nextToVisit.add(startNode);
        visited.add(startNode.getId());
        distances[startNodeId - 1] = 0;

        while (!nextToVisit.isEmpty()) {
            Node headNode = nextToVisit.remove();

            headNode.getAncestors().forEach(child -> {
                if (!visited.contains(child.getId())) {
                    nextToVisit.add(child);
                    visited.add(child.getId());

                    distances[child.getId() - 1] = distances[headNode.getId() - 1] + NODE_DISTANCE; // TODO: !!!! is fine?
                }
            });
        }

        return distances;
    }

    Set<Integer> calculateCommonAncestors(final Graph graph, int startNodeOneId, int startNodeTwoId) {

        final Node startNodeOne = graph.getNodesHeap().get(startNodeOneId);
        final GraphProcessingData nodeOneProcessing = new GraphProcessingData(graph.getNodesHeap().size());
        nodeOneProcessing.addNextToVisit(startNodeOne);
        nodeOneProcessing.addVisited(startNodeOne);
        nodeOneProcessing.setDistance(startNodeOne, 0);

        final Node startNodeTwo = graph.getNodesHeap().get(startNodeTwoId);
        final GraphProcessingData nodeTwoProcessing = new GraphProcessingData(graph.getNodesHeap().size());
        nodeTwoProcessing.addNextToVisit(startNodeTwo);
        nodeTwoProcessing.addVisited(startNodeTwo);
        nodeTwoProcessing.setDistance(startNodeTwo, 0);


        while (!nodeOneProcessing.getNextToVisit().isEmpty() && !nodeTwoProcessing.getNextToVisit().isEmpty()) {

            // we need to check all childes from this level
            List<Node> nextLevelAncestorsOne = iterateKnowsAncestorsBucket(nodeOneProcessing);
            nodeOneProcessing.getNextToVisit().addAll(nextLevelAncestorsOne);

            // we need to check all childes from this level
            List<Node> nextLevelAncestorsOTwo = iterateKnowsAncestorsBucket(nodeTwoProcessing);
            nodeTwoProcessing.getNextToVisit().addAll(nextLevelAncestorsOTwo);

            final Set<Integer> temp = new HashSet<>(nodeOneProcessing.getVisitedNodes());
            if (temp.retainAll(nodeTwoProcessing.getVisitedNodes()) && temp.size() > 0) {
                System.out.println(Arrays.toString(nodeOneProcessing.getDistances()));
                System.out.println(Arrays.toString(nodeTwoProcessing.getDistances()));
                return temp;
            }
        }

        return new HashSet<>();
    }

    private List<Node> iterateKnowsAncestorsBucket(final GraphProcessingData nodeProcessing) {
        List<Node> nextLevelAncestors = new ArrayList<>();

        // we need to check all childes from this level
        IntStream.range(0, nodeProcessing.getNextToVisit().size()).forEach((i) -> {
            final Node headNode = nodeProcessing.getNextToVisit().remove();

            headNode.getAncestors().forEach(child -> {
                if (!nodeProcessing.getVisitedNodes().contains(child.getId())) {
//                    nodeProcessing.getNextToVisit().add(child);
                    nodeProcessing.getVisitedNodes().add(child.getId());
                    nodeProcessing.setDistance(child, nodeProcessing.getDistanceToNode(headNode) + NODE_DISTANCE);

                    nextLevelAncestors.add(child);
                }
            });

        });

        return nextLevelAncestors;
    }
}
