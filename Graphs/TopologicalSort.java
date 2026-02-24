// File Name: TopologicalSort.java

import java.util.*;

public class TopologicalSort {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static Stack<Integer> stack = new Stack<>();

    static void dfs(int v) {
        visited[v] = true;

        for (int neighbor : graph.get(v)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }

        stack.push(v);
    }

    static void topologicalSort(int vertices) {
        for (int i = 0; i < vertices; i++) {
            if (!visited[i])
                dfs(i);
        }

        System.out.println("Topological Order:");
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
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

        System.out.println("Enter directed edges (u v):");
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);  // Directed edge
        }

        topologicalSort(vertices);
    }
}
