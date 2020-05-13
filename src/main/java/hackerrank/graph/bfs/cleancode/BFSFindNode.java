package hackerrank.graph.bfs.cleancode;

import java.util.Set;

public class BFSFindNode {

    public static void main(String[] args) {
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


        graphExample1();

        graphExample2();
    }

    private static void graphExample1() {
        Graph g = new Graph(true);
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

        GraphProcessorService gps = new GraphProcessorService();

        Set<Integer> nearestCommonAncestors = gps.calculateCommonAncestors(g, 1, 13);
        nearestCommonAncestors.forEach(System.out::println);
    }

    private static void graphExample2() {
        Graph g = new Graph(true);
        for (int i = 1; i <= 16; i++) {
            g.addNode(i);
        }
        g.addEdge(2, 1);
        g.addEdge(3, 1);
        g.addEdge(4, 2);
        g.addEdge(5, 2);
        g.addEdge(6, 3);
        g.addEdge(7, 3);
        g.addEdge(8, 4);
        g.addEdge(9, 4);
        g.addEdge(10, 5);
        g.addEdge(11, 5);
        g.addEdge(12, 6);
        g.addEdge(13, 6);
        g.addEdge(14, 7);
        g.addEdge(15, 7);
        g.addEdge(16, 7);

        GraphProcessorService gps = new GraphProcessorService();
        Set<Integer> nearestCommonAncestors = gps.calculateCommonAncestors(g, 8, 9);
        nearestCommonAncestors.forEach(System.out::println);

    }

    private static void graphExample3() {
        Graph g = new Graph(true);
        for (int i = 1; i <= 16; i++) {
            g.addNode(i);
        }
        g.addEdge(2, 1);
        g.addEdge(3, 1);
        g.addEdge(4, 2);
        g.addEdge(5, 2);
        g.addEdge(6, 3);
        g.addEdge(7, 3);
        g.addEdge(8, 4);
        g.addEdge(9, 4);
        g.addEdge(10, 5);
        g.addEdge(11, 5);
        g.addEdge(12, 6);
        g.addEdge(13, 6);
        g.addEdge(14, 7);
        g.addEdge(15, 7);
        g.addEdge(16, 7);

        GraphProcessorService gps = new GraphProcessorService();
        Set<Integer> nearestCommonAncestors = gps.calculateCommonAncestors(g, 8, 9);
        nearestCommonAncestors.forEach(System.out::println);

    }
}



