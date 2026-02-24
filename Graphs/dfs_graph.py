# File Name: dfs_graph.py

def dfs(v, visited, graph):
    visited[v] = True
    print(v, end=" ")

    for neighbor in graph[v]:
        if not visited[neighbor]:
            dfs(neighbor, visited, graph)

vertices = int(input("Enter number of vertices: "))
edges = int(input("Enter number of edges: "))

graph = [[] for _ in range(vertices)]
visited = [False] * vertices

print("Enter edges (u v):")
for _ in range(edges):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)  # Undirected graph

start = int(input("Enter starting vertex for DFS: "))

print("DFS Traversal:", end=" ")
dfs(start, visited, graph)
