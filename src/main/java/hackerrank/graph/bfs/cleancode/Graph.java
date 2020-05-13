package hackerrank.graph.bfs.cleancode;

import java.util.HashMap;

public class Graph {
    private HashMap<Integer, Node> nodesHeap = new HashMap<>();
    private boolean bidirectional;

    public Graph(final boolean bidirectional) {
        this.bidirectional = bidirectional;
    }

    public HashMap<Integer, Node> getNodesHeap() {
        return nodesHeap;
    }

    public void addNode(int id) {
        nodesHeap.put(id, new Node(id));
    }

    public Node getNode(int id) {
        return nodesHeap.get(id);
    }

    public void addEdge(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        s.getAncestors().add(d);

        if (bidirectional) {
            d.getAncestors().add(s); // doing bidirectional
        }
    }
}
