/* File Name: delete_vertex.c */

#include <stdio.h>
#include <stdlib.h>

#define MAX 100

int graph[MAX][MAX];
int vertices;

void deleteVertex(int v) {
    if (v >= vertices) {
        printf("Invalid vertex!\n");
        return;
    }

    // Shift rows up
    for (int i = v; i < vertices - 1; i++)
        for (int j = 0; j < vertices; j++)
            graph[i][j] = graph[i + 1][j];

    // Shift columns left
    for (int i = 0; i < vertices - 1; i++)
        for (int j = v; j < vertices - 1; j++)
            graph[i][j] = graph[i][j + 1];

    vertices--;
    printf("Vertex %d deleted successfully.\n", v);
}

void displayGraph() {
    printf("\nAdjacency Matrix:\n");
    for (int i = 0; i < vertices; i++) {
        for (int j = 0; j < vertices; j++)
            printf("%d ", graph[i][j]);
        printf("\n");
    }
}

int main() {
    int choice, v;

    printf("Enter number of vertices: ");
    scanf("%d", &vertices);

    while (1) {
        printf("\n1. Delete Vertex\n2. Display Graph\n3. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter vertex to delete: ");
                scanf("%d", &v);
                deleteVertex(v);
                break;
            case 2:
                displayGraph();
                break;
            case 3:
                exit(0);
            default:
                printf("Invalid choice\n");
        }
    }
    return 0;
}
