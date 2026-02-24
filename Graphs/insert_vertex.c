/* File Name: insert_vertex.c */

#include <stdio.h>
#include <stdlib.h>

#define MAX 100

int graph[MAX][MAX];   // Adjacency matrix
int vertices = 0;

void insertVertex() {
    vertices++;
    printf("Vertex %d inserted successfully.\n", vertices - 1);
}

void displayGraph() {
    printf("\nAdjacency Matrix:\n");
    for(int i = 0; i < vertices; i++) {
        for(int j = 0; j < vertices; j++) {
            printf("%d ", graph[i][j]);
        }
        printf("\n");
    }
}

int main() {
    int choice;

    while(1) {
        printf("\n1. Insert Vertex\n2. Display Graph\n3. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch(choice) {
            case 1:
                insertVertex();
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
