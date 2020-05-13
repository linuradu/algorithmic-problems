package hackerrank.graph.bfs._initial;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;
import java.util.stream.IntStream;

public class BFSFindNode {

    public static void main(String[] args) {
        System.out.println("starting");

        Graph g = new Graph();
        for (int i = 1; i <= 14; i++) {
            g.addNode(i);
        }
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);
        g.addEdge(3, 7);
        g.addEdge(4, 8);
        g.addEdge(4, 10);
        g.addEdge(5, 10);
        g.addEdge(6, 10);
        g.addEdge(8, 9);
        g.addEdge(9, 11);
        g.addEdge(9, 12);
        g.addEdge(10, 12);
        g.addEdge(10, 13);
        g.addEdge(11, 12);
        g.addEdge(13, 14);

        System.out.println(g.hasPathBFS(7, 14));

//        int[] shortestReach = g.shortestReach(1);
//        for (int i = 0; i < shortestReach.length; i++) {
//            System.out.println(i + 1 + " " + shortestReach[i]);
//        }
//
//        System.out.println();
//        int[] shortestReach2 = g.shortestReach(10);
//        for (int i = 0; i < shortestReach2.length; i++) {
//            System.out.println(i + 1 + " " + shortestReach2[i]);
//        }

//        List<Distance> distancesList =  IntStream.range(0, shortestReach.length).mapToObj(index -> new Distance(index+1, shortestReach[index])).collect(Collectors.toList());
//        Map<Integer, List<Distance>> groupedByDistance = distancesList.stream().collect(Collectors.groupingBy(i -> i.distance));


//        System.out.println();

        Set<Integer> nearestCommonAncestors = g.commonAncestors(1, 11);
        nearestCommonAncestors.forEach(System.out::println);
    }


    static class Graph {
        private HashMap<Integer, Node> nodesHeap = new HashMap<>();

        public Node getNode(int id) {
            return nodesHeap.get(id);
        }

        public void addNode(int id) {
            nodesHeap.put(id, new Node(id));
        }

        public void addEdge(int source, int destination) {
            Node s = getNode(source);
            Node d = getNode(destination);
            s.getAdjacent().add(d);
            d.getAdjacent().add(s); // doing bidirectional
        }

        public boolean hasPathBFS(int sourceId, int destinationId) {
            final Node source = nodesHeap.get(sourceId);
            final Node destination = nodesHeap.get(destinationId);

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
                nextToVisit.addAll(headNode.getAdjacent());
            }

            return false;
        }

        int[] shortestReach(int startNodeId) {
            final int NODE_DISTANCE = 1;
            final Node startNode = nodesHeap.get(startNodeId);
            final HashSet<Integer> visited = new HashSet<>();
            final int[] distances = new int[nodesHeap.size()];
            Arrays.fill(distances, -1); // initially all distances are -1

            final LinkedList<Node> nextToVisit = new LinkedList<>();
            nextToVisit.add(startNode);
            visited.add(startNode.getId());
            distances[startNodeId - 1] = 0;

            while (!nextToVisit.isEmpty()) {
                Node headNode = nextToVisit.remove();

                headNode.getAdjacent().forEach(child -> {
                    if (!visited.contains(child.getId())) {
                        nextToVisit.add(child);
                        visited.add(child.getId());

                        distances[child.getId() - 1] = distances[headNode.getId() - 1] + NODE_DISTANCE; // TODO: !!!! is fine?
                    }
                });
            }

            return distances;
        }

        Set<Integer> commonAncestors(int startNodeOneId, int startNodeTwoId) {
            final int NODE_DISTANCE = 1;
            final Node startNodeOne = nodesHeap.get(startNodeOneId);
            final Node startNodeTwo = nodesHeap.get(startNodeTwoId);

            final HashSet<Integer> visitedOne = new HashSet<>();
            final int[] distancesOne = new int[nodesHeap.size()];
            Arrays.fill(distancesOne, -1); // initially all distancesOne are -1

            final HashSet<Integer> visitedTwo = new HashSet<>();
            final int[] distancesTwo = new int[nodesHeap.size()];
            Arrays.fill(distancesTwo, -1); // initially all distancesOne are -1


            final LinkedList<Node> nextToVisitOne = new LinkedList<>();
            nextToVisitOne.add(startNodeOne);
            visitedOne.add(startNodeOne.getId());
            distancesOne[startNodeOneId - 1] = 0;

            final LinkedList<Node> nextToVisitTwo = new LinkedList<>();
            nextToVisitTwo.add(startNodeTwo);
            visitedTwo.add(startNodeTwo.getId());
            distancesTwo[startNodeTwoId - 1] = 0;


            while (!nextToVisitOne.isEmpty() && !nextToVisitTwo.isEmpty()) {

                // we need to check all childes from this level
                IntStream.range(0, nextToVisitOne.size()).forEach((i) -> {
                    Node headNodeOne = nextToVisitOne.remove();

                    headNodeOne.getAdjacent().forEach(child -> {
                        if (!visitedOne.contains(child.getId())) {
                            nextToVisitOne.add(child);
                            visitedOne.add(child.getId());

                            distancesOne[child.getId() - 1] = distancesOne[headNodeOne.getId() - 1] + NODE_DISTANCE;
                        }
                    });

                });

                // we need to check all childes from this level
                IntStream.range(0, nextToVisitTwo.size()).forEach((i) -> {
                    Node headNodeTwo = nextToVisitTwo.remove();

                    headNodeTwo.getAdjacent().forEach(child -> {
                        if (!visitedTwo.contains(child.getId())) {
                            nextToVisitTwo.add(child);
                            visitedTwo.add(child.getId());

                            distancesTwo[child.getId() - 1] = distancesTwo[headNodeTwo.getId() - 1] + NODE_DISTANCE;
                        }
                    });
                });

                Set<Integer> temp = new HashSet<>(visitedOne);
                if (temp.retainAll(visitedTwo) && temp.size() > 0) {
                    System.out.println(Arrays.toString(distancesOne));
                    System.out.println(Arrays.toString(distancesTwo));
                    return temp;
                }
            }


            return new HashSet<>();
        }
    }

    class Distance {
        int nodeId;
        int distance;

        public Distance(final int nodeId, final int distance) {
            this.nodeId = nodeId;
            this.distance = distance;
        }
    }

    static class Node {
        private int id;
        private LinkedList<Node> adjacent = new LinkedList<>(); // can be ArrayList

        public Node(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public LinkedList<Node> getAdjacent() {
            return adjacent;
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

}



