# File Name: dijkstra.py

import sys

def min_distance(dist, visited, vertices):
    min_val = sys.maxsize
    min_index = -1

    for v in range(vertices):
        if not visited[v] and dist[v] <= min_val:
            min_val = dist[v]
            min_index = v

    return min_index

def dijkstra(graph, vertices, src):
    dist = [sys.maxsize] * vertices
    visited = [False] * vertices

    dist[src] = 0

    for _ in range(vertices - 1):
        u = min_distance(dist, visited, vertices)
        visited[u] = True

        for v in range(vertices):
            if (not visited[v] and graph[u][v] != 0 and
                dist[u] != sys.maxsize and
                dist[u] + graph[u][v] < dist[v]):
                dist[v] = dist[u] + graph[u][v]

    print("Vertex \t Distance from Source")
    for i in range(vertices):
        print(i, "\t", dist[i])

vertices = int(input("Enter number of vertices: "))
graph = []

print("Enter weighted adjacency matrix:")
for _ in range(vertices):
    graph.append(list(map(int, input().split())))

src = int(input("Enter source vertex: "))

dijkstra(graph, vertices, src)
