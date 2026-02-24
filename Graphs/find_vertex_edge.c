/* File Name: find_vertex_edge.c */

#include <stdio.h>
#include <stdlib.h>

#define MAX 100

int graph[MAX][MAX];
int vertices;

void findVertex(int v) {
    if (v >= 0 && v < vertices)
        printf("Vertex %d exists in the graph.\n", v);
    else
        printf("Vertex does not exist!\n");
}

void findEdge(int u, int v) {
    if (u >= vertices || v >= vertices) {
        printf("Invalid vertices!\n");
        return;
    }

    if (graph[u][v] == 1)
        printf("Edge exists between %d and %d.\n", u, v);
    else
        printf("Edge does not exist!\n");
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
    int choice, u, v;

    printf("Enter number of vertices: ");
    scanf("%d", &vertices);

    while (1) {
        printf("\n1. Find Vertex\n2. Find Edge\n3. Display Graph\n4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter vertex to find: ");
                scanf("%d", &v);
                findVertex(v);
                break;
            case 2:
                printf("Enter two vertices (u v): ");
                scanf("%d %d", &u, &v);
                findEdge(u, v);
                break;
            case 3:
                displayGraph();
                break;
            case 4:
                exit(0);
            default:
                printf("Invalid choice\n");
        }
    }
}
