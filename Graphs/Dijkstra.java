// File Name: Dijkstra.java

import java.util.*;

public class Dijkstra {

    static int minDistance(int[] dist, boolean[] visited, int vertices) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < vertices; v++)
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }

        return minIndex;
    }

    static void dijkstra(int[][] graph, int vertices, int src) {
        int[] dist = new int[vertices];
        boolean[] visited = new boolean[vertices];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int count = 0; count < vertices - 1; count++) {
            int u = minDistance(dist, visited, vertices);
            visited[u] = true;

            for (int v = 0; v < vertices; v++)
                if (!visited[v] && graph[u][v] != 0 &&
                    dist[u] != Integer.MAX_VALUE &&
                    dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < vertices; i++)
            System.out.println(i + "\t" + dist[i]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        int[][] graph = new int[vertices][vertices];

        System.out.println("Enter weighted adjacency matrix:");
        for (int i = 0; i < vertices; i++)
            for (int j = 0; j < vertices; j++)
                graph[i][j] = sc.nextInt();

        System.out.print("Enter source vertex: ");
        int src = sc.nextInt();

        dijkstra(graph, vertices, src);
    }
}
