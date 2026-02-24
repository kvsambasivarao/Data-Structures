// File Name: FindVertexEdge.java

import java.util.*;

public class FindVertexEdge {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int vertices;

    static void findVertex(int v) {
        if (v >= 0 && v < vertices)
            System.out.println("Vertex " + v + " exists in the graph.");
        else
            System.out.println("Vertex does not exist!");
    }

    static void findEdge(int u, int v) {
        if (u >= vertices || v >= vertices) {
            System.out.println("Invalid vertices!");
            return;
        }

        if (graph.get(u).contains(v))
            System.out.println("Edge exists between " + u + " and " + v);
        else
            System.out.println("Edge does not exist!");
    }

    static void displayGraph() {
        System.out.println("\nAdjacency List:");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + " -> " + graph.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        vertices = sc.nextInt();

        for (int i = 0; i < vertices; i++)
            graph.add(new ArrayList<>());

        while (true) {
            System.out.println("\n1. Find Vertex\n2. Find Edge\n3. Display Graph\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter vertex to find: ");
                    int v = sc.nextInt();
                    findVertex(v);
                    break;
                case 2:
                    System.out.print("Enter two vertices (u v): ");
                    int u = sc.nextInt();
                    int w = sc.nextInt();
                    findEdge(u, w);
                    break;
                case 3:
                    displayGraph();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
