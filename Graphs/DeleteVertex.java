// File Name: DeleteVertex.java

import java.util.*;

public class DeleteVertex {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int vertices;

    static void deleteVertex(int v) {
        if (v >= vertices) {
            System.out.println("Invalid vertex!");
            return;
        }

        // Remove all edges to this vertex
        for (int i = 0; i < vertices; i++) {
            graph.get(i).remove(Integer.valueOf(v));
        }

        // Remove the vertex list
        graph.remove(v);

        // Adjust vertex numbers in adjacency lists
        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                if (graph.get(i).get(j) > v) {
                    graph.get(i).set(j, graph.get(i).get(j) - 1);
                }
            }
        }

        vertices--;
        System.out.println("Vertex " + v + " deleted successfully.");
    }

    static void displayGraph() {
        System.out.println("\nAdjacency List:");
        for (int i = 0; i < graph.size(); i++) {
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
            System.out.println("\n1. Delete Vertex\n2. Display Graph\n3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter vertex to delete: ");
                    int v = sc.nextInt();
                    deleteVertex(v);
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
