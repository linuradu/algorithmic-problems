package hackerrank.graph.bfs.cleancode2;

import java.util.HashMap;
import java.util.Map;

public class Graph {
    private Map<Integer, Node> nodesHeap = new HashMap<>();

    public Map<Integer, Node> getNodesHeap() {
        return nodesHeap;
    }

    public void addEdge(final Integer ancestorNodeId, final Integer childNodeId) {
        final Node ancestorNode = getOrCreateNode(ancestorNodeId);
        final Node childNode = getOrCreateNode(childNodeId);
        childNode.addAncestor(ancestorNode);
    }

    /**
     * Return the existing node by the given key or
     * a new created one in case of absence.
     *
     * @param id the node id to get.
     * @return the node.
     */
    private Node getOrCreateNode(final Integer id) {
        // create new node if does not exists
        if (!nodesHeap.containsKey(id)) {
            nodesHeap.put(id, new Node(id));
        }
        return nodesHeap.get(id);
    }
}
