// File Name: FloydWarshall.java

import java.util.*;

public class FloydWarshall {

    static final int INF = 99999;

    static void floydWarshall(int[][] graph, int vertices) {
        int[][] dist = new int[vertices][vertices];

        // Initialize
        for (int i = 0; i < vertices; i++)
            for (int j = 0; j < vertices; j++)
                dist[i][j] = graph[i][j];

        // Main algorithm
        for (int k = 0; k < vertices; k++)
            for (int i = 0; i < vertices; i++)
                for (int j = 0; j < vertices; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        // Print result
        System.out.println("Shortest distance matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        int[][] graph = new int[vertices][vertices];

        System.out.println("Enter weighted adjacency matrix (use 99999 for INF):");
        for (int i = 0; i < vertices; i++)
            for (int j = 0; j < vertices; j++)
                graph[i][j] = sc.nextInt();

        floydWarshall(graph, vertices);
    }
}
