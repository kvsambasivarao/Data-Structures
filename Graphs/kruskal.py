# File Name: kruskal.py

def find(parent, i):
    if parent[i] == i:
        return i
    return find(parent, parent[i])

def union(parent, x, y):
    xroot = find(parent, x)
    yroot = find(parent, y)
    parent[xroot] = yroot

def kruskal(vertices, edges):
    edges.sort(key=lambda x: x[2])
    parent = list(range(vertices))
    count = 0

    print("Edge \tWeight")

    for u, v, w in edges:
        if count == vertices - 1:
            break

        x = find(parent, u)
        y = find(parent, v)

        if x != y:
            print(f"{u} - {v}\t{w}")
            union(parent, x, y)
            count += 1

vertices = int(input("Enter number of vertices: "))
edgesCount = int(input("Enter number of edges: "))

edges = []
print("Enter edges (source destination weight):")
for _ in range(edgesCount):
    u, v, w = map(int, input().split())
    edges.append((u, v, w))

kruskal(vertices, edges)
