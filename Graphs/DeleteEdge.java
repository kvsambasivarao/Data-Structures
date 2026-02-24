// File Name: DeleteEdge.java

import java.util.*;

public class DeleteEdge {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int vertices;

    static void deleteEdge(int u, int v) {
        if (u >= vertices || v >= vertices) {
            System.out.println("Invalid vertices!");
            return;
        }

        if (!graph.get(u).contains(v)) {
            System.out.println("Edge does not exist!");
            return;
        }

        graph.get(u).remove(Integer.valueOf(v));
        graph.get(v).remove(Integer.valueOf(u));  // Undirected graph

        System.out.println("Edge deleted between " + u + " and " + v);
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

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        while (true) {
            System.out.println("\n1. Delete Edge\n2. Display Graph\n3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter two vertices (u v): ");
                    int u = sc.nextInt();
                    int v = sc.nextInt();
                    deleteEdge(u, v);
                    break;
                case 2:
                    displayGraph();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
