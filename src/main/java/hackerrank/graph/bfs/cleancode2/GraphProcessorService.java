package hackerrank.graph.bfs.cleancode2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GraphProcessorService {

    final Set<Integer> getNodesWithParentsNumber(final Graph graph, final int noOfParents) {
        return graph.getNodesHeap().values().stream()
                .filter(node -> node.getParentsCount() == noOfParents)
                .map(Node::getId).collect(Collectors.toSet());
    }

    /**
     * In order to have a more efficient way of finding if two nodes has common parents
     * we will process the ancestors of every node in parallel until will find the first
     * known ancestor
     *
     * @param graph        the graph
     * @param firstNodeId  the id of the first node
     * @param secondNodeId the id of the first node
     * @return true if the given nodes shares at leas one known ancestor, false otherwise.
     */
    public boolean hasNodesCommonParent(final Graph graph, int firstNodeId, int secondNodeId) {
        final Node firstNode = graph.getNodesHeap().get(firstNodeId);
        final GraphProcessingData firstNodeProcessing = new GraphProcessingData();
        firstNodeProcessing.addNextToVisit(firstNode);
        firstNodeProcessing.addVisited(firstNode);

        final Node secondNode = graph.getNodesHeap().get(secondNodeId);
        final GraphProcessingData secondNodeProcessing = new GraphProcessingData();
        secondNodeProcessing.addNextToVisit(secondNode);
        secondNodeProcessing.addVisited(secondNode);

        while (!firstNodeProcessing.getNextToVisit().isEmpty() && !secondNodeProcessing.getNextToVisit().isEmpty()) {
            // we need to check all ancestors from this level
            final List<Node> nextLevelAncestorsOne = iterateKnowsAncestorsBucket(firstNodeProcessing);
            firstNodeProcessing.getNextToVisit().addAll(nextLevelAncestorsOne);

            // we need to check all ancestors from this level
            final List<Node> nextLevelAncestorsOTwo = iterateKnowsAncestorsBucket(secondNodeProcessing);
            secondNodeProcessing.getNextToVisit().addAll(nextLevelAncestorsOTwo);

            // Verify if the targeted nodes shares at least one knows ancestor
            final Set<Integer> temp = new HashSet<>(firstNodeProcessing.getVisitedNodes());
            if (temp.retainAll(secondNodeProcessing.getVisitedNodes()) && !temp.isEmpty()) {
                return true;
            }
        }

        return false;
    }

    /**
     * Iterating over all known ancestors from this level.
     *
     * @param nodeProcessing the node processing data
     * @return the list of the ancestors from the nex level to be processed
     */
    private List<Node> iterateKnowsAncestorsBucket(final GraphProcessingData nodeProcessing) {
        final List<Node> nextLevelAncestors = new LinkedList<>();

        // we need to check all childes from this level
        IntStream.range(0, nodeProcessing.getNextToVisit().size()).forEach(index -> {
            final Node headNode = nodeProcessing.getNextToVisit().remove();
            headNode.getAncestors().forEach(child -> {
                if (!nodeProcessing.getVisitedNodes().contains(child.getId())) {
                    nodeProcessing.getVisitedNodes().add(child.getId());
                    nextLevelAncestors.add(child);
                }
            });
        });

        return nextLevelAncestors;
    }
}
