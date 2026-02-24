# File Name: bfs_graph.py

from collections import deque

def bfs(start, visited, graph):
    queue = deque()
    visited[start] = True
    queue.append(start)

    while queue:
        current = queue.popleft()
        print(current, end=" ")

        for neighbor in graph[current]:
            if not visited[neighbor]:
                visited[neighbor] = True
                queue.append(neighbor)

vertices = int(input("Enter number of vertices: "))
edges = int(input("Enter number of edges: "))

graph = [[] for _ in range(vertices)]
visited = [False] * vertices

print("Enter edges (u v):")
for _ in range(edges):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)  # Undirected graph

start = int(input("Enter starting vertex for BFS: "))

print("BFS Traversal:", end=" ")
bfs(start, visited, graph)
