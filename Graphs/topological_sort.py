# File Name: topological_sort.py

def dfs(v, visited, stack, graph):
    visited[v] = True

    for neighbor in graph[v]:
        if not visited[neighbor]:
            dfs(neighbor, visited, stack, graph)

    stack.append(v)

vertices = int(input("Enter number of vertices: "))
edges = int(input("Enter number of edges: "))

graph = [[] for _ in range(vertices)]
visited = [False] * vertices
stack = []

print("Enter directed edges (u v):")
for _ in range(edges):
    u, v = map(int, input().split())
    graph[u].append(v)

for i in range(vertices):
    if not visited[i]:
        dfs(i, visited, stack, graph)

print("Topological Order:")
while stack:
    print(stack.pop(), end=" ")
