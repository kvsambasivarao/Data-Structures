// File Name: BiconnectedGraph.java

import java.util.*;

class BiconnectedGraph {

    private int V;
    private LinkedList<Integer>[] adj;
    private int time = 0;

    BiconnectedGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    void APUtil(int u, boolean[] visited, int[] disc,
                int[] low, int[] parent, boolean[] ap) {

        int children = 0;
        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (int v : adj[u]) {

            if (!visited[v]) {
                children++;
                parent[v] = u;
                APUtil(v, visited, disc, low, parent, ap);

                low[u] = Math.min(low[u], low[v]);

                if (parent[u] == -1 && children > 1)
                    ap[u] = true;

                if (parent[u] != -1 && low[v] >= disc[u])
                    ap[u] = true;

            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    boolean[] findArticulationPoints() {
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] ap = new boolean[V];

        Arrays.fill(parent, -1);

        for (int i = 0; i < V; i++)
            if (!visited[i])
                APUtil(i, visited, disc, low, parent, ap);

        return ap;
    }

    void DFS(int v, boolean[] visited) {
        visited[v] = true;
        for (int n : adj[v])
            if (!visited[n])
                DFS(n, visited);
    }

    boolean isConnected() {
        boolean[] visited = new boolean[V];
        DFS(0, visited);
        for (boolean v : visited)
            if (!v)
                return false;
        return true;
    }

    int countLeaves() {
        int count = 0;
        for (int i = 0; i < V; i++)
            if (adj[i].size() == 1)
                count++;
        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        BiconnectedGraph g = new BiconnectedGraph(V);

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.addEdge(u, v);
        }

        boolean[] ap = g.findArticulationPoints();

        int ap_count = 0;
        for (boolean b : ap)
            if (b) ap_count++;

        boolean is_biconnected = g.isConnected() && ap_count == 0;

        System.out.println("\nIs Graph Biconnected: " + is_biconnected);
        System.out.println("Number of Articulation Points: " + ap_count);
        System.out.println("Number of Node Leaves: " + g.countLeaves());

        sc.close();
    }
}
