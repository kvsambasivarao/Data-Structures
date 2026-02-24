/* File Name: delete_edge.c */

#include <stdio.h>
#include <stdlib.h>

#define MAX 100

int graph[MAX][MAX];
int vertices;

void deleteEdge(int u, int v) {
    if (u >= vertices || v >= vertices) {
        printf("Invalid vertices!\n");
        return;
    }

    if (graph[u][v] == 0) {
        printf("Edge does not exist!\n");
        return;
    }

    graph[u][v] = 0;
    graph[v][u] = 0;   // Undirected graph

    printf("Edge deleted between %d and %d\n", u, v);
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
        printf("\n1. Delete Edge\n2. Display Graph\n3. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter two vertices (u v): ");
                scanf("%d %d", &u, &v);
                deleteEdge(u, v);
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
