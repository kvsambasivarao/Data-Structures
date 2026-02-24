// File Name: InsertVertex.java

import java.util.*;

public class InsertVertex {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    static void insertVertex() {
        graph.add(new ArrayList<>());
        System.out.println("Vertex " + (graph.size() - 1) + " inserted successfully.");
    }

    static void displayGraph() {
        System.out.println("\nAdjacency List:");
        for (int i = 0; i < graph.size(); i++) {
            System.out.println(i + " -> " + graph.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n1. Insert Vertex\n2. Display Graph\n3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    insertVertex();
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
