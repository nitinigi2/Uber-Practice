package src.com.GS;

import java.util.*;

public class ShortestPath {
    private static Map<Integer, List<Integer>> graph = new HashMap<>();

    public static void main(String[] args) {
        // No of vertices
        int v = 8;

        for (int i = 0; i < 8; i++) {
            graph.put(i, new ArrayList<>());
        }
        addEdge(0, 1);
        addEdge(0, 3);
        addEdge(1, 2);
        addEdge(3, 4);
        addEdge(3, 7);
        addEdge(4, 5);
        addEdge(4, 6);
        addEdge(4, 7);
        addEdge(5, 6);
        addEdge(6, 7);
        int source = 0, dest = 7;

        //System.out.println(graph);
        printShortestDistance(source, dest, v);

    }

    private static void printShortestDistance(int src, int dest, int v) {
        int[] distance = new int[v];
        Arrays.fill(distance, -1);
        distance[src] = 0;
        Map<Integer, Integer> paths = new HashMap<>();

        boolean isPathAvailable = bfs(src, dest, v, distance, paths);

        System.out.println(paths);

        if (!isPathAvailable) {
            System.out.println("I didn't find any path");
            return;
        }

        List<Integer> shortestPath = new ArrayList<>();
        shortestPath.add(dest);
        while (paths.containsKey(dest)) {
            dest = paths.get(dest);
            shortestPath.add(dest);
        }

        Collections.reverse(shortestPath);
        System.out.println(shortestPath);
    }

    private static boolean bfs(int src, int dest, int v, int[] distance, Map<Integer, Integer> paths) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v];

        queue.add(src);
        visited[src] = true;

        while (!queue.isEmpty()) {
            int visitedNode = queue.poll();
            for (int i = 0; i < graph.get(visitedNode).size(); i++) {
                int adj = graph.get(visitedNode).get(i);
                if (!visited[adj]) {
                    visited[adj] = true;
                    distance[adj] = distance[adj] + 1;
                    paths.put(adj, visitedNode);
                    queue.add(adj);

                    if (adj == dest) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void addEdge(int src, int dest) {
        graph.get(src).add(dest);
        graph.get(dest).add(src);
    }
}
