// File Name: DFSGraph.java

import java.util.*;

public class DFSGraph {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int neighbor : graph.get(v)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            graph.add(new ArrayList<>());

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);  // Undirected graph
        }

        System.out.print("Enter starting vertex for DFS: ");
        int start = sc.nextInt();

        System.out.print("DFS Traversal: ");
        dfs(start);
    }
}
