package hackerrank.graph.bfs.cleancode2;

import java.util.LinkedList;
import java.util.List;

class Node {
    private Integer id;
    private List<Node> ancestors = new LinkedList<>();

    public Node(final Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public List<Node> getAncestors() {
        return ancestors;
    }


    public int getParentsCount() {
        return ancestors.size();
    }

    public void addAncestor(final Node parentNode) {
        this.ancestors.add(parentNode);
    }
}
