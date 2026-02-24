/* File Name: kruskal.c */

#include <stdio.h>
#include <stdlib.h>

#define MAX 100

struct Edge {
    int src, dest, weight;
};

int parent[MAX];

// Find operation (Disjoint Set)
int find(int i) {
    while (parent[i] != i)
        i = parent[i];
    return i;
}

// Union operation
void unionSet(int u, int v) {
    int u_root = find(u);
    int v_root = find(v);
    parent[u_root] = v_root;
}

// Compare edges for sorting
int compare(const void* a, const void* b) {
    return ((struct Edge*)a)->weight - ((struct Edge*)b)->weight;
}

void kruskal(struct Edge edges[], int vertices, int edgesCount) {
    int count = 0;
    int i = 0;

    qsort(edges, edgesCount, sizeof(edges[0]), compare);

    for (int v = 0; v < vertices; v++)
        parent[v] = v;

    printf("Edge \tWeight\n");

    while (count < vertices - 1 && i < edgesCount) {
        struct Edge next = edges[i++];
        int u = find(next.src);
        int v = find(next.dest);

        if (u != v) {
            printf("%d - %d \t%d\n", next.src, next.dest, next.weight);
            unionSet(u, v);
            count++;
        }
    }
}

int main() {
    int vertices, edgesCount;

    printf("Enter number of vertices: ");
    scanf("%d", &vertices);

    printf("Enter number of edges: ");
    scanf("%d", &edgesCount);

    struct Edge edges[MAX];

    printf("Enter edges (source destination weight):\n");
    for (int i = 0; i < edgesCount; i++)
        scanf("%d %d %d", &edges[i].src, &edges[i].dest, &edges[i].weight);

    kruskal(edges, vertices, edgesCount);

    return 0;
}
