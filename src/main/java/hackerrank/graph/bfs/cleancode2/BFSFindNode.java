package hackerrank.graph.bfs.cleancode2;

import java.util.Set;
import java.util.stream.Stream;

public class BFSFindNode {

    public static void main(String[] args) {
        final Graph graph = new Graph();

        int[][] parentChildPairs = new int[][] {
                {10, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 17},
                {4, 5}, {4, 8}, {8, 9}
        };

        Stream.of(parentChildPairs).forEach(edge -> {
            graph.addEdge(edge[0], edge[1]);
        });

        final GraphProcessorService gps = new GraphProcessorService();

        final Set<Integer> nodesWithZeroParents = gps.getNodesWithParentsNumber(graph, 0);
        System.out.println(nodesWithZeroParents);

        final Set<Integer> nodesWithOneParent = gps.getNodesWithParentsNumber(graph, 1);
        System.out.println(nodesWithOneParent);

        final boolean hasNodesCommonParent = gps.hasNodesCommonParent(graph, 6, 8);
        System.out.println(hasNodesCommonParent);
    }
}



