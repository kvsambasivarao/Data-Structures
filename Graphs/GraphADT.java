// File Name: GraphADT.java

import java.util.*;

class GraphADT {

    private Map<Integer, List<Integer>> adj = new HashMap<>();

    public void insertVertex(int v) {
        adj.putIfAbsent(v, new ArrayList<>());
    }

    public void insertEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public void deleteEdge(int u, int v) {
        adj.get(u).remove(Integer.valueOf(v));
        adj.get(v).remove(Integer.valueOf(u));
    }

    public void deleteVertex(int v) {
        adj.remove(v);
        for (List<Integer> list : adj.values()) {
            list.remove(Integer.valueOf(v));
        }
    }

    public void display() {
        for (int v : adj.keySet()) {
            System.out.println(v + " -> " + adj.get(v));
        }
    }

    public void BFS(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");
            for (int n : adj.get(v)) {
                if (!visited.contains(n)) {
                    visited.add(n);
                    queue.add(n);
                }
            }
        }
    }

    public void DFS(int start, Set<Integer> visited) {
        visited.add(start);
        System.out.print(start + " ");
        for (int n : adj.get(start)) {
            if (!visited.contains(n)) {
                DFS(n, visited);
            }
        }
    }

    public static void main(String[] args) {
        GraphADT g = new GraphADT();
        g.insertVertex(0);
        g.insertVertex(1);
        g.insertVertex(2);

        g.insertEdge(0,1);
        g.insertEdge(1,2);

        System.out.println("Graph:");
        g.display();

        System.out.print("BFS: ");
        g.BFS(0);

        System.out.print("\nDFS: ");
        g.DFS(0, new HashSet<>());
    }
}
