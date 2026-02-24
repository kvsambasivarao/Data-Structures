/* File Name: bellman_ford.c */

#include <stdio.h>
#include <limits.h>

#define MAX 100

struct Edge {
    int src, dest, weight;
};

void bellmanFord(struct Edge edges[], int vertices, int edgesCount, int src) {
    int dist[MAX];

    for (int i = 0; i < vertices; i++)
        dist[i] = INT_MAX;

    dist[src] = 0;

    // Relax edges V-1 times
    for (int i = 1; i <= vertices - 1; i++) {
        for (int j = 0; j < edgesCount; j++) {
            int u = edges[j].src;
            int v = edges[j].dest;
            int w = edges[j].weight;

            if (dist[u] != INT_MAX && dist[u] + w < dist[v])
                dist[v] = dist[u] + w;
        }
    }

    // Check for negative weight cycles
    for (int j = 0; j < edgesCount; j++) {
        int u = edges[j].src;
        int v = edges[j].dest;
        int w = edges[j].weight;

        if (dist[u] != INT_MAX && dist[u] + w < dist[v]) {
            printf("Graph contains negative weight cycle\n");
            return;
        }
    }

    printf("Vertex\tDistance from Source\n");
    for (int i = 0; i < vertices; i++)
        printf("%d\t%d\n", i, dist[i]);
}

int main() {
    int vertices, edgesCount, src;

    printf("Enter number of vertices: ");
    scanf("%d", &vertices);

    printf("Enter number of edges: ");
    scanf("%d", &edgesCount);

    struct Edge edges[MAX];

    printf("Enter edges (source destination weight):\n");
    for (int i = 0; i < edgesCount; i++)
        scanf("%d %d %d", &edges[i].src, &edges[i].dest, &edges[i].weight);

    printf("Enter source vertex: ");
    scanf("%d", &src);

    bellmanFord(edges, vertices, edgesCount, src);

    return 0;
}
