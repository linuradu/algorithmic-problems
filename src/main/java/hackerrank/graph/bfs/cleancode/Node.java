package hackerrank.graph.bfs.cleancode;

import java.util.LinkedList;
import java.util.Objects;

class Node {
    private int id;
    private LinkedList<Node> ancestors = new LinkedList<>(); // can be ArrayList

    public Node(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public LinkedList<Node> getAncestors() {
        return ancestors;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Node node = (Node) o;
        return id == node.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
