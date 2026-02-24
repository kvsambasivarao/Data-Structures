// File Name: Kruskal.java

import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int s, int d, int w) {
        src = s;
        dest = d;
        weight = w;
    }

    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

public class Kruskal {

    static int find(int parent[], int i) {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }

    static void union(int parent[], int x, int y) {
        int xroot = find(parent, x);
        int yroot = find(parent, y);
        parent[xroot] = yroot;
    }

    static void kruskal(List<Edge> edges, int vertices) {
        Collections.sort(edges);
        int[] parent = new int[vertices];

        for (int i = 0; i < vertices; i++)
            parent[i] = i;

        int count = 0;
        System.out.println("Edge \tWeight");

        for (Edge e : edges) {
            if (count == vertices - 1)
                break;

            int x = find(parent, e.src);
            int y = find(parent, e.dest);

            if (x != y) {
                System.out.println(e.src + " - " + e.dest + "\t" + e.weight);
                union(parent, x, y);
                count++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int edgesCount = sc.nextInt();

        List<Edge> edges = new ArrayList<>();

        System.out.println("Enter edges (source destination weight):");
        for (int i = 0; i < edgesCount; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new Edge(s, d, w));
        }

        kruskal(edges, vertices);
    }
}
