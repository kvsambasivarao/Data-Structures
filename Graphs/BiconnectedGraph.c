/* File Name: BiconnectedGraph.c */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int timeCounter = 0;

void addEdge(int **graph, int u, int v) {
    graph[u][v] = 1;
    graph[v][u] = 1;
}

void APUtil(int u, int V, bool visited[], int disc[],
            int low[], int parent[], bool ap[], int **graph) {

    int children = 0;
    visited[u] = true;
    disc[u] = low[u] = ++timeCounter;

    for (int v = 0; v < V; v++) {

        if (graph[u][v]) {

            if (!visited[v]) {
                children++;
                parent[v] = u;
                APUtil(v, V, visited, disc, low, parent, ap, graph);

                low[u] = (low[u] < low[v]) ? low[u] : low[v];

                if (parent[u] == -1 && children > 1)
                    ap[u] = true;

                if (parent[u] != -1 && low[v] >= disc[u])
                    ap[u] = true;

            } else if (v != parent[u]) {
                low[u] = (low[u] < disc[v]) ? low[u] : disc[v];
            }
        }
    }
}

void DFS(int v, int V, bool visited[], int **graph) {
    visited[v] = true;
    for (int i = 0; i < V; i++)
        if (graph[v][i] && !visited[i])
            DFS(i, V, visited, graph);
}

int main() {

    int V, E;

    printf("Enter number of vertices: ");
    scanf("%d", &V);

    printf("Enter number of edges: ");
    scanf("%d", &E);

    int **graph = (int **)malloc(V * sizeof(int *));
    for (int i = 0; i < V; i++) {
        graph[i] = (int *)calloc(V, sizeof(int));
    }

    printf("Enter edges (u v):\n");
    for (int i = 0; i < E; i++) {
        int u, v;
        scanf("%d %d", &u, &v);
        addEdge(graph, u, v);
    }

    bool visited[V], ap[V];
    int disc[V], low[V], parent[V];

    for (int i = 0; i < V; i++) {
        visited[i] = false;
        ap[i] = false;
        parent[i] = -1;
    }

    APUtil(0, V, visited, disc, low, parent, ap, graph);

    int ap_count = 0, leaf_count = 0;

    for (int i = 0; i < V; i++) {
        if (ap[i]) ap_count++;

        int degree = 0;
        for (int j = 0; j < V; j++)
            if (graph[i][j]) degree++;

        if (degree == 1)
            leaf_count++;
    }

    bool connected = true;
    for (int i = 0; i < V; i++)
        if (!visited[i])
            connected = false;

    printf("\nIs Graph Biconnected: %s\n",
           (connected && ap_count == 0) ? "Yes" : "No");

    printf("Number of Articulation Points: %d\n", ap_count);
    printf("Number of Node Leaves: %d\n", leaf_count);

    return 0;
}
