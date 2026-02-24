# File Name: bellman_ford.py

import sys

def bellman_ford(vertices, edges, src):
    dist = [sys.maxsize] * vertices
    dist[src] = 0

    # Relax edges V-1 times
    for _ in range(vertices - 1):
        for u, v, w in edges:
            if dist[u] != sys.maxsize and dist[u] + w < dist[v]:
                dist[v] = dist[u] + w

    # Check for negative weight cycle
    for u, v, w in edges:
        if dist[u] != sys.maxsize and dist[u] + w < dist[v]:
            print("Graph contains negative weight cycle")
            return

    print("Vertex\tDistance from Source")
    for i in range(vertices):
        print(i, "\t", dist[i])

vertices = int(input("Enter number of vertices: "))
edgesCount = int(input("Enter number of edges: "))

edges = []
print("Enter edges (source destination weight):")
for _ in range(edgesCount):
    u, v, w = map(int, input().split())
    edges.append((u, v, w))

src = int(input("Enter source vertex: "))

bellman_ford(vertices, edges, src)
