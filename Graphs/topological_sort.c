/* File Name: topological_sort.c */

#include <stdio.h>
#include <stdlib.h>

#define MAX 100

int graph[MAX][MAX];
int visited[MAX];
int stack[MAX];
int top = -1;
int vertices;

void dfs(int v) {
    visited[v] = 1;

    for (int i = 0; i < vertices; i++) {
        if (graph[v][i] && !visited[i]) {
            dfs(i);
        }
    }

    stack[++top] = v;  // Push to stack after visiting neighbors
}

void topologicalSort() {
    for (int i = 0; i < vertices; i++)
        if (!visited[i])
            dfs(i);

    printf("Topological Order:\n");
    while (top >= 0)
        printf("%d ", stack[top--]);
}

int main() {
    int edges, u, v;

    printf("Enter number of vertices: ");
    scanf("%d", &vertices);

    printf("Enter number of edges: ");
    scanf("%d", &edges);

    // Initialize graph and visited
    for (int i = 0; i < vertices; i++) {
        visited[i] = 0;
        for (int j = 0; j < vertices; j++)
            graph[i][j] = 0;
    }

    printf("Enter directed edges (u v):\n");
    for (int i = 0; i < edges; i++) {
        scanf("%d %d", &u, &v);
        graph[u][v] = 1;   // Directed graph
    }

    topologicalSort();

    return 0;
}
