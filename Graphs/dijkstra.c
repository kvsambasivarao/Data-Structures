/* File Name: dijkstra.c */

#include <stdio.h>
#include <limits.h>

#define MAX 100

int minDistance(int dist[], int visited[], int vertices) {
    int min = INT_MAX, min_index;

    for (int v = 0; v < vertices; v++)
        if (!visited[v] && dist[v] <= min) {
            min = dist[v];
            min_index = v;
        }

    return min_index;
}

void dijkstra(int graph[MAX][MAX], int vertices, int src) {
    int dist[MAX];
    int visited[MAX];

    for (int i = 0; i < vertices; i++) {
        dist[i] = INT_MAX;
        visited[i] = 0;
    }

    dist[src] = 0;

    for (int count = 0; count < vertices - 1; count++) {
        int u = minDistance(dist, visited, vertices);
        visited[u] = 1;

        for (int v = 0; v < vertices; v++)
            if (!visited[v] && graph[u][v] &&
                dist[u] != INT_MAX &&
                dist[u] + graph[u][v] < dist[v])
                dist[v] = dist[u] + graph[u][v];
    }

    printf("Vertex \t Distance from Source\n");
    for (int i = 0; i < vertices; i++)
        printf("%d \t %d\n", i, dist[i]);
}

int main() {
    int vertices, graph[MAX][MAX], src;

    printf("Enter number of vertices: ");
    scanf("%d", &vertices);

    printf("Enter weighted adjacency matrix:\n");
    for (int i = 0; i < vertices; i++)
        for (int j = 0; j < vertices; j++)
            scanf("%d", &graph[i][j]);

    printf("Enter source vertex: ");
    scanf("%d", &src);

    dijkstra(graph, vertices, src);

    return 0;
}
